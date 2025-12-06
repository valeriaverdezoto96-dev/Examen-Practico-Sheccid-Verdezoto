package buscaminas.modelo;
/* Esta clase representa la estructura principal del juego
 * Contiene una matriz de objetos que conforman el tablero
 * y define la lógica necesaria para generar minas, calcular los números
 * adyacentes, revelar casillas, marcar posiciones y verificar las condiciones
 * de victoria o derrota.
 * 
 * Implementa interfaz para permitir la persistencia
 * del estado del tablero, facilitando la funcionalidad de guardado y carga
 * de partidas.
 */

import java.io.Serializable;
import java.util.Random;

public class Tablero implements Serializable {
	private static final long serialVersionUID = 1L;

    private Casilla[][] matriz;
    private final int filas = 10;
    private final int columnas = 10;
    private final int totalMinas = 10;
    /* Constructor
     * Crea una matriz de casillas, inicializa todas en estado vacío,
     * coloca las minas de forma aleatoria y calcula los números de minas
     * adyacentes para cada posición.
     */
    public Tablero() {
        matriz = new Casilla[filas][columnas];
        inicializarTablero();
        colocarMinas();
        calcularNumeros();
    }

    /* Inicializa el tablero creando una nueva instancia en cada posición de la matriz. 
     * Todas las casillas comienzan sin minas, sin descubrir y sin marcar.
     */
    private void inicializarTablero() {
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                matriz[i][j] = new Casilla();
    }
    /* Coloca las minas de forma aleatoria en el tablero.
     * Utiliza la clase Random para generar posiciones aleatorias dentro
     * de la matriz. Se asegura de que no se repitan posiciones con minas ya colocadas.
     */
    private void colocarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < totalMinas) {
            int f = rand.nextInt(filas);
            int c = rand.nextInt(columnas);
            if (!matriz[f][c].tieneMina()) {
                matriz[f][c].colocarMina();
                minasColocadas++;
            }
        }
    }
    /* Calcula y asigna el número de minas que rodean a cada casilla.
     * Este número indica cuántas minas se encuentran en las ocho casillas adyacentes
     * horizontal, vertical y diagonal. Este cálculo se omite en las casillas que
     * contienen minas.
     */
    private void calcularNumeros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!matriz[i][j].tieneMina()) {
                    int minas = 0;
                    for (int x = -1; x <= 1; x++)
                        for (int y = -1; y <= 1; y++)
                            if (i + x >= 0 && i + x < filas && j + y >= 0 && j + y < columnas)
                                if (matriz[i + x][j + y].tieneMina()) minas++;
                    matriz[i][j].setMinasAlrededor(minas);
                }
            }
        }
    }

    public void mostrarTablero(boolean revelarMinas) {
        System.out.print("   ");
        for (int i = 1; i <= columnas; i++) System.out.print(i + " ");
        System.out.println();
        char filaChar = 'A';
        for (int i = 0; i < filas; i++) {
            System.out.print(filaChar + "  ");
            for (int j = 0; j < columnas; j++) {
                Casilla c = matriz[i][j];
                if (c.estaDescubierta()) {
                    if (c.tieneMina()) System.out.print("X ");
                    else if (c.getMinasAlrededor() == 0) System.out.print("V ");
                    else System.out.print(c.getMinasAlrededor() + " ");
                } else if (c.estaMarcada()) {
                    System.out.print("M ");
                } else {
                    if (revelarMinas && c.tieneMina()) System.out.print("X ");
                    else System.out.print("- ");
                }
            }
            System.out.println();
            filaChar++;
        }
    }
    //Descubre la casilla indicada por las coordenadas.
    public boolean descubrirCasilla(int fila, int col) {
        if (matriz[fila][col].estaDescubierta()) return true;
        matriz[fila][col].descubrir();
        if (matriz[fila][col].tieneMina()) return false;
        if (matriz[fila][col].getMinasAlrededor() == 0)
            for (int x = -1; x <= 1; x++)
                for (int y = -1; y <= 1; y++)
                    if (fila + x >= 0 && fila + x < filas && col + y >= 0 && col + y < columnas)
                        descubrirCasilla(fila + x, col + y);
        return true;
    }
//Marca o desmarca una casilla según su estado actual.
    public void marcarCasilla(int fila, int col) {
        matriz[fila][col].marcar();
    }
//Verifica si el jugador ha ganado la partida.
    public boolean verificarVictoria() {
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                if (!matriz[i][j].tieneMina() && !matriz[i][j].estaDescubierta()) return false;
        return true;
    }
}
