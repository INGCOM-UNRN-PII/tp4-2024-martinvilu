package ar.unrn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * El nombre tiene que ser el mismo que la clase que testea
 * terminando con `Test` para funcionar.
 */
@DisplayName("Ejercicio 1")
class ArchivosTest {
    @Test
    void listadoTest() {
        Path raiz = Paths.get(".");
        try {
            Path[] archivos = Archivos.listado(raiz);
            for (Path p : archivos) {
                System.out.println(p.toString());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void leerInexistente() {
        Path readme = Paths.get(".", "noexiste");
        try {
            Archivos.leer(readme);
            Assertions.fail("Debió lanzar la excepcion");
        } catch (IOException exception) {
            ;
        }
    }

    @Test
    void testLeerArchivo() {
        Path readme = Paths.get(".", "README.md");
        try {
            Archivos.leer(readme);
        } catch (IOException exception) {
            ;
        }
    }

    /**
     * Con archivos, que tienen una preparación, es mucho más simple
     * probar varias cosas juntas.
     * <p>
     * En especial cuando tenemos una función que es opuesta a la otra
     * escribimos, leemos y vemos si lo que salió puede volver a entrar.
     */
    @Test
    @DisplayName("Completar que se esta probando")
    void testLectoEscritura() {
        Path temporario = Paths.get(".", "temporario");
        int[] arreglo = {1, 2, 4, 5, 6, 3, 7, 8, 9};
        int[] obtenido = null;
        Files.exists(temporario); // no debiera de existir
        try {
            Archivos.escribir(temporario, arreglo, true);
            int lineas = Archivos.lineasArchivo(temporario);
            Assertions.assertEquals(arreglo.length, lineas, "Lo que acabamos de escribir, debiera de ser correcto y contener la misma cantidad");
            obtenido = Archivos.cargar(temporario);
            Files.delete(temporario);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try {
            Archivos.lineasArchivo(temporario);
            Assertions.fail("El archivo debio ser borrado");
        } catch (IOException exception) {
            ;
        }
        Assertions.assertArrayEquals(arreglo, obtenido, "Lo que leimos no es lo mismo que escribimos");
    }
}
