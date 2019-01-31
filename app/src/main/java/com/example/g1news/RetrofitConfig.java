package com.example.g1news;

import com.example.g1news.services.G1Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {


    public static Retrofit getRetrofitConfig(){
        return new Retrofit.Builder()
                .baseUrl(G1Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
