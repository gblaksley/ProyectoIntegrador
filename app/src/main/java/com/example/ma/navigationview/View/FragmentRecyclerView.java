package com.example.ma.navigationview.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.ma.navigationview.Controller.ArticulosController;
import com.example.ma.navigationview.Model.Articulo;
import com.example.ma.navigationview.Model.Fuente;
import com.example.ma.navigationview.Noticia;
import com.example.ma.navigationview.Adapter.ArticulosAdapterRecyclerView;
import com.example.ma.navigationview.R;
import com.example.ma.navigationview.Utils.ResultListener;

import java.util.ArrayList;
import java.util.List;


public class FragmentRecyclerView extends Fragment implements ArticulosAdapterRecyclerView.NotificableDeClickRecycler {

   // public static final String CATEGORIA="categoria";
    public static final String IDFUENTE="idfuente";

    //...a mis en global
    ArticulosAdapterRecyclerView articulosAdapterRecyclerView;
    String idFuente;

    //esta lista local al fragment es interactiva y puede diferir de la lista del viewPager.
    //En el MainActivity uso el id de la receta clickeada para pasarselo al ActivityViewPager
    List<Articulo> articuloList;

    public static FragmentRecyclerView fragmentFuenteCreator(Fuente fuente) {
        FragmentRecyclerView unFragment = new FragmentRecyclerView();
        Bundle unBundle = new Bundle();
        unBundle.putString(IDFUENTE,fuente.getId());
        unFragment.setArguments(unBundle);
        return unFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_recycler_view, container, false);

        Bundle bundle = getArguments();
        idFuente = bundle.getString(IDFUENTE);

        ArticulosController articulosController = new ArticulosController();
        articulosController.obtenerArticulos(idFuente, new ResultListener<List<Articulo>>() {
            @Override
            public void finish(List<Articulo> resultado) {
                articulosAdapterRecyclerView.setArticuloList(resultado);
            }
        });

        //LISTA DE NOTICIAS
        //final List<Noticia> noticiaList = new ArrayList<>();

        articuloList = new ArrayList<>();


        EditText ediTextDeBusqueda = (EditText) view.findViewById(R.id.edit_text_de_busqueda);

        //<!-- Dos lineas para deshabilitar la tecla enter  -->
        ediTextDeBusqueda.setSingleLine(false);
        ediTextDeBusqueda.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT);

        ediTextDeBusqueda.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        RecyclerView recyclerViewArticulos = (RecyclerView) view.findViewById(R.id.recyclerViewFragment);
        recyclerViewArticulos.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        articulosAdapterRecyclerView = new ArticulosAdapterRecyclerView(getContext(), articuloList,this);
        recyclerViewArticulos.setAdapter(articulosAdapterRecyclerView);

        recyclerViewArticulos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    public void filter (String text){
        List<Articulo> temp = new ArrayList();
        for(Articulo articulo : temp){
            ////or use .equal(text) with you want equal match
            ////use .toLowerCase() for better matches
            //hay que comparar lo mismo ! toLowerCase() de los dos lados del igual
            if(articulo.getTitle().toLowerCase().contains(text.toLowerCase())){
                temp.add(articulo);
            }
        }
        //update recyclerview
        articulosAdapterRecyclerView.updateList(temp);
    }

    @Override
    public void informarSeleccionAlFragment(Articulo elArticulo) {

        NotificableDeClickFragment notificable = (NotificableDeClickFragment) getContext();
        //notificable.informarSeleccionAlActivity(laNoticia,idFuente);
    }

    public interface NotificableDeClickFragment {
        public void informarSeleccionAlActivity(Articulo elArticulo,Integer categoria);
    }
}
