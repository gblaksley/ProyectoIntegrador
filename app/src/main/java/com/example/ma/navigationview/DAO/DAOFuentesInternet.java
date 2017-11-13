package com.example.ma.navigationview.DAO;


import android.os.AsyncTask;


import com.example.ma.navigationview.Model.ClaseContenedoraFuentes;
import com.example.ma.navigationview.Model.Fuente;
import com.example.ma.navigationview.Utils.HTTPConnectionManager;
import com.example.ma.navigationview.Utils.NewsHelper;
import com.example.ma.navigationview.Utils.ResultListener;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by digitalhouse on 24/05/17.
 */

public class DAOFuentesInternet {

    public void obtenerFuentesDeInternet(ResultListener<List<Fuente>> listenerFromController){

        ObtenerListaDeFuentesDesdeInternet tarea = new ObtenerListaDeFuentesDesdeInternet(listenerFromController);
        tarea.execute();
    }

    private class ObtenerListaDeFuentesDesdeInternet extends AsyncTask<String, Void, List<Fuente>>{

        ResultListener<List<Fuente>> listener;
        //ResultListener<List<Noticia>> listener;

        public ObtenerListaDeFuentesDesdeInternet(ResultListener<List<Fuente>> listener) {
            this.listener = listener;
        }

        @Override
        protected List<Fuente> doInBackground(String... params) {

            ClaseContenedoraFuentes contenedora = null;
            try {
                HTTPConnectionManager connectionManager = new HTTPConnectionManager();

                // agregarle al final de la url siguiente, el contenido de un editText saisi
                // ​​https://api.mercadolibre.com/sites/MLA/search?q=​
                //NewsHelper newsHelper=new NewsHelper();
                //String requete=getFuentes();

                String leerElJsonDeInternet = connectionManager.getRequestString(NewsHelper.getFuentes());
                //String leerElJsonDeInternet = connectionManager.getRequestString("https://api.mercadolibre.com/sites/MLA/search?q=tennis");

                Gson gson = new Gson();
                contenedora = gson.fromJson(leerElJsonDeInternet, ClaseContenedoraFuentes.class);
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return contenedora.getListaDeFuentes();
        }

        @Override
        protected void onPostExecute(List<Fuente> fuentes) {
            listener.finish(fuentes);
        }
    }
}
