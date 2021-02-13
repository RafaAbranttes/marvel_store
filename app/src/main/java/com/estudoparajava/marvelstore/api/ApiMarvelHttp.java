package com.estudoparajava.marvelstore.api;


import android.util.Log;

import com.estudoparajava.marvelstore.entity.Comic;
import com.estudoparajava.marvelstore.entity.Constants;
import com.estudoparajava.marvelstore.extension.StringHash;
import com.google.gson.Gson;

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

    public static Comic getAllComics (String query, int offset){

        Log.d("RMS", "getAllCharacter - HTTP");
        Comic comic = null;
        OkHttpClient client = new OkHttpClient();

        if(query == null){
            query = "";
        }

        HttpUrl url = API_URL.newBuilder()
                .addPathSegment(PATH_COMIC)
                .addQueryParameter("ts", Constants.getTs())
                .addQueryParameter("apikey", Constants.getApiKey())
                .addQueryParameter("hash", StringHash.encryptMD5())
                .addQueryParameter("title", "avengers")
                //.addQueryParameter("orderBy", "title")
                .addQueryParameter("limit", String.valueOf(1))
                .build();


        Request request = new Request.Builder().url(url).build();
        System.out.println(request);
        Response response = null;

        try {
            response = client.newCall(request).execute();
//            String json = response.body().string();
//            System.out.println(response);
//            System.out.println(json.getClass());
//            Gson gson = new Gson();
            //System.out.println(gson.fromJson(json, ));

            //gson.fromJson(json, comic.getClass());


        }catch (Exception exception){
            if ( comic != null) Log.d("RMS","erro return code ");
            exception.printStackTrace();
        }

        return comic;

    }
}
