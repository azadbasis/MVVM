package com.mvvm.utils;


import com.mvvm.model.Auth;
import com.mvvm.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyWebService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @GET(AppConstants.AUTH)
    Call<String> authentication();

    @POST(AppConstants.AUTH)
    Call<Auth> createUser(@Body Auth auth);



}
