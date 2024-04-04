package ar.unrn;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class Arreglos {
    public static final int MAXIMUS_BLOQUIUS = 50;
    public static int[] generadorLineal(int cantidad, int inicio) {
        int[] generado = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            generado[i] = inicio + cantidad;
        }
        return generado;
    }

    public static void ordena(int[] arreglo){
        Arrays.sort(arreglo);
    }

    public static int[] generadorAleatorio(int cantidad, int min, int max) {
        Random generador = new Random();
        int[] generado = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            generado[i] = generador.nextInt(min, max);
        }
        return generado;
    }

    public static boolean estaOrdenado(int[] arreglo) {
        return true;
    }

    public static int lineasEnCadena(String cadena) {
        int lineas = 0;
        for (char caracter : cadena.toCharArray()) {
            if (caracter == '\n') {
                lineas++;
            }
        }
        return lineas;
    }

    public static String arregloACadena(int[] arreglo) {
        Formatter salida = new Formatter(new StringBuilder());
        for (int i = 0; i < arreglo.length; i++) {
            salida.format("%d", arreglo[i]);
        }
        salida.close();
        return salida.toString();
    }

    public static int[] cadenaAArreglo(String cadena) {
        int[] obtenidos = new int[MAXIMUS_BLOQUIUS];
        int bloques = 1;
        Scanner scan = new Scanner(cadena);
        int cantidadLeida = 0;
        while (scan.hasNextInt()) {
            obtenidos[cantidadLeida] = scan.nextInt();
            cantidadLeida++;
            if(cantidadLeida >= MAXIMUS_BLOQUIUS){
                bloques++;
                obtenidos = Arrays.copyOf(obtenidos, MAXIMUS_BLOQUIUS * bloques);
            }
        }
        if (cantidadLeida != lineasEnCadena(cadena)) {
            throw new ArregloException("La cantidad de numeros esperada no coincide");
        }
        return Arrays.copyOf(obtenidos, cantidadLeida);
    }

    public static boolean comparar(int[] base, int[] otro) {
        return Arrays.equals(base, otro);
    }
}
