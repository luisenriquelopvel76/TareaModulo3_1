import com.modulo3.tareamodulo3_1.Jugador;
import com.modulo3.tareamodulo3_1.ProgresoDelJugador;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgresoDelJugadorTest {
    @Test
    void testGuardarYLeerProgreso() throws IOException {
        String nombre = "jugadorTest";
        Jugador jugador = new Jugador(nombre);
        jugador.setProgreso(3);

        // guardar progreso en un archivo temporal
        File archivoTemporal = File.createTempFile(nombre, ".txt");
        archivoTemporal.deleteOnExit(); // El archivo se borrará al terminar el test

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {
            writer.write(jugador.getProgreso() + "\n");
        }

        // leer progreso desde el archivo
        int progresoCargado;
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoTemporal))) {
            progresoCargado = Integer.parseInt(reader.readLine());
        }

        assertEquals(3, progresoCargado); // verificar que el progreso cargado sea el esperado
    }

    @Test
    void testCargarProgresoSinArchivo() {
        String nombre = "jugadorSinProgreso";
        int progreso = ProgresoDelJugador.cargarProgreso(nombre);
        assertEquals(0, progreso); // si no hay archivo, el progreso debería ser 0
    }
}
