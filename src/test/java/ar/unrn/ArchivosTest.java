package ar.unrn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * El nombre tiene que ser el mismo que la clase que testea
 * terminando con `Test` para funcionar.
 */
@DisplayName("Ejercicio 1")
class ArchivosTest {

    /**
     * Este test es una plantilla.
     */
    @Test
    @DisplayName("Completar que se esta probando")
    void testLectoEscritura() {
        Path temporario = Paths.get(".", "temporario");
        int[] arreglo = {1,2,4,5,6,3,7,8,9};
        int[] obtenido;
        Files.exists(temporario); // no debiera de existir

        Archivos.escribir(temporario, arreglo);
        obtenido = Archivos.cargar(temporario);

        Assertions.assertArrayEquals(arreglo, obtenido, "Lo que leimos no es lo mismo que escribimos");

    }
}
