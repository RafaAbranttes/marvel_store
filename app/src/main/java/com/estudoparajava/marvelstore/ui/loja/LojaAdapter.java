package com.estudoparajava.marvelstore.ui.loja;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.estudoparajava.marvelstore.R;
import com.estudoparajava.marvelstore.entityAPI.Comic;
import com.estudoparajava.marvelstore.entityAPI.Prices;
import com.estudoparajava.marvelstore.entityAPI.Series;
import com.estudoparajava.marvelstore.entityAPI.Thumbnail;
import com.estudoparajava.marvelstore.ui.detailComic.DetailComicActivity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class LojaAdapter extends RecyclerView.Adapter<LojaAdapter.MyViewHolder> {


    private final List<Comic> comicList;
    private List<Prices> pricesList;



    public LojaAdapter(List<Comic> comicList) {
        this.comicList = comicList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_loja_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //retirado os dados da api e mostrando em formato de lista

        Comic comiclista = comicList.get(position);
        List<Prices> prices = comiclista.getPrices();
        Series series = comiclista.getSeries();
        Thumbnail thumbnail =  comiclista.getThumbnail();

        URL url = null;
        try {
            url = new URL(thumbnail.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        holder.imageView.setImageBitmap(bmp);
        holder.titulo.setText(comiclista.getTitle());
        holder.seriestext.setText(series.getName());
        holder.ano.setText(prices.get(0).toString());
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titulo;
        TextView ano;
        TextView seriestext;


        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView3);
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            seriestext = itemView.findViewById(R.id.textSeries);
        }
    }

}
