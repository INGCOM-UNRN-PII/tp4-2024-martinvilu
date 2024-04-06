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
    public void testMaximoArregloNoNulo() {
        int[] arreglo = {5, 3, 9, 2, 8};
        assertEquals(9, Arreglos.maximo(arreglo));
    }

    @Test
    public void testMaximoArregloUnElemento() {
        int[] arreglo = {4};
        assertEquals(4, Arreglos.maximo(arreglo));
    }

    @Test
    public void testMaximoArregloValoresNegativos() {
        int[] arreglo = {-10, -5, -8, -3};
        assertEquals(-3, Arreglos.maximo(arreglo));
    }

    @Test
    public void testMinimoArregloNoNulo() {
        int[] arreglo = {5, 3, 9, 2, 8};
        assertEquals(2, Arreglos.minimo(arreglo));
    }

    @Test
    public void testMinimoArregloUnElemento() {
        int[] arreglo = {4};
        assertEquals(4, Arreglos.minimo(arreglo));
    }

    @Test
    public void testMinimoArregloValoresNegativos() {
        int[] arreglo = {-10, -5, -8, -3};
        assertEquals(-10, Arreglos.minimo(arreglo));
    }

    @Test
    public void testEncontrarElementoExistente() {
        int[] arreglo = {5, 10, 15, 20, 25};
        int buscado = 15; // Buscar el elemento con valor 15
        assertEquals(2, Arreglos.encontrar(arreglo, buscado));
    }

    @Test
    public void testEncontrarElementoNoExistente() {
        int[] arreglo = {2, 4, 6, 8, 10};
        int buscado = 15; // Buscar el elemento con valor 15 (no existe en el arreglo)
        assertEquals(-1, Arreglos.encontrar(arreglo, buscado));
    }

    @Test
    public void testEncontrarElementoRepetido() {
        int[] arreglo = {10, 20, 30, 20, 40};
        int buscado = 20; // Buscar el elemento con valor 20 (repetido)
        assertEquals(1, Arreglos.encontrar(arreglo, buscado));
    }

    @Test
    public void testMedioArregloNoNulo() {
        int[] arreglo = {5, 10, 15, 20, 25};
        assertEquals(15, Arreglos.medio(arreglo));
    }

    @Test
    public void testMedioArregloValoresNegativos() {
        int[] arreglo = {-10, -5, 0, 5, 10};
        assertEquals(0, Arreglos.medio(arreglo));
    }

    @Test
    public void testMedioArregloConRepetidos() {
        int[] arreglo = {100, 200, 300, 150, 250};
        assertEquals(150, Arreglos.medio(arreglo));
    }

    @Test
    public void testMedioArregloUnElemento() {
        int[] arreglo = {8};
        assertEquals(8, Arreglos.medio(arreglo));
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