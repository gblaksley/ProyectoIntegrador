package com.example.ma.navigationview.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ma.navigationview.Model.Fuente;
import com.example.ma.navigationview.View.FragmentFuente;
import com.example.ma.navigationview.View.FragmentRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfbla on 1/11/2017.
 */

public class AdapterViewPager extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
    private List<Fuente> fuenteList;

    public AdapterViewPager(FragmentManager fm, List<Fuente> listaDeFuentes) {
        super(fm);

        //INICIALIZO LA LISTA DE FRAGMENT
        fragmentList = new ArrayList<>();
        fuenteList = listaDeFuentes;


        //LE CARGO LOS FRAGMENTS QUE QUIERO. UTILIZO LA LISTA DE RECETAS PARA CREAR
        // LOS FRAGMENTS.
        for(Fuente fuente : listaDeFuentes){
            fragmentList.add(FragmentRecyclerView.fragmentFuenteCreator(fuente));
        }

        //LE AVISO AL ADAPTER QUE CAMBIO SU LISTA DE FRAGMENTS.
        notifyDataSetChanged();
    }

    public void cargarNuevaLista (List<Fuente> fuentes){
        for(Fuente fuente : fuentes){
            fragmentList.add(FragmentRecyclerView.fragmentFuenteCreator(fuente));
        }
        fuenteList = fuentes;
        //LE AVISO AL ADAPTER QUE CAMBIO SU LISTA DE FRAGMENTS.
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fuenteList.get(position).getName();
    }
}
