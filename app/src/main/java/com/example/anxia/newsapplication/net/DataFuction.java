package com.example.anxia.newsapplication.net;

import io.reactivex.functions.Function;

public class DataFuction<T> implements Function<HttpResult<T>,T> {

    @Override
    public T apply(HttpResult<T> tHttpResult) throws Exception {
        if (tHttpResult.getCode()!=0){
            throw new Exception();
        }else return tHttpResult.getData();

    }
}
