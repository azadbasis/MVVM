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

        //For ViewModel
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = mainActivityViewModel.additionFunctions(et1.getText().toString(), et2.getText().toString());
                Toast.makeText(MainActivity.this, "Add " + result, Toast.LENGTH_SHORT).show();

            }
        });
        //For LiveData
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainActivityViewModel.additionFunction(et1.getText().toString(), et2.getText().toString()).observe(MainActivity.this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        Toast.makeText(MainActivity.this, "Add " + s, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
