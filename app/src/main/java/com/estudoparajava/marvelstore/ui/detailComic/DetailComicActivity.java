package com.estudoparajava.marvelstore.ui.detailComic;

import androidx.appcompat.app.AppCompatActivity;

import com.estudoparajava.marvelstore.MainActivity;
import com.estudoparajava.marvelstore.R;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DetailComicActivity extends AppCompatActivity {


    private TextView textViewTitleDetail;
    private ImageView imageViewDetail;
    private TextView textViewPriceDetail;
    private TextView textViewDescricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_comic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        textViewTitleDetail = findViewById(R.id.textTitleDetail);
        imageViewDetail = findViewById(R.id.imageDetail);
        textViewPriceDetail = findViewById(R.id.textPriceDetail);


        Bundle dadosTitles = getIntent().getExtras();
        String nome = dadosTitles.getString("title");

        Bundle dadosImage = getIntent().getExtras();
        String imageReference = dadosImage.getString("image");

        Bundle dadosPrice = getIntent().getExtras();
        String priceReference = dadosPrice.getString("price");




        URL url = null;
        try {
            url = new URL(imageReference);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        textViewTitleDetail.setText(nome);
        imageViewDetail.setImageBitmap(bmp);
        textViewPriceDetail.setText(priceReference);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, MainActivity.class));
            finishAffinity();
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, MainActivity.class));
        finishAffinity();
    }
}