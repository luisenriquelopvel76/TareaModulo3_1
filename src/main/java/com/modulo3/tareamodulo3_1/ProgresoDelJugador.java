package com.modulo3.tareamodulo3_1;

import java.io.*;

public class ProgresoDelJugador {
    public static void guardarProgreso(Jugador jugador) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jugador.getNombre() + "_progreso.txt"))) {
            writer.write(jugador.getProgreso() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el progreso.");
        }
    }

    public static int cargarProgreso(String nombre) {
        int progreso = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(nombre + "_progreso.txt"))) {
            progreso = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("No se encontró progreso guardado, comenzando desde cero.");
        }
        return progreso;
    }
}
