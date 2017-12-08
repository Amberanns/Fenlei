package com.bawei.myapplication.api;

import com.bawei.myapplication.bean.Leftbean;
import com.bawei.myapplication.bean.Rightbean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;



public interface ApiService {
    @GET("product/getCatagory")
    Observable<Leftbean> getDaes();

    @POST
    Observable<Rightbean> getDass(@Url String url, @QueryMap Map<String, Integer> map);
}

