package com.example.ma.navigationview;

/**
 * Created by gfbla on 31/10/2017.
 */

public class Noticia {
    private Integer imagen;
    private String titulo;
    private String contenido;
    //private String preparacion;

    //Agregue un ID unico a cada Noticia
    //Permite ubicar inequivocamente una receta clickeada
    //evitando conflictos en caso de repeticion
    //de titulo, imagen, contenido o preparacion
    private Integer id;

    public Noticia(Integer imagen, String titulo, String contenido, Integer id) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.contenido = contenido;
        //this.preparacion = preparacion;
        this.id= id;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(this.getTitulo());
    }

    public Integer getId() { return id; }

    public String getTitulo() {
        return titulo;
    }

    public Integer getImagen() { return imagen; }

    public String getContenido() {
        return contenido;
    }

    /*public String getPreparacion() {
        return preparacion;
    }*/
}
