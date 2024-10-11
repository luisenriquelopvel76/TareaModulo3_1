package com.modulo3.tareamodulo3_1;

public class Pregunta {
    private final String texto;
    private final String[] opciones;
    private final int respuestaCorrecta;

    public Pregunta(String texto, String[] opciones, int respuestaCorrecta) {
        this.texto = texto;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public void mostrarPregunta() {
        System.out.println(texto);
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
    }

    public boolean esCorrecta(int respuesta) {
        return respuesta == respuestaCorrecta;
    }


    public String getTexto() {
        return texto;
    }

    public String[] getOpciones() {
        return opciones;
    }
}
