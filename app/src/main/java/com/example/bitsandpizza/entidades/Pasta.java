package com.example.bitsandpizza.entidades;

import com.example.bitsandpizza.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Pasta implements Serializable {
    private String name;
    private int Foto;
    private String description;

    public Pasta(String name, int foto, String description) {
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

    public static ArrayList<Pasta> initListPastas() {
        ArrayList<Pasta> listPastas = new ArrayList<> ();
        listPastas.add(new Pasta("Spagethe Bolonesa", R.drawable.pasta_spagethe_bolonesa,"La boloñesa o bolognesa (ragù bolognese [raˈɡu boloɲˈɲeːze] en italiano) es una salsa muy comúnmente usada para acompañar pastas (una de las más comunes son los tagliatelle al ragù) o a la típica polenta. Es una salsa espesa, de color marrón-rojo, muy empleada en las comarcas cercanas a Bolonia. En italiano lleva el nombre ragù como deformación del francés \"ragoût\"." +
                "\n En octubre del año 1982 una delegación de Bologna que representaba la Accademia Italiana della cucina depositó en la Camera di Comercio Industria Artigianato e Agricoltura di Bologna la receta oficial del ragù bolognese, con el objetivo de garantizar la continuidad y el respeto a la tradición gastronómica boloñesa en Italia y en el mundo."));
        listPastas.add(new Pasta("Lasagna",R.drawable.pasta_lasagna,"La lasaña (italiano: lasagna) es un tipo de pasta que se sirve en láminas (para denominarse lasaña ha de llevar como mínimo cuatro capas de pasta e ingredientes al gusto, además de denominarse así también a un plato que tiene pasta en láminas intercaladas con carne (ragú o salsa boloñesa) y bechamel llamado lasaña al horno (Lasagna al forno). Se trata de un plato de origen italiano."+
                "\n El propio Cicerón menciona su pasión por el Láganum, que eran tiras de pasta largas; es muy posible que en esta época los italianos desarrollaron las máquinas para elaborar la pasta de lasaña.1\u200B Lo más seguro es que hasta el siglo XVII no apareciera un plato similar a nuestra lasaña al horno que hoy se conoce por todo el mundo."));
        return listPastas;
    }
}
