package buscaminas.modelo;

import java.io.Serializable;
/* Esta clase representa la unidad básica del tablero del juego
 * Cada casilla almacena información sobre su estado actual: si contiene una mina,
 * si ha sido descubierta por el jugador, si está marcada con una bandera y cuántas minas
 * existen alrededor de ella.
 * 
 * Implementa interfaz para permitir que los objetos de tipo
 * Casilla puedan guardarse y recuperarse desde archivos, facilitando así la función
 * de guardado y carga de partidas.
 */

public class Casilla implements Serializable {
	private static final long serialVersionUID = 1L;
    private boolean tieneMina;
    private boolean descubierta;
    private boolean marcada;
    private int minasAlrededor;
   /*Constructor
    * Inicializa la casilla sin mina, sin descubrir y sin marcar, 
    * con un contador de minas vecinas igual a cero.
    */
    public Casilla() {
        this.tieneMina = false;
        this.descubierta = false;
        this.marcada = false;
        this.minasAlrededor = 0;
    }

    public boolean tieneMina() { return tieneMina; }
    public void colocarMina() { this.tieneMina = true; }

    public boolean estaDescubierta() { return descubierta; }
    public void descubrir() { this.descubierta = true; }

    public boolean estaMarcada() { return marcada; }
    public void marcar() { this.marcada = !marcada; }

    public int getMinasAlrededor() { return minasAlrededor; }
    public void setMinasAlrededor(int minasAlrededor) { this.minasAlrededor = minasAlrededor; }
}
