package com.example.ma.navigationview.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ma.navigationview.Model.Fuente;
import com.example.ma.navigationview.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFuente extends Fragment {

    public static final String NAME = "nombre";
    public static final String DESCRIPCION = "descripcion";
    //public static final String PREPARACION = "preparacion";
    public static final String ID = "id";

    public FragmentFuente() {
        // Required empty public constructor
    }

    //ESTE METODO ME PERMITE CREAR FRAGMENTS INFORMANDOLE LA NOTICIA QUE QUIERO.
    //ES UNA FUNCION QUE ME PERMITE FABRICAR FRAGMENTS (Patron Factory).
    //SE UTILIZA UN BUNDLE EN DONDE GUARDO TODOS LOS ATRIBUTOS QUE QUIERA UTILIZAR PARA MI FRAGMENT
    public static FragmentFuente fragmentFuenteCreator(Fuente fuente) {
        FragmentFuente unFragment = new FragmentFuente();
        Bundle unBundle = new Bundle();
        unBundle.putString(FragmentFuente.NAME , fuente.getName());
        unBundle.putString(FragmentFuente.DESCRIPCION, fuente.getDescription());
        //unBundle.putString(FragmentFuente.PREPARACION, noticia.getPreparacion());
       // unBundle.putInt(FragmentFuente.ID, fuente.getId());
        unFragment.setArguments(unBundle);
        return unFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_fuente, container, false);

        TextView textviewTitulo= (TextView)view.findViewById(R.id.textViewFragmentDetalleTitulo);
        Bundle bundle = getArguments();
        textviewTitulo.setText(bundle.getString(NAME));

        //TextView textviewIngredientes= (TextView)view.findViewById(R.id.textViewFragmentDetalleIngredientes);
        //textviewIngredientes.setText(bundle.getString(INGREDIENTES));

        TextView textviewPreparacion= (TextView)view.findViewById(R.id.textViewFragmentDetalleContenido);
        textviewPreparacion.setText(bundle.getString(DESCRIPCION));

        ImageView imageView = (ImageView)view.findViewById(R.id.imageViewFragmentDetalle);
//        imageView.setImageResource(bundle.getInt(ID));

        return view;
    }

}
