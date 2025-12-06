package buscaminas.controlador;

import buscaminas.modelo.Tablero;
import buscaminas.util.ArchivoUtil;
import java.util.Scanner;
/**
 * Clase principal
 * Se encarga de la ejecución del juego, manejo del flujo principal,
 * interacción con el usuario, y coordinación con la lógica del tablero y el sistema
 * de guardado/carga de partidas.
 */
public class JuegoBuscaminas {
	// Método principal que inicia la ejecución del juego
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean seguirJugando = true;

        System.out.println("**** ¡Bienvenido! Juego Buscaminas ****");
     // Bucle el juego se repetirá mientras el jugador quiera seguir jugando
        while (seguirJugando) {
            // Cargar juego si existe
            Tablero tablero = ArchivoUtil.cargar();

            if (tablero == null) {
            	// No existe un juego guardado: iniciar un nuevo tablero
                tablero = new Tablero();
                System.out.println("Nuevo juego iniciado.");
            } else {
            	// Existe un juego guardado: continuar con el tablero cargado
                System.out.println("Juego anterior cargado. Continuando partida...");
            }

            boolean juegoActivo = true;
            
         // Bucle, se ejecuta el  juego hasta que se pierda o gane
            while (juegoActivo) {
                tablero.mostrarTablero(false);
                System.out.print("Ingrese coordenadas (ej: A5) o M para marcar: ");
                String input = sc.nextLine().toUpperCase(); // Convertir entrada a mayúsculas

                try {
                    // Marcar casilla 
                    if (input.startsWith("M")) {
                        input = input.substring(1);  // Se quita la "M"
                        int fila = input.charAt(0) - 'A';  // Convertir letra a índice
                        int col = Integer.parseInt(input.substring(1)) - 1; // Convertir número a índice
                        tablero.marcarCasilla(fila, col); // Marcar la casilla en el tablero
                        ArchivoUtil.guardar(tablero);  // Guardar el estado actual
                        continue;
                    }

                    // Descubrir casilla
                    int fila = input.charAt(0) - 'A';
                    int col = Integer.parseInt(input.substring(1)) - 1;

                    if (!tablero.descubrirCasilla(fila, col)) {
                    	// Si se descubre una mina, el jugador pierde
                        tablero.mostrarTablero(true); // Mostrar todas las minas
                        System.out.println("¡Has perdido! Encontraste una mina.");
                        ArchivoUtil.eliminarGuardado(); // Borrar guardado anterior
                        juegoActivo = false; // Terminar la partida
                    } else if (tablero.verificarVictoria()) {
                        tablero.mostrarTablero(true);
                        System.out.println("¡Felicidades! Has descubierto todas las casillas seguras!");
                        ArchivoUtil.eliminarGuardado(); // Borrar guardado al ganar
                        juegoActivo = false;
                    } else {
                        ArchivoUtil.guardar(tablero); // Guardar solo si el juego sigue
                    }

                } catch (Exception e) {
                	 // Manejo de errores si la entrada es inválida
                    System.out.println("Entrada inválida. Use el formato correcto (ej: A5 o MA5).");
                }
            }

            // Después de perder o ganar 
            System.out.print("¿Deseas jugar otra partida? (Si/No): ");
            String respuesta = sc.nextLine().toUpperCase();

            if (respuesta.equals("Si")) {
                System.out.println("\n Iniciando una nueva partida...\n");
                tablero = new Tablero();
                ArchivoUtil.eliminarGuardado(); // Asegurarse de limpiar cualquier guardado anterior
            } else {
                System.out.println(" *** Gracias por jugar Buscaminas. ¡Hasta la próxima! ***");
                seguirJugando = false;
            }
        }

        sc.close();
    }
}

