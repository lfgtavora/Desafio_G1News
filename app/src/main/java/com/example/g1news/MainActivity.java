package com.example.g1news;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.g1news.models.News;
import com.example.g1news.models.NewsItemsResponse;
import com.example.g1news.services.G1Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_news;
    private Retrofit retrofit;
    NewsAdapter newsAdapter;
    private List<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsList = new ArrayList<>();
        rv_news = findViewById(R.id.recyclerView);

        setActionBarLogo();

        setupList();

        G1Service api = RetrofitConfig.getRetrofitConfig().create(G1Service.class);

        api.getNews("1").enqueue(new Callback<NewsItemsResponse>() {
            @Override
            public void onResponse(Call<NewsItemsResponse> call, Response<NewsItemsResponse> response) {
                newsAdapter.setItems(response.body().items);

            }

            @Override
            public void onFailure(Call<NewsItemsResponse> call, Throwable t) {
                Log.i("tag", t.getMessage());
            }
        });

    }

    public void setupList(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_news.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(newsList, getApplicationContext());
        rv_news.setAdapter(newsAdapter);
    }

    public void setActionBarLogo(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.ic_g1_logo);
        actionBar.setTitle("");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }
}
