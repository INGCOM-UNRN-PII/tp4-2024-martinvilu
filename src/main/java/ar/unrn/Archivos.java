package ar.unrn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Archivos {

    public static boolean existe(Path archivo) throws IOException{
        return Files.exists(archivo);
    }

    public static int[] cargar(Path archivo) throws IOException {
        return Arreglos.cadenaAArreglo(Files.readString(archivo));
    }

    public static boolean esCorrecto(Path archivo, int lineasEsperadas)
            throws IOException {
        int[] contenido = cargar(archivo);
        return contenido.length == lineasEsperadas;
    }

    public static void escribir(Path archivo, int[] arreglo) throws IOException {
        Files.writeString(archivo, Arreglos.arregloACadena(arreglo));
    }


}
