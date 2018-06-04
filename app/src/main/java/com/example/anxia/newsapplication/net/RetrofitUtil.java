package com.example.anxia.newsapplication.net;

import com.example.anxia.newsapplication.bean.Constants;
import com.example.anxia.newsapplication.bean.News;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    public static void getNews(Subscriber<List<News>> subscriber){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService=retrofit.create(ApiService.class);

       Flowable<HttpResult<List<News>>> flowable=apiService.getNews();
        flowable.map(new DataFuction<List<News>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
