package com.modulo3.tareamodulo3_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "JuegoServlet", value = "/JuegoServlet")
public class JuegoServlet extends HttpServlet {
    public JuegoServlet() {
        super();
    }

    private final Preguntas preguntas = new Preguntas();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Jugador jugador = (Jugador) session.getAttribute("jugador");

        if (jugador == null) {
            String nombre = request.getParameter("nombre");
            if (nombre == null || nombre.isEmpty()) {
                response.sendRedirect("/index.jsp"); // Redirige al inicio si el nombre no está en la sesión
                return;
            }
            jugador = new Jugador(nombre);
            jugador.setProgreso(ProgresoDelJugador.cargarProgreso(nombre));
            session.setAttribute("jugador", jugador);
        }

        int progreso = jugador.getProgreso();
        Pregunta preguntaActual = preguntas.obtenerPregunta(progreso);

        if (preguntaActual != null) {
            request.setAttribute("pregunta", preguntaActual);
            request.getRequestDispatcher("/pregunta.jsp").forward(request, response);
        } else {
            response.sendRedirect("/final.jsp"); // Redirige a una página final si ya no hay preguntas
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

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
                jugador.avanzar();
                ProgresoDelJugador.guardarProgreso(jugador);
            } else {
                response.sendRedirect("final.jsp");
                return;
            }
        }

        response.sendRedirect("JuegoServlet");
    }
}
