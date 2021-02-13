package com.estudoparajava.marvelstore.extension;

import com.estudoparajava.marvelstore.entity.Constants;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class StringHash {

    private static final String privateKey = Constants.getPrivateKey();
    private static final String publicKey = Constants.getApiKey();
    private static String hashMD5;



    private static  final String ts = Constants.getTs();


    public static String encryptMD5(){

        String input = ts + privateKey + publicKey;

        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte [] bytesMD5 = messageDigest.digest(input.getBytes());

            StringBuilder md5  = new StringBuilder();
            for(int i = 0; i < bytesMD5.length ; i++){
                md5.append(Integer.toHexString((bytesMD5[i] & 0XFF) | 0X100).substring(1,3));
            }

            hashMD5 = md5.toString();
            System.out.println(hashMD5);


        }catch (NoSuchElementException | NoSuchAlgorithmException exception){
            exception.printStackTrace();
        }

        return hashMD5;
    }



}
