package com.estudoparajava.marvelstore.ui.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.estudoparajava.marvelstore.R;
import com.estudoparajava.marvelstore.ui.cart.CartAdpater;

public class OrderFragment extends Fragment {

    private OrderViewModel orderViewModel;
    private RecyclerView recyclerViewOrder;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        orderViewModel =
                new ViewModelProvider(this).get(OrderViewModel.class);
        View root = inflater.inflate(R.layout.fragment_order, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);


        recyclerViewOrder = root.findViewById(R.id.recycleViewOrder);


        //Adapter configuration
        OrderAdapter orderAdapter = new OrderAdapter();



        //RecyclerView configuration
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewOrder.setLayoutManager(layoutManager);
        recyclerViewOrder.setHasFixedSize(true);
        recyclerViewOrder.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerViewOrder.setAdapter(orderAdapter);



        orderViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


            }
        });
        return root;
    }
}