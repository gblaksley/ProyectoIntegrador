package com.example.ma.navigationview.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ma.navigationview.Model.Articulo;
import com.example.ma.navigationview.Noticia;
import com.example.ma.navigationview.R;
import com.example.ma.navigationview.View.ActivityViewPager;
import com.example.ma.navigationview.View.FragmentAboutUs;
import com.example.ma.navigationview.View.FragmentRecyclerView;

public class MainActivity extends AppCompatActivity implements FragmentRecyclerView.NotificableDeClickFragment{

    public static final int CATEGORIA_GENERAL = 1;
    public static final int CATEGORIA_DEPORTE = 2;
    public static final int CATEGORIA_TECNOLOGIA = 3;

    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.itemFragmentRecyclerViewGeneral) {
                   // bundle.putInt(FragmentRecyclerView.CATEGORIA,CATEGORIA_GENERAL);
                    //FragmentRecyclerView fragmentRecyclerView = new FragmentRecyclerView();
                    //fragmentRecyclerView.setArguments(bundle);
                    //FragmentManager manager = getSupportFragmentManager();
                    //FragmentTransaction transaction = manager.beginTransaction();
                    //para que no salga de la aplicacion a la salida del fragment
                    //transaction.addToBackStack(null);
                    //transaction.replace(R.id.contenedorDeFragment, fragmentRecyclerView);
                    //transaction.commit();

                    // Intent para llamar a la activityViewPager
                    //Creamos un Intent

                    Intent unIntent = new Intent(MainActivity.this,ActivityViewPager.class);

                    //Creamos un Bundle
                    Bundle unBundle = new Bundle();

                    ////Cargamos el mensaje   dentro del Bundle
                    //unBundle.putInt(ActivityViewPager.ID_RECETA_CLICKEADA, laNoticia.getId());
                    unBundle.putInt(ActivityViewPager.ID_RECETA_CLICKEADA, 2);
                    //unBundle.putInt(ActivityViewPager.CATEGORIA_CLICKEADA, categoria);
                    unBundle.putInt(ActivityViewPager.CATEGORIA_CLICKEADA, 2);

                    //Asociar el bundle al Intent
                    unIntent.putExtras(unBundle);

                    //Start del Actitivy
                    startActivity(unIntent);
                }

                if (item.getItemId() == R.id.itemFragmentRecyclerViewTecnologia) {
                    //bundle.putInt(FragmentRecyclerView.CATEGORIA,CATEGORIA_TECNOLOGIA);
                    FragmentRecyclerView fragmentRecyclerView = new FragmentRecyclerView();
                    fragmentRecyclerView.setArguments(bundle);
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    //para que no salga de la aplicacion a la salida del fragment
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.contenedorDeFragment, fragmentRecyclerView);
                    transaction.commit();
                }

                if (item.getItemId() == R.id.itemFragmentRecyclerViewDeporte) {
                    //bundle.putInt(FragmentRecyclerView.CATEGORIA,CATEGORIA_DEPORTE);
                    FragmentRecyclerView fragmentRecyclerView = new FragmentRecyclerView();
                    fragmentRecyclerView.setArguments(bundle);
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    //para que no salga de la aplicacion a la salida del fragment
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.contenedorDeFragment, fragmentRecyclerView);
                    transaction.commit();
                }



                if (item.getItemId() == R.id.itemFragmentAboutUs) {

                    FragmentAboutUs fragmentAboutUs = new FragmentAboutUs();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    //para que no salga de la aplicacion a la salida del fragment
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.contenedorDeFragment, fragmentAboutUs);
                    transaction.commit();
                }

                drawerLayout.closeDrawers();

                return true;
            }
        });
    }


    @Override
    public void informarSeleccionAlActivity(Articulo elArticulo, Integer categoria) {

        // Intent para llamar a la activityViewPager
        //Creamos un Intent
        Intent unIntent = new Intent(this, ActivityViewPager.class);

        //Creamos un Bundle
        Bundle unBundle = new Bundle();

        ////Cargamos el mensaje   dentro del Bundle
        //paso EL TITULO de la receta al activityViewPager
      //  unBundle.putInt(ActivityViewPager.ID_RECETA_CLICKEADA, elArticulo.getId());
        unBundle.putInt(ActivityViewPager.CATEGORIA_CLICKEADA, categoria);

        //Asociar el bundle al Intent
        unIntent.putExtras(unBundle);

        //Start del Actitivy
        startActivity(unIntent);
    }
}
