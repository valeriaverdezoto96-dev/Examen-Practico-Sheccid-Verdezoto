package buscaminas.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import buscaminas.modelo.Casilla;

public class CasillaTest {

    private Casilla casilla;

    @BeforeEach
    public void setUp() {
        casilla = new Casilla();
    }

    @Test
    public void testCasillaInicial() {
        assertFalse(casilla.tieneMina());
        assertFalse(casilla.estaDescubierta());
        assertFalse(casilla.estaMarcada());
        assertEquals(0, casilla.getMinasAlrededor());
    }

    @Test
    public void testColocarMina() {
        casilla.colocarMina();
        assertTrue(casilla.tieneMina());
    }

    @Test
    public void testDescubrir() {
        casilla.descubrir();
        assertTrue(casilla.estaDescubierta());
    }

    @Test
    public void testMarcarYDesmarcar() {
        assertFalse(casilla.estaMarcada());
        casilla.marcar();
        assertTrue(casilla.estaMarcada());
        casilla.marcar();
        assertFalse(casilla.estaMarcada());
    }

    @Test
    public void testMinasAlrededor() {
        casilla.setMinasAlrededor(3);
        assertEquals(3, casilla.getMinasAlrededor());
    }
}

