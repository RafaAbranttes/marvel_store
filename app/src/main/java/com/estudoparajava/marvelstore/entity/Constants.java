package com.estudoparajava.marvelstore.entity;



public class Constants {


    private static final String API_KEY = "";
    private static final String PRIVATE_KEY = "";
    private static final String ts = String.valueOf(System.currentTimeMillis());

    public static String getApiKey() {
        return API_KEY;
    }

    public static String getPrivateKey() {
        return PRIVATE_KEY;
    }

    public static String getTs() {
        return ts;
    }

}
