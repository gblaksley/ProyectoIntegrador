package com.example.ma.navigationview.Controller;




import com.example.ma.navigationview.DAO.DAOFuentesInternet;
import com.example.ma.navigationview.Model.Fuente;
import com.example.ma.navigationview.Utils.ResultListener;

import java.util.List;

/**
 * Created by digitalhouse on 24/05/17.
 */

public class FuentesController {


    public void obtenerFuentes(final ResultListener<List<Fuente>> listenerFromView) {

       DAOFuentesInternet daoFuentesInternet = new DAOFuentesInternet();
        daoFuentesInternet.obtenerFuentesDeInternet(new ResultListener<List<Fuente>>() {
            @Override
            public void finish(List<Fuente> resultado) {

                if(resultado != null) {
                    listenerFromView.finish(resultado);
                }
            }
        });
    }

}
