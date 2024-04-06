package ar.unrn;

import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase agrupa la funcionalidad necesaria para trabajar con arreglos.
 * <p>
 * Con un poco bastante de reinvención de la rueda ¯\_(ツ)_/¯.
 */
public class Arreglos {
    /**
     * Esta constante es el factor de crecimiento para la
     * conversión de cadena a arreglo.
     */
    public static final int MAXIMUS_BLOQUIUS = 10;
    /**
     * Usado para indicar que un arreglo está ordenado de menor a mayor.
     */
    public static final int ASCENDENTE = 1;
    /**
     * Usado para indicar que un arreglo está ordenado de mayor a menor.
     */
    public static final int DESCENDENTE = -1;
    /**
     * Usado para indicar que un arreglo no está ordenado.
     */
    public static final int DESORDENADO = 0;
    /**
     * Un número de relleno que no debiera de aparecer al copiar.
     * Pero si aparece, vamos a saber inmediatamente que hay algo mal.
     */
    public static final int POTENCIAL_FALLO = 0xFFFF;
    /**
     * Cuando un valor se busca, pero no se encuentra.
     */
    public static final int NO_ENCONTRADO = -1;

    /**
     * Esta función se encarga de verificar las precondiciones base
     * en todas las funciones.
     * Esencialmente, que no sea nulo y tenga elementos.
     *
     * @param arreglo a ser verificado
     * @throws ArregloException cuando arreglo es nulo.
     * @throws ArregloException cuando arreglo tiene 0 elementos.
     *                          (Este es un buen ejemplo de por qué
     *                          necesitamos 'clasificar' las excepciones)
     */
    public static void comprobar(int[] arreglo) {
        if (arreglo == null) {
            throw new ArregloException("Arreglo nulo");
        }
        if (arreglo.length == 0) {
            throw new ArregloException("Arreglo longitud cero");
        }
    }

    /**
     * Muestra el arreglo como una lista separada por comas y rodeada
     * de corchetes.
     *
     * @param arreglo que será mostrado
     */
    public static void mostrar(int[] arreglo) {
        comprobar(arreglo);
        System.out.print("arreglo: [");
        int i = 0;
        while (i < arreglo.length) {
            System.out.print(arreglo[i]);
            if (i != arreglo.length - 1) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println("]");
    }

    /**
     * Genera un array de enteros linealmente crecientes a partir de un valor inicial.
     * Cada elemento del array es igual al índice más el valor inicial.
     *
     * @param cantidad La cantidad de elementos que se generarán en el array.
     * @param inicio   El valor inicial a partir del cual comienza la secuencia.
     * @return Un array de enteros con la secuencia lineal generada.
     * @throws ArregloException si cantidad es menor o igual a 0.
     */
    public static int[] generadorLineal(int cantidad, int inicio) {
        if (cantidad < 0) {
            throw new ArregloException("La cantidad no puede ser negativa");
        }
        int[] generado = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            generado[i] = inicio + i;
        }
        return generado;
    }

