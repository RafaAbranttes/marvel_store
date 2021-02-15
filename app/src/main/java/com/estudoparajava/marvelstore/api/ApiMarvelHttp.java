package com.estudoparajava.marvelstore.api;


import android.util.Log;


import com.estudoparajava.marvelstore.entityAPI.ComicData;
import com.estudoparajava.marvelstore.entityAPI.Constants;
import com.estudoparajava.marvelstore.extension.StringHash;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiMarvelHttp {

    public static HttpUrl API_URL = HttpUrl.parse("http://gateway.marvel.com/v1/public/");
    private static final String PATH_COMIC = "comics";


    //parameters requested by API
    // ts ----> time stamp key
    // hash ----> hash key
    //aplikey ----> api key

    private static final String pwd = String.valueOf(System.currentTimeMillis())+Constants.getPrivateKey()+Constants.getApiKey();

    public static ComicData getAllComics (String query, int offset){

        Log.d("RMS", "getAllCharacter - HTTP");
        ComicData comic = null;
        OkHttpClient client = new OkHttpClient();

        if(query == null){
            query = "";
        }

        HttpUrl url = API_URL.newBuilder()
                .addPathSegment(PATH_COMIC)
                .addQueryParameter("ts", Constants.getTs())
                .addQueryParameter("apikey", Constants.getApiKey())
                .addQueryParameter("hash", StringHash.encryptMD5())
                .addQueryParameter("title", query)
                //.addQueryParameter("orderBy", "title")
                .addQueryParameter("limit", String.valueOf(10))
                .build();


        Request request = new Request.Builder().url(url).build();
        Response response = null;

        //utilizando para retornar os dados da api
        try {
            response = client.newCall(request).execute();
            String json = response.body().string();
            //System.out.println(response);
            //System.out.println(json);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            comic = gson.fromJson(json, ComicData.class);

            System.out.println(comic.getCode()); //saber se a conexão foi recebida

        }catch (Exception exception){
            if ( comic != null) Log.d("RMS","erro return code ");
            exception.printStackTrace();
        }

        return comic;

    }


}
