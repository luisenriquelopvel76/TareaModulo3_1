package com.modulo3.tareamodulo3_1;

import java.util.Scanner;

public class Juego {
    private static Scanner scanner = new Scanner(System.in);
    private static Preguntas preguntas = new Preguntas(); // Objeto que maneja la lista de preguntas

    public static void main(String[] args) {

        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        Jugador jugador = new Jugador(nombre);
        jugador.setProgreso(ProgresoDelJugador.cargarProgreso(nombre));


        boolean jugando = true;
        while (jugando && jugador.getProgreso() < preguntas.totalPreguntas()) {
            Pregunta preguntaActual = preguntas.obtenerPregunta(jugador.getProgreso());
            if (preguntaActual != null) {
                preguntaActual.mostrarPregunta();

                System.out.print("Elige una opción (1-4): ");
                int respuesta = scanner.nextInt();

                if (preguntaActual.esCorrecta(respuesta)) {
                    System.out.println("¡Correcto!");
                    jugador.avanzar();
                    ProgresoDelJugador.guardarProgreso(jugador);
                } else {
                    System.out.println("Respuesta incorrecta. El juego ha terminado.");
                    jugando = false;
                }
            }
        }

        if (jugador.getProgreso() == preguntas.totalPreguntas()) {
            System.out.println("¡Felicidades, has completado todas las preguntas!");
        }
    }
}
