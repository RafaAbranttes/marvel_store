package com.estudoparajava.marvelstore;

import android.content.ClipData;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;

import com.estudoparajava.marvelstore.api.ApiMarvelHttp;
import com.estudoparajava.marvelstore.entityAPI.Comic;
import com.estudoparajava.marvelstore.entityAPI.ComicData;
import com.estudoparajava.marvelstore.entityAPI.ComicDataData;
import com.estudoparajava.marvelstore.ui.loja.LojaFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.view.menu.MenuView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_loja,R.id.nav_cart, R.id.nav_order, R.id.nav_cartegories)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String query = "avengers"; // padrão para a aplicação

        //puxar os dados da api
        ComicData comicData = new ComicData();
        //por padrao ira pegar os dados de quadrinhos dos avengers até 10
        comicData = ApiMarvelHttp.getAllComics(query,0);

        //para mostrar a lista de quadrainhos na tela
        LojaFragment.setComicData(comicData);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}