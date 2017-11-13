package com.example.ma.navigationview.View;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ma.navigationview.Adapter.AdapterViewPager;
import com.example.ma.navigationview.Controller.FuentesController;
import com.example.ma.navigationview.Model.Fuente;
import com.example.ma.navigationview.Noticia;
import com.example.ma.navigationview.R;
import com.example.ma.navigationview.Utils.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityViewPager extends AppCompatActivity {

    //La lista de busqueda es variable e interactiva y no se puede pasar
    //la posicion clickeada, uso el id de la receta clickeada uso el id para
    //ubicar y pasar la buena posicion al viewpager
    //Agregue un ID a Noticia
    public static final String ID_RECETA_CLICKEADA = "id";
    public static final String CATEGORIA_CLICKEADA = "categoria";
    //List<Noticia> noticiaList;
    List<Fuente> fuenteList;
    AdapterViewPager adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        //noticiaList = new ArrayList<>;
        fuenteList = new ArrayList<>();

        cargarFuentes();

        //Recibir el Intent
        Intent unIntent = getIntent();

        //Recibir el Bundle
        Bundle unBundle = unIntent.getExtras();

        //Recibir el mensaje
        Integer idRecetaClickeada = unBundle.getInt(ID_RECETA_CLICKEADA);
        Integer categoriaClickeada = unBundle.getInt(CATEGORIA_CLICKEADA);

        //CREO UNA LISTA DE FUENTESSS

        //BUSCO EL VIEW PAGER
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        //LE SETEO EL ADAPTER AL VIEW PAGER, EL ADAPTER UTILIZA EL FRAGMENT MANAGER PARA CARGAR FRAGMENT
        // Y LA LISTA DE RECETAS PARA CREAR LOS FRAGMENTS CORRESPONDIENTES
        adapterViewPager = new AdapterViewPager(getSupportFragmentManager(),fuenteList);
        viewPager.setAdapter(adapterViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_activity_view_pager);
        tabLayout.setupWithViewPager(viewPager);
        //ESTO PERMITE QUE EL USUARIO VEA QUE HAY OTRA PAGINA CON OTRO FRAGMENT
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(10);

        //Encontrar la posicion de la receta clickeada en la lista del viewPager
        Integer posicionGeneralClickeada=0;
        for(Integer i = 0; i< fuenteList.size(); i++){
            if (fuenteList.get(i).getId().equals(idRecetaClickeada)) {
                posicionGeneralClickeada=i; break;
            }
        }

        //pasarselo al viewPager
        viewPager.setCurrentItem(posicionGeneralClickeada);
    }

    public void cargarFuentes(){
        FuentesController fuentesController = new FuentesController();
        fuentesController.obtenerFuentes(new ResultListener<List<Fuente>>() {
            @Override
            public void finish(List<Fuente> resultado) {
                adapterViewPager.cargarNuevaLista(resultado);
            }
        });
    }
}
