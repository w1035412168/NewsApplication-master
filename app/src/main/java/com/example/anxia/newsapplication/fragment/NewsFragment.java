package com.example.anxia.newsapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anxia.newsapplication.R;
import com.example.anxia.newsapplication.adapter.MyRecyclerViewAdapter;
import com.example.anxia.newsapplication.bean.News;
import com.example.anxia.newsapplication.net.RetrofitUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<News> newsList;
    private View view;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.fragment_news, container, false);
        initView();
        init();
        return view;
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter(R.layout.recycler_item,newsList);

        recyclerView.setAdapter(adapter);
        RetrofitUtil.getNews(new Subscriber<List<News>>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(List<News> news) {
                adapter.addData(news);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void initView() {
        recyclerView=view.findViewById(R.id.recycler_view);

    }

}
