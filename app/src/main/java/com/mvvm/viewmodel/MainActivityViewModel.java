package com.mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {


    //ViewModel

    public String additionFunctions(String v1, String v2) {
        int n1 = Integer.valueOf(v1);
        int n2 = Integer.valueOf(v2);
        int result = n1 + n2;
        return String.valueOf(result);
    }

    //LiveData
    MutableLiveData<String> resultLiveData;

    public MutableLiveData<String> additionFunction(String v1, String v2) {
        int n1 = Integer.valueOf(v1);
        int n2 = Integer.valueOf(v2);
        int result = n1 + n2;
        if (resultLiveData == null) {
            resultLiveData=new MutableLiveData<>();
        }
        resultLiveData.setValue(String.valueOf(result));
        return resultLiveData;
    }
}
