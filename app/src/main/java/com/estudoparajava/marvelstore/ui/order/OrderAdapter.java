package com.estudoparajava.marvelstore.ui.order;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estudoparajava.marvelstore.R;

//utilizado para gerar o recycleView dos pedidos

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolderOrder> {

    @NonNull
    @Override
    public MyViewHolderOrder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_order_list, parent, false);

        return new MyViewHolderOrder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.MyViewHolderOrder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolderOrder extends  RecyclerView.ViewHolder{


        public MyViewHolderOrder(View itemView) {
            super(itemView);


        }
    }





}
