package com.example.ma.navigationview.Controller;

import com.example.ma.navigationview.DAO.DAOArticulosInternet;
import com.example.ma.navigationview.DAO.DAOFuentesInternet;
import com.example.ma.navigationview.Model.Articulo;
import com.example.ma.navigationview.Model.Fuente;
import com.example.ma.navigationview.Utils.ResultListener;

import java.util.List;

/**
 * Created by gfbla on 13/11/2017.
 */

public class ArticulosController {
    public void obtenerArticulos(String idFuente,final ResultListener<List<Articulo>> listenerFromView) {

        DAOArticulosInternet daoArticulosInternet = new DAOArticulosInternet();
        daoArticulosInternet.obtenerArticulosDeInternet(idFuente, new ResultListener<List<Articulo>>() {
            @Override
            public void finish(List<Articulo> resultado) {

                if(resultado != null) {
                    listenerFromView.finish(resultado);
                }
            }
        });
    }
}
