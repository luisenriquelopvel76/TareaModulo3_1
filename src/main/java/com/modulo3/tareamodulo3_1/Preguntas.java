package com.modulo3.tareamodulo3_1;

import java.util.ArrayList;

public class Preguntas {
    private ArrayList<Pregunta> listaDePreguntas;

    public Preguntas() {
        listaDePreguntas = new ArrayList<>();
        crearPreguntas();

    }
    private void crearPreguntas() {
        String[] opciones1 = {"25", "80", "60", "8"};
        listaDePreguntas.add(new Pregunta("¿Cuánto es 40 x 2?", opciones1, 2));

        String[] opciones2 = {"Perro", "Gato", "León", "Serpiente"};
        listaDePreguntas.add(new Pregunta("¿Cuál animal no es un mamifero?", opciones2, 4));

        String[] opciones3 = {"Rojo", "Azul", "Verde", "Amarillo"};
        listaDePreguntas.add(new Pregunta("¿Qué color da de combinar azul y amarillo?", opciones3, 3));

        String[] opciones4 = {"Los Angeles", "Ohio", "Whashington", "New York"};
        listaDePreguntas.add(new Pregunta("¿Cual es la capital de Estados Unidos?", opciones4, 3));

        String[] opciones5 = {"Miguel Angel", "Leonardo Davinci", "Van Gogh", "Pablo Picasso"};
        listaDePreguntas.add(new Pregunta("¿Quien pinto la Mona Lisa?", opciones5, 2));

        // se pueden seguir agregando más preguntas aquí...
    }

    public Pregunta obtenerPregunta(int indice) {
        if (indice < listaDePreguntas.size()) {
            return listaDePreguntas.get(indice);
        } else {
            return null;
        }
    }

    public int totalPreguntas() {
        return listaDePreguntas.size();
    }
}
