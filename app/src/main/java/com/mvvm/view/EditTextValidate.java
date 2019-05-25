package com.mvvm.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mvvm.R;
import com.mvvm.viewmodel.EditTextViewModel;
import com.raywenderlich.android.validatetor.ValidateTor;

public class EditTextValidate extends AppCompatActivity {

    EditText edt_first_name, edt_last_name, edt_email, edt_password, edt_password_confirm, edt_gender, edt_country, edt_creditcard;
    ValidateTor validateTor;
    Button btn_validate;
    EditTextViewModel editTextViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.et_validator);
        edt_first_name = (EditText) findViewById(R.id.edt_first_name);

        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);

        edt_creditcard = (EditText) findViewById(R.id.edt_creditcard);
        btn_validate = (Button) findViewById(R.id.btn_validate);
        editTextViewModel = ViewModelProviders.of(this).get(EditTextViewModel.class);
        setUpUiWidgets();
        //   validateTor = new ValidateTor();










    }

    private void setUpUiWidgets() {
        btn_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextViewModel.validateEmailField(edt_email);
                editTextViewModel.validatePasswordField(edt_password);
                editTextViewModel.validateCreditCardField(edt_creditcard);
                editTextViewModel.validateNameField(edt_first_name);

            }
        });
    }


}
