package com.modulo3.tareamodulo3_1;

public class Jugador {
    private String nombre;
    private int progreso;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.progreso = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getProgreso() {
        return progreso;
    }

    public void avanzar() {
        progreso++;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }
}
