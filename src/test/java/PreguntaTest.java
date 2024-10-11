import com.modulo3.tareamodulo3_1.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PreguntaTest {
    Pregunta pregunta;

    @BeforeEach
    public void preparar(){
        String[] opciones = {"25", "80", "42", "8"};
        pregunta = new Pregunta("¿Cuánto es 40 x 2?", opciones, 2);
    }

    @Test
    void testEsCorrecta() {
        assertTrue(pregunta.esCorrecta(2));  // respuesta correcta
        assertFalse(pregunta.esCorrecta(1)); // respuesta incorrecta
        assertFalse(pregunta.esCorrecta(3)); // respuesta incorrecta
    }

    @Test
    void testMostrarPregunta() {
        pregunta.mostrarPregunta();
    }
}
