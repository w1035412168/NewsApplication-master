package com.example.anxia.newsapplication.net;

import com.example.anxia.newsapplication.bean.News;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("getnews.php")
    Flowable<HttpResult<List<News>>> getNews();
}
