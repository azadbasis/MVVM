package com.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.mvvm.model.User;
import com.mvvm.model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {


    UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<User[]> getAllUser(){

        return userRepository.getUserData();
    }
}
