package com.estudoparajava.marvelstore.ui.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estudoparajava.marvelstore.R;

public class CartAdpater extends RecyclerView.Adapter<CartAdpater.MyViewHolderCart> {

    @NonNull
    @Override
    public MyViewHolderCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_cart_list, parent, false);

        return new MyViewHolderCart(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderCart holder, int position) {
        holder.titulo.setText("Avengers #1");
        holder.preco.setText("$9.99");
        holder.serie.setText("2019");
        holder.quantidade.setText("4");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolderCart extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titulo;
        TextView preco;
        TextView serie;
        TextView quantidade;


        public MyViewHolderCart(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewCart);
            titulo = itemView.findViewById(R.id.textViewTitleCart);
            preco = itemView.findViewById(R.id.textViewPriceCart);
            serie = itemView.findViewById(R.id.textViewSeriesCart);
            quantidade = itemView.findViewById(R.id.textViewQuant);

        }
    }





}
