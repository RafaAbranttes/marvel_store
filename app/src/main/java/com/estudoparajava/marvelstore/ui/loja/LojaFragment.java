package com.estudoparajava.marvelstore.ui.loja;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.estudoparajava.marvelstore.R;
import com.estudoparajava.marvelstore.api.ApiMarvelHttp;
import com.estudoparajava.marvelstore.entityAPI.Comic;
import com.estudoparajava.marvelstore.entityAPI.ComicData;
import com.estudoparajava.marvelstore.entityAPI.ComicDataData;
import com.estudoparajava.marvelstore.entityAPI.Prices;

import java.util.ArrayList;
import java.util.List;

public class LojaFragment extends Fragment {

    private LojaViewModel lojaViewModel;
    private RecyclerView recyclerView;

    private MenuView.ItemView itemView;

    private ComicData comicData;
    private ComicDataData comicDataData;
    private List<Comic> comic = new ArrayList<>();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        lojaViewModel =
                new ViewModelProvider(this).get(LojaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_loja, container, false);
        //final ListView textView = root.findViewById(R.id.list);

        recyclerView = root.findViewById(R.id.recyclerView);

        //list comic

        itemView  = root.findViewById(R.id.app_bar_search);


        comicData = ApiMarvelHttp.getAllComics("",0);
        comicDataData = comicData.getData();
        comic = comicDataData.getResults();





        //adapter configuration
        LojaAdapter lojaAdapter = new LojaAdapter(comic);

        //recycleview configuraion
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(lojaAdapter);


        lojaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setTextFilterEnabled(Boolean.parseBoolean(s));
            }
        });
        return root;
    }

}