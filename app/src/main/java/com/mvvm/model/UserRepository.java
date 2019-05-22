package com.mvvm.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserRepository {

    String url = "https://api.github.com/users";
    Application application;

    public UserRepository(Application application) {
        this.application = application;
    }

    User[] users;
    MutableLiveData<User[]> mutableLiveData;

    public MutableLiveData<User[]> getUserData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        RequestQueue queue = Volley.newRequestQueue(application);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        users = gson.fromJson(response, User[].class);
                        mutableLiveData.setValue(users);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        queue.add(stringRequest);
        return mutableLiveData;
    }
}
