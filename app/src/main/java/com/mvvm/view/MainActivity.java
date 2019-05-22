package com.mvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvvm.R;
import com.mvvm.model.User;
import com.mvvm.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    EditText et1, et2;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        et2 = findViewById(R.id.et2);
        et1 = findViewById(R.id.et1);
        btnAdd = findViewById(R.id.btnAdd);

        mainActivityViewModel.getAllUser().observe(this, new Observer<User[]>() {
            @Override
            public void onChanged(@Nullable User[] users) {

            }
        });

    }
}
