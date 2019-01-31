package com.example.g1news.services;

import com.example.g1news.models.News;
import com.example.g1news.models.NewsItemsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface G1Service {

    public static final String BASE_URL = "http://falkor-cda.bastian.globo.com/";

    @GET("feeds/b904b430-123a-4f93-8cf4-5365adf97892/posts/page/{page_number}")
    Call<NewsItemsResponse> getNews(@Path("page_number") String page_number);

}
