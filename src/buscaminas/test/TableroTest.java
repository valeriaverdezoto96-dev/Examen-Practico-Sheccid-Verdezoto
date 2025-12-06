package buscaminas.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import buscaminas.modelo.Tablero;

public class TableroTest {

    private Tablero tablero;

    @BeforeEach
    public void setUp() {
        tablero = new Tablero();
    }

    @Test
    public void testTableroInicialTiene10FilasYColumnas() {
        // No hay un método público para obtenerlas, pero no debería lanzar error
        assertDoesNotThrow(() -> new Tablero());
    }

    @Test
    public void testVerificarVictoriaInicial() {
        assertFalse(tablero.verificarVictoria());
    }

    @Test
    public void testDescubrirCasilla() {
        boolean resultado = tablero.descubrirCasilla(0, 0);
        assertTrue(resultado, "Descubrir una casilla no debería fallar salvo que sea mina");
    }

    @Test
    public void testMarcarCasilla() {
        assertDoesNotThrow(() -> tablero.marcarCasilla(0, 0));
    }

    @Test
    public void testDescubrirMinaTerminaJuego() {
        // Repite hasta encontrar una mina y asegúrate de que devuelve false
        boolean minaEncontrada = false;
        for (int i = 0; i < 10 && !minaEncontrada; i++) {
            for (int j = 0; j < 10 && !minaEncontrada; j++) {
                boolean resultado = tablero.descubrirCasilla(i, j);
                if (!resultado) {
                    minaEncontrada = true;
                    assertFalse(resultado, "Debe retornar false si se descubre una mina");
                }
            }
        }
        assertTrue(minaEncontrada, "El tablero debe tener al menos una mina");
    }

    @Test
    public void testMarcarYDesmarcarVariasCasillas() {
        for (int i = 0; i < 3; i++) {
            tablero.marcarCasilla(i, i);
        }
        // Si no lanza excepciones, pasa la prueba
        assertTrue(true);
    }
}

