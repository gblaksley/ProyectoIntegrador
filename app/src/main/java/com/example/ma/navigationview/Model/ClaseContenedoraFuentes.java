package com.example.ma.navigationview.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by digitalhouse on 01/06/17.
 */

public class ClaseContenedoraFuentes {

    private String status;

    @SerializedName("sources")
    private List<Fuente> listaDeFuentes;

    public List<Fuente> getListaDeFuentes() {
        return listaDeFuentes;
    }

    @Override
    public String toString() {
        return "ClaseContenedoraFuentes{" +
                "listaDeProductos=" + listaDeFuentes +
                '}';
    }
}
