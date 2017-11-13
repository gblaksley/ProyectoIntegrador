package com.example.ma.navigationview.DAO;

import android.os.AsyncTask;

import com.example.ma.navigationview.Model.Articulo;
import com.example.ma.navigationview.Model.ClaseContenedoraArticulos;
import com.example.ma.navigationview.Model.ClaseContenedoraFuentes;
import com.example.ma.navigationview.Model.Fuente;
import com.example.ma.navigationview.Utils.HTTPConnectionManager;
import com.example.ma.navigationview.Utils.NewsHelper;
import com.example.ma.navigationview.Utils.ResultListener;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by gfbla on 13/11/2017.
 */

public class DAOArticulosInternet {

    public void obtenerArticulosDeInternet(String idFuente, ResultListener<List<Articulo>> listenerFromController){

        ObtenerListaDeArticulosDesdeInternet tarea = new ObtenerListaDeArticulosDesdeInternet(listenerFromController);
        tarea.execute(idFuente);
    }

    private class ObtenerListaDeArticulosDesdeInternet extends AsyncTask<String, Void, List<Articulo>> {

        ResultListener<List<Articulo>> listener;
        //ResultListener<List<Noticia>> listener;

        public ObtenerListaDeArticulosDesdeInternet(ResultListener<List<Articulo>> listener) {
            this.listener = listener;
        }

        @Override
        protected List<Articulo> doInBackground(String... params) {

            ClaseContenedoraArticulos contenedora = null;
            String idFuente = params[0];
            try {
                HTTPConnectionManager connectionManager = new HTTPConnectionManager();

                // agregarle al final de la url siguiente, el contenido de un editText saisi
                // ​​https://api.mercadolibre.com/sites/MLA/search?q=​
                //NewsHelper newsHelper=new NewsHelper();
                //String requete=getFuentes();

                //FALTA EL ID FUENTE EN PARAMETRO
                String leerElJsonDeInternet = connectionManager.getRequestString(NewsHelper.getArticulos(idFuente));
                //String leerElJsonDeInternet = connectionManager.getRequestString("https://api.mercadolibre.com/sites/MLA/search?q=tennis");

                Gson gson = new Gson();
                contenedora = gson.fromJson(leerElJsonDeInternet, ClaseContenedoraArticulos.class);
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return contenedora.getArticles();
        }

        @Override
        protected void onPostExecute(List<Articulo> articulos) {
            listener.finish(articulos);
        }
    }
}
