package ar.unrn;

import java.io.IOException;

/**
 * Tipo de Excepción para indicar problemas con archivos.
 * Como subclase de IOException para que su tratamiento sea
 * más fácil de hacer de forma uniforme.
 * <p>
 * De momento, será uno solo para todos los problemas juntos.
 * <p>
 * Los problemas con arreglos, son casi siempre errores en los
 * algoritmos, por lo que no tiene sentido tener que atajarlos
 * siempre. Mejor que avisen si fallan.
 */
public class ArchivoException extends IOException {
    /**
     * Encadenamiento de problemas.
     * En algunos casos, el problema se origina desde otro,
     * esta es la forma de conectar uno con otro, de forma
     * de conocer "la razón" por la cual estamos viendo este
     * problema.
     *
     * @param razon la excepción causante del problema.
     */
    public ArchivoException(Throwable razon) {
        super(razon);
    }

    /**
     * Excepción con un mensaje.
     * En otros casos, solo queremos saber que pasó, siendo
     * la razón algo que nosotros originamos.
     *
     * @param mensaje la descripción textual del problema.
     */
    public ArchivoException(String mensaje) {
        super(mensaje);
    }

    /**
     * Cuando queremos saber la razón de manera detallada.
     * La combinación de los dos casos anteriores, cuando queremos
     * una descripción que y porque pasó algo.
     *
     * @param mensaje la descripción textual del problema.
     * @param razon   la causa del problema
     */
    public ArchivoException(String mensaje, Throwable razon) {
        super(mensaje, razon);
    }
}
