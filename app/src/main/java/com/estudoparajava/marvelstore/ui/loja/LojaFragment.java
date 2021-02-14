package com.estudoparajava.marvelstore.ui.loja;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
import com.estudoparajava.marvelstore.entityAPI.Characters;
import com.estudoparajava.marvelstore.entityAPI.Comic;
import com.estudoparajava.marvelstore.entityAPI.ComicData;
import com.estudoparajava.marvelstore.entityAPI.ComicDataData;
import com.estudoparajava.marvelstore.entityAPI.Items;
import com.estudoparajava.marvelstore.entityAPI.Prices;
import com.estudoparajava.marvelstore.entityAPI.Series;
import com.estudoparajava.marvelstore.entityAPI.Thumbnail;
import com.estudoparajava.marvelstore.recyclerItemClickListener.RecyclerItemClickListener;
import com.estudoparajava.marvelstore.ui.detailComic.DetailComicActivity;

import java.util.ArrayList;
import java.util.List;

public class LojaFragment extends Fragment {

    private LojaViewModel lojaViewModel;
    private RecyclerView recyclerView;

    private MenuView.ItemView itemView;

    private static ComicData comicData;
    private ComicDataData comicDataData;
    private List<Comic> comic = new ArrayList<>();

    private static String imageReference;


    public static void setImageReference(String imageReference) {
        LojaFragment.imageReference = imageReference;
    }


    public static void setComicData(ComicData comicData) {
        LojaFragment.comicData = comicData;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        lojaViewModel =
                new ViewModelProvider(this).get(LojaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_loja, container, false);
        //final ListView textView = root.findViewById(R.id.list);

        recyclerView = root.findViewById(R.id.recyclerView);

        //list comic

        itemView  = root.findViewById(R.id.app_bar_search);


        //comicData = ApiMarvelHttp.getAllComics("",0);
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

        //click event
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            Comic comicToDetail = comic.get(position);
                            List<Prices> prices = comicToDetail.getPrices();
                            Series series = comicToDetail.getSeries();
                            Thumbnail thumbnail =  comicToDetail.getThumbnail();
                            Characters character = comicToDetail.getCharacters();
                            List<Items> items = character.getItems();


                            Intent intent = new Intent(getContext(), DetailComicActivity.class);
                            intent.putExtra("title", comicToDetail.getTitle());
                            intent.putExtra("price", prices.get(0).toString());
                            intent.putExtra("image", thumbnail.toString());

                            for(int i = 0; i < items.size(); i++){
                                intent.putExtra("image"+i, items.get(i).getName());
                                System.out.println(items.get(i).getName());
                            }

                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );


        lojaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setTextFilterEnabled(Boolean.parseBoolean(s));
            }
        });
        return root;
    }

}