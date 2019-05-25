package com.mvvm.model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.mvvm.R;
import com.mvvm.utils.MyWebService;
import com.mvvm.utils.NetworkHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {


    private final boolean networkOk;
    Application application;

    String mResponse;
    MutableLiveData<String> mutableLiveData;
    Auth auth;
    MutableLiveData<Response<Auth>> mutableLiveUser;
    public AuthRepository(Application application) {
        this.application = application;
        networkOk = NetworkHelper.hasNetworkAccess(application);
    }


    public MutableLiveData<String> requestData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        MyWebService webService =
                MyWebService.retrofit.create(MyWebService.class);
        Call<String> call = webService.authentication();
        mutableLiveData = sendRequest(call);
        return mutableLiveData;
    }


    public MutableLiveData<String> sendRequest(Call<String> call) {
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String message = response.body();
                mutableLiveData.setValue(message);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<Response<Auth>> requestUser(Auth auth) {
        if (mutableLiveUser == null) {
            mutableLiveUser = new MutableLiveData<Response<Auth>>();
        }
        MyWebService webService =
                MyWebService.retrofit.create(MyWebService.class);
        Call<Auth> call = webService.createUser(auth);
        mutableLiveUser = sendUser(call);
        return mutableLiveUser;
    }
    public MutableLiveData<Response<Auth>> sendUser(Call<Auth> call) {
        call.enqueue(new Callback<Auth>() {
            @Override
            public void onResponse(Call<Auth> call, Response<Auth> response) {

                mutableLiveUser.setValue(response);
            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {

            }
        });
        return mutableLiveUser;
    }

    public void showSnackbar(String message, View view) {
        Snackbar snackbar = Snackbar
                .make(view.getRootView(), message, Snackbar.LENGTH_LONG)
                .setAction(R.string.retry, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

// Changing message text color
        snackbar.setActionTextColor(Color.RED);

// Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }
}
