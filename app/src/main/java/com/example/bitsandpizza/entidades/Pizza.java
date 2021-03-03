package com.example.bitsandpizza.entidades;

import com.example.bitsandpizza.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Pizza implements Serializable {
    private String name;
    private int Foto;
    private String description;

    public Pizza(String name, int foto, String description) {
        this.name = name;
        Foto = foto;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Pizza> initListPizzas() {
        ArrayList<Pizza> listPizzas = new ArrayList<> ();
        listPizzas.add(new Pizza("Funghi", R.drawable.pizza_funghi,"La Pizza funghi, como suelen llamar los italianos a la pizza de setas, es una de las más populares, una buena masa de pizza y unas ricas setas con su base de tomate, su queso fundido… y poco más necesita para ser un manjar. Ya sabéis que en casa solemos hacer pizza una vez por semana, probamos distintas masas de pizza y vamos variando los ingredientes que las cubren, aunque muchas veces apetece repetir, y nos sucede con la pizza funghi, con la pizza bianca, con la pizza tropical, con la pizza vegetal, con la pizza de pollo al Pedro Ximénez y entre otras (no acabaríamos con las pizzas que nos tienen enganchados), con la irresistible pizza cuatro quesos que, por cierto, no hemos publicado aún."));
        listPizzas.add(new Pizza("Diavolo",R.drawable.pizza_diavolo,"Pizza Diavolo es un juego de mesa donde te convertirás en un maestro pizzero y tendrás que poner los ingredientes correctos en la pizza para que todos los comensales estén satisfechos. Deberás utilizar y combinar hasta 4 cartas transparentes para lograr elaborar la pizza ideal para todos."));
        return listPizzas;
    }
}
