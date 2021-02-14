package com.estudoparajava.marvelstore.entityAPI;



public class Constants {


    private static final String API_KEY = ""; //chave publica
    private static final String PRIVATE_KEY = "";   //chave privafa

    //tempo pedido pela API para utilizar a API

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
