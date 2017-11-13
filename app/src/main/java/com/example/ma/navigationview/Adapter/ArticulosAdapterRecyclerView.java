package com.example.ma.navigationview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ma.navigationview.Model.Articulo;
import com.example.ma.navigationview.Noticia;
import com.example.ma.navigationview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gfbla on 31/10/2017.
 */

public class ArticulosAdapterRecyclerView extends RecyclerView.Adapter {
    private Context context;
    private List<Articulo> articuloList;
    private NotificableDeClickRecycler notificableDeClickRecycler;

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
        notifyDataSetChanged();
    }

    public ArticulosAdapterRecyclerView(Context context, List<Articulo> articuloList, NotificableDeClickRecycler notificable) {
        this.context = context;
        this.articuloList = articuloList;
        notificableDeClickRecycler = notificable;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.celda_recycler_view, parent,false);
        ArticuloViewHolder recetaViewHolder = new ArticuloViewHolder(view);
        return recetaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final Articulo unArticulo = articuloList.get(position);
        ArticuloViewHolder articuloViewHolder = (ArticuloViewHolder) holder;
        articuloViewHolder.cargarArticulo(unArticulo);
        articuloViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Articulo elArticulo = articuloList.get(position);
                notificableDeClickRecycler.informarSeleccionAlFragment(elArticulo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articuloList.size();
    }

    public void updateList(List<Articulo> list){

        articuloList =list;
        notifyDataSetChanged();
    }

    //----------------------------------------------------------------
    private class ArticuloViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewRecycler;
        private ImageView imageViewRecycler;

        public ArticuloViewHolder(View itemView) {
            super(itemView);
            textViewRecycler = (TextView) itemView.findViewById(R.id.textViewRecycler);

            //usar picasso para la imagen a partir de la url
            imageViewRecycler = (ImageView) itemView.findViewById(R.id.imageViewRecycler);
        }

        public void cargarArticulo(Articulo articulo){
            textViewRecycler.setText(articulo.getTitle());

            //usar picasso para la imagen a partir de la url
            //imageViewRecycler.setImageResource(articulo.getUrlToImage());
            Picasso.with(context).load(articulo.getUrlToImage()).into(imageViewRecycler);
        }
    }

    public interface NotificableDeClickRecycler{
        public void informarSeleccionAlFragment(Articulo elArticulo);
    }
}
