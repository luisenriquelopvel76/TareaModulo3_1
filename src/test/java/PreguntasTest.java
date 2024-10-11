import com.modulo3.tareamodulo3_1.Pregunta;
import com.modulo3.tareamodulo3_1.Preguntas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntasTest {
    private Preguntas preguntas;


    @BeforeEach
    void setUp() {
        preguntas = new Preguntas(); // Inicializa el objeto Preguntas
    }

    @Test
    void testObtenerPregunta() {
        // probar que devuelve una pregunta válida al solicitar el índice 0
        Pregunta pregunta1 = preguntas.obtenerPregunta(0);
        assertNotNull(pregunta1); // Asegurarse de que la pregunta no sea null
        assertEquals("¿Cuánto es 40 x 2?", pregunta1.getTexto()); // verificar que el texto de la pregunta sea correcto

        // probar que devuelve una pregunta válida al solicitar un índice mayor
        Pregunta pregunta2 = preguntas.obtenerPregunta(1);
        assertNotNull(pregunta2); // la pregunta debe existir
        assertEquals("¿Cuál animal no es un mamifero?", pregunta2.getTexto());

        // probar que retorna null si solicitamos un índice fuera de rango
        Pregunta preguntaInvalida = preguntas.obtenerPregunta(100); // indice fuera del rango
        assertNull(preguntaInvalida); // debe devolver null
    }

    @Test
    void testTotalPreguntas() {
        // probar que el número total de preguntas es el esperado
        assertEquals(5, preguntas.totalPreguntas()); // esto es de acuerdo al numero de preguntas existentes
    }
}
