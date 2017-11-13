package com.example.ma.navigationview.Utils;

//package com.example.ma.navigationview;

/**
 * Created by gfbla on 5/11/2017.
 */

//package com.example.digitalhouse.news.util;

/**
 * Created by digitalhouse on 13/01/17.
 */
public class NewsHelper {

    private static String baseUrl = "https://newsapi.org/v1/";
    private static String apiKey = "&apikey=dbf89318418e431382c4be7f52884f26";
    private static String urlArticulos = "articles?source=";
    private static String urlFuentes = "sources";

    //IDIOMAS
    public static final String language_INGLES = "en";
    public static final String language_FRANCES = "fr";
    public static final String language_ALEMAN = "de";

    //CATEGORIAS
    public static final String category_BUSINESS = "business";
    public static final String category_ENTERTAINMENT = "entertainment";
    public static final String category_GAMING = "gaming";
    public static final String category_GENERAL = "general";
    public static final String category_MUSIC = "music";
    public static final String category_SCIENCENATURE = "science-and-nature";
    public static final String category_SPORT = "sport";
    public static final String category_TECHNOLOGY = "technology";

    //PAISES
    public static final String country_AUSTRALIA = "au";
    public static final String country_ALEMANIA = "de";
    public static final String country_GRANBRETANIA = "gb";
    public static final String country_INDIA = "in";
    public static final String country_ITALIA = "it";
    public static final String country_ESTADOSUNIDOS = "us";


    //PEDIDOS ARTICULOS
    public static String getArticulos (String fuente){
        return  baseUrl + urlArticulos + fuente + apiKey;
    }

    public static String getArticulosTop (String fuente){
        return baseUrl + urlArticulos + fuente + "&sortBy=top"  + apiKey;
    }

    public static String getArticulosLatest (String fuente){
        return baseUrl + urlArticulos + fuente + "&sortBy=latest"  + apiKey;
    }

    public static String getArticulosPopular (String fuente){
        return baseUrl + urlArticulos + fuente + "&sortBy=popular"  + apiKey;
    }

    //PEDIDOS FUENTES
    public static String getFuentes(){
        return baseUrl + urlFuentes;
    }

    public static String getFuentesPorCategoria (String categoria){
        return baseUrl + urlFuentes + "?category=" + categoria;
    }

    public static String getFuentesPorIdioma(String idioma){
        return baseUrl + urlFuentes + "?language=" +idioma;
    }

    public static String getFuentesPorPais(String pais){
        return baseUrl + urlFuentes + "?country=" + pais;
    }

}
