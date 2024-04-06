package ar.unrn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArreglosTest {

    @Test
    public void testInvierteArregloImpar() {
        int[] arreglo = {1, 2, 3, 4, 5};
        int[] resultadoEsperado = {5, 4, 3, 2, 1};
        assertArrayEquals(resultadoEsperado, Arreglos.invierte(arreglo));
    }

    @Test
    public void testInvierteArregloPar() {
        int[] arreglo = {10, 20, 30, 40};
        int[] resultadoEsperado = {40, 30, 20, 10};
        assertArrayEquals(resultadoEsperado, Arreglos.invierte(arreglo));
    }

    @Test
    public void testInvierteArregloVacio() {
        int[] arreglo = {};
        try {
            Arreglos.invierte(arreglo);
            fail("Se esperaba que lanzara ArregloException");
        } catch (ArregloException ignorado) {
            ;
        }
    }

    @Test
    public void testCompararArreglosIguales() {
        int[] arreglo1 = {1, 2, 3};
        int[] arreglo2 = {1, 2, 3};
        assertTrue(Arreglos.comparar(arreglo1, arreglo2));
    }

    @Test
    public void testCompararArreglosDiferentes() {
        int[] arreglo1 = {1, 2, 3};
        int[] arreglo2 = {3, 2, 1};
        assertFalse(Arreglos.comparar(arreglo1, arreglo2));
    }

    @Test
    public void testCompararArreglosNulos() {
        int[] arreglo1 = null;
        int[] arreglo2 = {1, 2, 3};
        try {
            Arreglos.comparar(arreglo1, arreglo2);
            fail("Se esperaba que lanzara ArregloException");
        } catch (ArregloException ignorado) {
            ;
        }
    }

    @Test
    public void testRedimensionarArregloAumentar() {
        int[] arreglo = {1, 2, 3};
        int[] resultadoEsperado = {1, 2, 3, 0, 0, 0};
        assertArrayEquals(resultadoEsperado, Arreglos.redimensionar(arreglo, 6, 0));
    }

    @Test
    public void testRedimensionarArregloDisminuir() {
        int[] arreglo = {10, 20, 30, 40, 50};
        int[] resultadoEsperado = {10, 20};
        assertArrayEquals(resultadoEsperado, Arreglos.redimensionar(arreglo, 2, 0));
    }

    @Test
    public void testRedimensionarArregloRelleno() {
        int[] arreglo = {1, 2, 3};
        int[] resultadoEsperado = {1, 2, 3, 5, 5};
        assertArrayEquals(resultadoEsperado, Arreglos.redimensionar(arreglo, 5, 5));
    }

    @Test
    public void testDireccionOrdenArregloAscendente() {
        int[] arreglo = {1, 2, 3, 4, 5};
        assertEquals(1, Arreglos.direccionOrden(arreglo));
    }

    @Test
    public void testDireccionOrdenArregloDescendente() {
        int[] arreglo = {5, 4, 3, 2, 1};
        assertEquals(-1, Arreglos.direccionOrden(arreglo));
    }

    @Test
    public void testDireccionOrdenArregloDesordenado() {
        int[] arreglo = {3, 1, 5, 2, 4};
        assertEquals(0, Arreglos.direccionOrden(arreglo));
    }

    @Test
    public void testOrdenaArregloAscendente() {
        int[] arreglo = {5, 2, 8, 1, 4};
        int[] resultadoEsperado = {1, 2, 4, 5, 8};
        Arreglos.ordena(arreglo);
        assertArrayEquals(resultadoEsperado, arreglo);
    }

    @Test
    public void testOrdenaArregloDescendente() {
        int[] arreglo = {10, 8, 6, 4, 2};
        int[] resultadoEsperado = {2, 4, 6, 8, 10};
        Arreglos.ordena(arreglo);
        assertArrayEquals(resultadoEsperado, arreglo);
    }

    @Test
    public void testOrdenaArregloVacio() {
        int[] arreglo = {};
        try {
            Arreglos.ordena(arreglo);
            fail("Se esperaba que lanzara ArregloException");
        } catch (ArregloException ignorado) {
            ;
        }
    }

    @Test
    public void testGeneradorLinealCantidadPositiva() {
        int cantidad = 5;
        int inicio = 10;
        int[] resultadoEsperado = {10, 11, 12, 13, 14};
        assertArrayEquals(resultadoEsperado, Arreglos.generadorLineal(cantidad, inicio));
    }

    @Test
    public void testGeneradorLinealCantidadCero() {
        int cantidad = 0;
        int inicio = 5;
        int[] resultadoEsperado = {};
        assertArrayEquals(resultadoEsperado, Arreglos.generadorLineal(cantidad, inicio));
    }

    @Test
    public void testGeneradorLinealCantidadNegativa() {
        int cantidad = -3;
        int inicio = 1;
        try {
            int[] arreglo = Arreglos.generadorLineal(cantidad, inicio);
            fail("Se esperaba que lanzara ArregloException");
        } catch (ArregloException ignorado) {
            ;
        }
    }

    @Test
    public void testComprobarArregloNoNulo() {
        int[] arreglo = {1, 2, 3};
        try {
            Arreglos.comprobar(arreglo);
        } catch (ArregloException e) {
            fail("Se esperaba que lanzara ArregloException");
        }
    }

    @Test
    public void testComprobarArregloNulo() {
        int[] arreglo = null;
        try {
            Arreglos.comprobar(arreglo);
            fail("Se esperaba que lanzara ArregloException");
        } catch (ArregloException ignorado) {
            ;
        }
    }

    @Test
    public void testComprobarArregloLongitudCero() {
        int[] arreglo = {};
        try {
            Arreglos.comprobar(arreglo);
            fail("Se esperaba que lanzara ArregloException");
        } catch (ArregloException ignorado) {
            ;
        }
    }

    @Test
    public void testCopiarArregloNoNulo() {
        int[] arreglo = {1, 2, 3};
        int[] resultadoEsperado = {1, 2, 3};
        assertArrayEquals(resultadoEsperado, Arreglos.copiar(arreglo));
    }

    @Test
    public void testCopiarArregloVacio() {
        int[] arreglo = {};
        try {
            Arreglos.copiar(arreglo);
            fail("Se esperaba que lanzara ArregloException");
        } catch (ArregloException ignorado) {
            ;
        }
    }

    @Test
    public void testCopiarArregloConValoresNegativos() {
        int[] arreglo = {-1, -2, -3};
        int[] resultadoEsperado = {-1, -2, -3};
        assertArrayEquals(resultadoEsperado, Arreglos.copiar(arreglo));
    }

    @Test
    void estaOrdenado() {
    }

    @Test
    void lineasEnCadena() {
    }

    @Test
    void arregloACadena() {
    }

    @Test
    void cadenaAArreglo() {
    }

    @Test
    void comparar() {
    }
}