package ar.unrn;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Archivos {
    /**
     * Este bloque es chico a propósito para probar la auto-expansión
     * del arreglo.
     */
    public static final int TAMANO_BLOQUE_PATHS = 3;

    /**
     * Esta función devuelve un arreglo con los Paths presentes
     * en la ruta indicada.
     *
     * @param pwd la ruta a procesar.
     * @return los archivos contenidos
     * @throws IOException      con errores de permisos y otros.
     * @throws ArchivoException cuando no es un directorio.
     */
    public static Path[] listado(Path pwd) throws IOException {
        Path[] retorno = new Path[TAMANO_BLOQUE_PATHS];
        DirectoryStream<Path> stream
                = Files.newDirectoryStream(pwd);
        int i = 0;
        int bloques = 1;
        for (Path contenido : stream) {
            retorno[i] = contenido;
            i++;
            if (i >= (TAMANO_BLOQUE_PATHS * bloques)) {
                bloques++;
                retorno = Arrays.copyOf(retorno, TAMANO_BLOQUE_PATHS * bloques);
            }
        }
        stream.close();
        return Arrays.copyOf(retorno, i);
    }

    /**
     * Esta función lee el contenido del archivo a una cadena.
     *
     * @param archivo a leer.
     * @return el contenido del archivo
     * @throws IOException              cuando la lectura del archivo falla
     * @throws ArchivoException         cuando no era un archivo.
     * @throws ArchivoNoExisteException cuando el archivo no es legible
     * @throws ArchivoIlegibleException cuando el archivo no existe o no contiene texto.
     */
    public static String leer(Path archivo) throws IOException {
        if (Files.notExists(archivo)) {
            throw new ArchivoNoExisteException("El archivo indicado no existe");
        }
        if (!Files.isRegularFile(archivo)) {
            throw new ArchivoException("No era un archivo");
        }
        if (!Files.isReadable(archivo)) {
            throw new ArchivoIlegibleException("El archivo no es legible.");
        }
        if (!Files.probeContentType(archivo).startsWith("text")) {
            throw new ArchivoIlegibleException("El archivo no contiene texto");
        }
        return Files.readString(archivo);
    }

    /**
     * Esta función llama a leer y luego intenta convertir el archivo a
     * un arreglo.
     *
     * @param archivo que será pasado a leer.
     * @return el arreglo leído del archivo
     * @throws IOException      por problemas de lectura
     * @throws ArchivoException según leer; cuando el archivo no es legible
     */
    public static int[] cargar(Path archivo) throws IOException {
        return Arreglos.aArreglo(leer(archivo));
    }

    /**
     * Indica cuantos números hay en un archivo o una excepcion cuando no sea posible.
     *
     * @param archivo la ruta a lo que será procesado
     * @return si es correcto o no.
     * @throws IOException      por si no fue posible acceder al archivo indicado.
     * @throws ArchivoException cuando el archivo no pudo ser leído correctamente
     */
    public static int lineasArchivo(Path archivo) throws IOException {
        String contenido = leer(archivo);
        int lineasEsperadas = Arreglos.lineasEnCadena(contenido);
        int[] arreglo = Arreglos.aArreglo(contenido);
        if (arreglo.length != lineasEsperadas) {
            throw new ArchivoException("El archivo no es correcto");
        }
        return arreglo.length;
    }

    /**
     * Esta función se encarga de guardar el arreglo en el archivo indicado.
     *
     * @param archivo    el destino del archivo.
     * @param arreglo    a guardar.
     * @param reemplazar si el archivo existía, se lo borra y crea de nuevo.
     * @throws IOException      por toda clase de problemas de permisos.
     * @throws ArchivoException cuando el archivo ya existía y no se indicó reemplazarlo.
     */
    public static void escribir(Path archivo, int[] arreglo, boolean reemplazar) throws IOException {

        if (Files.exists(archivo)) {
            if (reemplazar) {
                Files.delete(archivo);
            } else {
                throw new ArchivoException("El archivo existía y no se eligió reemplazarlo");
            }
        }
        Files.createFile(archivo);
        Files.writeString(archivo, Arreglos.aCadena(arreglo));
    }
}
