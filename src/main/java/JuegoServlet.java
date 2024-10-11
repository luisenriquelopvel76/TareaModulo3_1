import com.modulo3.tareamodulo3_1.Jugador;
import com.modulo3.tareamodulo3_1.Pregunta;
import com.modulo3.tareamodulo3_1.Preguntas;
import com.modulo3.tareamodulo3_1.ProgresoDelJugador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/JuegoServlet")
public class JuegoServlet extends HttpServlet {
    private Preguntas preguntas = new Preguntas();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Jugador jugador = (Jugador) session.getAttribute("jugador");

        // manejo la sesión del jugador
        if (jugador == null || request.getParameter("nuevoJuego") != null) {
            // Si es un nuevo juego, reinicia el progreso
            String nombre = request.getParameter("nombre");
            if (nombre == null || nombre.isEmpty()) {
                response.sendRedirect("index.jsp");
                return;
            }

            // crea un nuevo jugador y reinicia el progreso
            jugador = new Jugador(nombre);
            jugador.setProgreso(0);  // reinicia el progreso a 0 para comenzar de nuevo
            session.setAttribute("jugador", jugador);
        }

        // obtener la pregunta actual
        int progreso = jugador.getProgreso();
        Pregunta preguntaActual = preguntas.obtenerPregunta(progreso);

        if (preguntaActual != null) {
            request.setAttribute("pregunta", preguntaActual);
            request.getRequestDispatcher("pregunta.jsp").forward(request, response);
        } else {
            response.sendRedirect("final.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Jugador jugador = (Jugador) session.getAttribute("jugador");

        if (jugador == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        int progreso = jugador.getProgreso();
        Pregunta preguntaActual = preguntas.obtenerPregunta(progreso);

        String respuestaUsuarioStr = request.getParameter("respuesta");
        if (respuestaUsuarioStr != null) {
            int respuestaUsuario = Integer.parseInt(respuestaUsuarioStr);

            if (preguntaActual.esCorrecta(respuestaUsuario)) {
                jugador.avanzar();  // continua jugando si la respuesta es correcta
                ProgresoDelJugador.guardarProgreso(jugador);  // guarda el progreso
            } else {
                // el jugador falló, ir a la página de finalización
                request.setAttribute("mensajeFinal", "Has fallado. El juego ha terminado.");
                request.setAttribute("progreso", jugador.getProgreso());
                request.getRequestDispatcher("final.jsp").forward(request, response);
                return;
            }
        }

        response.sendRedirect("JuegoServlet");
    }
}
