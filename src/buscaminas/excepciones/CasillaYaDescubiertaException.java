package buscaminas.excepciones;
/*Esta clase define una excepción personalizada que se utiliza dentro del juego 
 * para indicar que el jugador ha intentado descubrir una casilla que ya fue revelada.
 * Hereda de la clase base {@link Exception}, lo que permite manejar este tipo de errores
 * de forma controlada dentro de la lógica del juego, evitando que el programa finalice
 * de manera inesperada.
 */
public class CasillaYaDescubiertaException extends Exception {
	// Identificador único de versión para mantener compatibilidad en la serialización.
	private static final long serialVersionUID = 1L;

    public CasillaYaDescubiertaException(String mensaje) {
        super(mensaje);
    }
}