    /**
     * Ordena un arreglo de enteros en orden ascendente
     * utilizando el algoritmo de ordenamiento burbuja.
     *
     * @param arreglo El arreglo de enteros a ordenar.
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static void ordena(int[] arreglo) {
        comprobar(arreglo);
        boolean huboIntercambio = false;
        int i = 0;
        int j;
        while (i < arreglo.length - 1 || huboIntercambio) {
            huboIntercambio = false;
            j = 0;
            while (j < arreglo.length - 1 - i) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temporario = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporario;
                    huboIntercambio = true;
                }
                j++;
            }
            i++;
        }
    }

    /**
     * Esta funcion crea un arreglo con elementos al azar de una determinada
     * cantidad.
     *
     * @param cantidad es de cuantos elementos será el arreglo retornado.
     * @param minimo   el número más chico posible contenido en el arreglo.
     * @param maximo   el número más grande posible contenido en el arreglo.
     * @return un arreglo de cantidad elementos y números entre minimo y maximo.
     * @throws ArregloException cuando la cantidad de elementos es menor a 1
     * @throws ArregloException cuando las cotas están invertidas y
     *                          el minimo es mayor que el maximo
     */
    public static int[] generadorAleatorio(int cantidad, int minimo, int maximo) {
        if (cantidad < 1) {
            throw new ArregloException("La cantidad de elementos no es valida");
        }
        if (minimo > maximo) {
            throw new ArregloException("Las cotas mínimo y máximo están invertidas");
        }
        Random generador = new Random();
        int[] generado = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            generado[i] = generador.nextInt(minimo, maximo);
        }
        return generado;
    }

    /**
     * Verifica si un arreglo de enteros está ordenado en orden ascendente.
     * <p>
     * Una versión más simple de "direccionOrden"
     *
     * @param arreglo El arreglo de enteros a verificar.
     * @return true si el arreglo está ordenado en orden ascendente.
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static boolean estaOrdenado(int[] arreglo) {
        comprobar(arreglo);
        int i = 0;
        boolean estaOrdenado = true;
        while (i < arreglo.length - 1 && estaOrdenado) {
            if (arreglo[i] > arreglo[i + 1]) {
                estaOrdenado = false;
            }
            i++;
        }
        return estaOrdenado;
    }

    /**
     * Determina la dirección del orden de un arreglo de enteros.
     *
     * @param arreglo El arreglo de enteros a evaluar.
     * @return Un entero que indica la dirección del orden en donde:
     * ASCENDENTE si el arreglo está ordenado en orden ascendente,
     * DESCENDENTE si el arreglo está ordenado en orden descendente,
     * DESORDENADO si el arreglo no está ordenado.
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static int direccionOrden(int[] arreglo) {
        comprobar(arreglo);
        boolean ascendente = true;
        boolean descendente = true;
        int i = 0;
        while (i < arreglo.length - 1 && (ascendente || descendente)) {
            if (arreglo[i] > arreglo[i + 1]) {
                ascendente = false;
            }
            if (arreglo[i] < arreglo[i + 1]) {
                descendente = false;
            }
            i++;
        }
        int retorno;
        if (ascendente) {
            retorno = ASCENDENTE;
        } else if (descendente) {
            retorno = DESCENDENTE;
        } else {
            retorno = DESORDENADO;
        }
        return retorno;
    }

    /**
     * Cuanta la cantidad de líneas presentes en la cadena.
     *
     * @param cadena a contabilizar.
     * @return la cantidad de \n presentes en la cadena.
     */
    public static int lineasEnCadena(String cadena) {
        int lineas = 0;
        for (char caracter : cadena.toCharArray()) {
            if (caracter == '\n') {
                lineas++;
            }
        }
        return lineas;
    }

    /**
     * Transforma el arreglo en una cadena para guardar en un archivo.
     *
     * @param arreglo que será convertido
     * @return la cadena con los valores del arreglo.
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static String aCadena(int[] arreglo) {
        comprobar(arreglo);
        StringBuilder salida = new StringBuilder();
        int i = 0;
        while (i < arreglo.length) {
            salida.append(arreglo[i]);
            salida.append('\n');
            i++;
        }
        return salida.toString();
    }

    /**
     * Transforma una cadena en un arreglo.
     * Cada número en una línea separada, está pensado para ser la función inversa de
     * aCadena
     *
     * @param cadena en donde hay una línea por número a extraer.
     * @return el arreglo con los números contenidos en la cadena según el formato indicado.
     * @throws ArregloException cuando lo leído no coincide con las líneas contenidas.
     */
    public static int[] aArreglo(String cadena) {
        int[] obtenidos = new int[MAXIMUS_BLOQUIUS];
        int bloques = 1;
        Scanner scan = new Scanner(cadena);
        int cantidadLeida = 0;
        while (scan.hasNextInt()) {
            obtenidos[cantidadLeida] = scan.nextInt();
            cantidadLeida++;
            if (cantidadLeida >= MAXIMUS_BLOQUIUS) {
                bloques++;
                obtenidos = redimensionar(obtenidos, MAXIMUS_BLOQUIUS * bloques, -1);
            }
        }
        if (cantidadLeida != lineasEnCadena(cadena)) {
            throw new ArregloException("La cantidad de numeros esperada no coincide");
        }
        int[] compactado = redimensionar(obtenidos, cantidadLeida, -1);
        return compactado;
    }

    /**
     * Copia los elementos del arreglo en uno nuevo con un nuevoLargo y rellenando cuando
     * el arreglo se amplíe.
     *
     * @param arreglo    a copiar y cambiar de tamaño
     * @param nuevoLargo el tamaño del retorno
     * @param relleno    con que será completado el nuevo arreglo cuando falten números
     * @return una copia de los elementos de arreglo, con el tamaño de nuevoLargo
     * @throws ArregloException como esta indicado en comprobar.
     * @throws ArregloException cuando el nuevoLargo sea igual o menor que cero.
     */
    public static int[] redimensionar(int[] arreglo, int nuevoLargo, int relleno) {
        comprobar(arreglo);
        if (nuevoLargo < 1) {
            throw new ArregloException("El nuevo largo es igual o menor a cero");
        }
        int[] nuevoArreglo = new int[nuevoLargo];
        int i = 0;
        while (i < nuevoLargo) {
            if (i < arreglo.length) {
                nuevoArreglo[i] = arreglo[i];
            } else {
                nuevoArreglo[i] = relleno;
            }
            i++;
        }
        return nuevoArreglo;
    }

    /**
     * Duplica el arreglo usando redimensionar sin cambiar el tamaño y usando el
     * relleno en POTENCIAL_FALLO para indicar potenciales problemas.
     *
     * @param arreglo a duplicar
     * @return el duplicado
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static int[] copiar(int[] arreglo) {
        return redimensionar(arreglo, arreglo.length, POTENCIAL_FALLO);
    }

    /**
     * Compara dos arreglos entre sí, indicando si son del mismo tamaño e igual secuencia
     * de elementos.
     *
     * @param base el primero a comparar.
     * @param otro contra quien sera comparado.
     * @return true si ambos arreglos son del mismo largo y mismos valores
     * @throws ArregloException como está indicado en comprobar en base y en otro.
     *                          Acá la información que da comprobar no es muy buena
     */
    public static boolean comparar(int[] base, int[] otro) {
        comprobar(base);
        comprobar(otro);
        boolean sonIguales = true;
        if (base.length != otro.length) {
            sonIguales = false;
        }
        int i = 0;
        while (i < base.length && sonIguales) {
            if (base[i] != otro[i]) {
                sonIguales = false;
            }
            i++;
        }
        return sonIguales;
    }

    /**
     * Crea un nuevo arreglo con los elementos del argumento en la dirección opuesta.
     *
     * @param arreglo a invertir.
     * @return un nuevo arreglo con los valores del argumento invertido.
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static int[] invierte(int[] arreglo) {
        comprobar(arreglo);
        int[] invertido = new int[arreglo.length];
        int i = 0;
        int j = arreglo.length - 1;
        while (i < arreglo.length) {
            invertido[i] = arreglo[j];
            i++;
            j--;
        }
        return invertido;
    }

    /**
     * Suma los elementos del arreglo
     *
     * @param arreglo a sumar.
     * @return la suma.
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static int suma(int[] arreglo) {
        comprobar(arreglo);
        int retorno = 0;
        int i = 0;
        while (i < arreglo.length) {
            retorno = retorno + arreglo[i];
            i++;
        }
        return retorno;
    }

    /**
     * Da el promedio de los valores contenidos en el arreglo.
     *
     * @param arreglo a promediar.
     * @return el promedio.
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static float promedio(int[] arreglo) {
        comprobar(arreglo);
        return suma(arreglo) / (float) arreglo.length;
    }

    /**
     * Encuentra el valor máximo en un arreglo de enteros.
     *
     * @param arreglo El arreglo de enteros en el que se busca el máximo.
     * @return El valor máximo en el arreglo.
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static int maximo(int[] arreglo) {
        comprobar(arreglo);

        int max = arreglo[0];
        int i = 1;

        while (i < arreglo.length) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
            i++;
        }

        return max;
    }

    /**
     * Encuentra el valor mínimo en un arreglo de enteros.
     *
     * @param arreglo El arreglo de enteros en el que se busca el mínimo.
     * @return El valor mínimo en el arreglo.
     * @throws ArregloException como esta indicado en comprobar.
     */
    public static int minimo(int[] arreglo) {
        comprobar(arreglo);
        int min = arreglo[0];
        int i = 1;
        while (i < arreglo.length) {
            if (arreglo[i] < min) {
                min = arreglo[i];
            }
            i++;
        }
        return min;
    }

    /**
     * Encuentra el número más cercano al valor medio entre el máximo y el mínimo
     * de un arreglo dado.
     *
     * @param arreglo El arreglo del cual se busca el número más cercano al valor medio.
     * @return El número más cercano al valor medio entre el máximo y el mínimo del arreglo.
     * @throws IllegalArgumentException si el arreglo es nulo o vacío.
     */
    public static int medio(int[] arreglo) {
        comprobar(arreglo);
        int maximo = maximo(arreglo);
        int minimo = minimo(arreglo);
        double valorMedio = (maximo + minimo) / 2.0;
        int numeroMasCercano = arreglo[0];
        double diferenciaMinima = Math.abs(arreglo[0] - valorMedio);
        int i = 1;
        while (i < arreglo.length) {
            double diferenciaActual = Math.abs(arreglo[i] - valorMedio);
            if (diferenciaActual < diferenciaMinima) {
                numeroMasCercano = arreglo[i];
                diferenciaMinima = diferenciaActual;
            }
            i++;
        }
        return numeroMasCercano;
    }

    /**
     * Remueve el elemento en la posición especificada del arreglo dado.
     * Devuelve un nuevo arreglo sin el elemento removido.
     *
     * @param arreglo  El arreglo del cual se desea remover un elemento.
     * @param posicion La posición del elemento a remover (0-indexed).
     * @return Un nuevo arreglo sin el elemento removido.
     * @throws IllegalArgumentException si el arreglo es nulo o la posición está fuera de los límites.
     */
    public static int[] remover(int[] arreglo, int posicion) {
        comprobar(arreglo);
        if (posicion < 0 || posicion >= arreglo.length) {
            throw new IllegalArgumentException("Posición fuera de los límites del arreglo");
        }
        int nuevoLargo = arreglo.length - 1;
        int[] nuevoArreglo = new int[nuevoLargo];
        int j = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (i != posicion) {
                nuevoArreglo[j++] = arreglo[i];
            }
        }
        return nuevoArreglo;
    }

    /**
     * Encuentra la posición del primer elemento igual al valor buscado en el arreglo dado.
     *
     * @param arreglo El arreglo en el que se busca el elemento.
     * @param buscado El valor que se desea encontrar en el arreglo.
     * @return La posición del primer elemento encontrado igual a 'buscado', o -1 si no se encuentra.
     * @throws IllegalArgumentException si el arreglo es nulo.
     */
    public static int encontrar(int[] arreglo, int buscado) {
        comprobar(arreglo);
        int i = 0;
        boolean encontrado = false;
        while (i < arreglo.length && !encontrado) {
            if (arreglo[i] == buscado) {
                encontrado = true;
            }
            i++;
        }
        i = i - 1;
        if (!encontrado) {
            i = NO_ENCONTRADO;
        }
        return i;
    }
}
