package com.estudoparajava.marvelstore.ui.cart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.estudoparajava.marvelstore.R;


public class CartFragment extends Fragment {


    private CartViewModel cartViewModel;
    private RecyclerView recyclerViewCart;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cartViewModel =
                new ViewModelProvider(this).get(CartViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        //final TextView textView = root.findViewById(R.id.textViewCart);

        recyclerViewCart = root.findViewById(R.id.recyclerViewCart);


        //Adapter configuration
        CartAdpater cartAdpater = new CartAdpater();



        //RecyclerView configuration
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewCart.setLayoutManager(layoutManager);
        recyclerViewCart.setHasFixedSize(true);
        recyclerViewCart.setAdapter(cartAdpater);



        cartViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

}