package com.example.bitsandpizza.entidades;

import com.example.bitsandpizza.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {
    private String name;
    private int Foto;
    private String description;

    public Store(String name, int foto, String description) {
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

    public static ArrayList<Store> initListStores() {
        ArrayList<Store> listStores = new ArrayList<> ();
        listStores.add(new Store("Cambridge", R.drawable.store_cambridge,"A whole, not a slice!\n" +
                "At last you can order a WHOLE Aromi sourdough pizza - as delicious as the slices we sell in our cafes (with 3 days fermentation included!), but big enough for dinner! And to go with it - a tasty choice of Sicilian antipasti, cakes, and of course our famous artisan gelato.\n" +
                "\n" +
                "Our menu changes seasonally so we can find the best, fresh ingredients in the area. \n" +
                "\n" +
                "Thank you for supporting us – this is an exciting new venture for us so we appreciate your patience!"));
        listStores.add(new Store("Sebatopol",R.drawable.sotre_sebatopol,"\"Mekenzi 1783\" es un restaurante legendario en el corazón de Sebastopol. Una vista increíble de Sebastopol y el Mar Negro se abre desde dos terrazas abiertas y el salón principal con acristalamiento panorámico. El interior del restaurante fue creado de acuerdo con el proyecto de los mejores diseñadores de Crimea. El chef ha creado un menú de autor, que no tiene análogos en Crimea. El servicio excepcional y el cuidado de la comodidad de los huéspedes es la prioridad de cada miembro del equipo de Mekenzie 1783. Y ver la puesta de sol desde la terraza \"Mekenzi 1783\" no solo es un placer, sino también un elemento obligatorio en el programa de viajes en Sebastopol."));
        return listStores;
    }
}
