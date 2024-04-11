package ar.unrn;

public class ArchivoIlegibleException extends ArchivoException {
    /**
     * Excepción con un mensaje.
     * En otros casos, solo queremos saber que pasó, siendo
     * la razón algo que nosotros originamos.
     *
     * @param mensaje la descripción textual del problema.
     */
    public ArchivoIlegibleException(String mensaje) {
        super(mensaje;
    }

    /**
     * Encadenamiento de problemas.
     * En algunos casos, el problema se origina desde otro,
     * esta es la forma de conectar uno con otro, de forma
     * de conocer "la razón" por la cual estamos viendo este
     * problema.
     *
     * @param razon la excepción causante del problema.
     */
    public ArchivoIlegibleException(Throwable razon) {
        super(razon);
    }

    /**
     * Cuando queremos saber la razón de manera detallada.
     * La combinación de los dos casos anteriores, cuando queremos
     * una descripción que y porque pasó algo.
     *
     * @param mensaje la descripción textual del problema.
     * @param razon   la causa del problema
     */
    public ArchivoIlegibleException(String mensaje, Throwable razon) {
        super(mensaje, razon);
    }
}
