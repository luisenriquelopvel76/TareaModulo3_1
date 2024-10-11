import com.modulo3.tareamodulo3_1.Jugador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    Jugador jugador;

    @BeforeEach
    public void preparar() {
        jugador = new Jugador("Carlos");
    }

    @Test
    void testGetNombre() {
        assertEquals("Carlos", jugador.getNombre());
    }

    @Test
    void testGetProgreso() {
        assertEquals(0, jugador.getProgreso()); // progreso inicial es 0
    }

    @Test
    void testAvanzar() {
        jugador.avanzar();
        assertEquals(1, jugador.getProgreso()); // después de avanzar, progreso debe ser 1
    }

    @Test
    void testSetProgreso() {
        jugador.setProgreso(3);
        assertEquals(3, jugador.getProgreso()); // progreso debe ser 3
    }
}
