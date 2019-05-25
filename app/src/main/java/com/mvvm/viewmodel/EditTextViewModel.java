package com.mvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.Toast;

import com.mvvm.model.Auth;
import com.mvvm.model.AuthRepository;
import com.raywenderlich.android.validatetor.ValidateTor;

import retrofit2.Response;

public class EditTextViewModel extends AndroidViewModel {

    ValidateTor validateTor;

    public EditTextViewModel(@NonNull Application application) {
        super(application);
        validateTor = new ValidateTor();


    }


    //ViewModel

    public String additionFunctions(String v1, String v2) {
        int n1 = Integer.valueOf(v1);
        int n2 = Integer.valueOf(v2);
        int result = n1 + n2;
        return String.valueOf(result);
    }

    public void validateNameField(EditText edt_text) {
        String str = edt_text.getText().toString();

        if (validateTor.isEmpty(str)) {
            edt_text.setError("Field is empty!");
        }
        if (validateTor.isAtleastLength(str, 2)
                && validateTor.isAtMostLength(str, 24)

        ) {

        } else {
            {
                edt_text.setError("Name needs to be of minimum length of 2 characters and maximum length of 24 characters");

            }
        }
    }

    public void validateEmailField(EditText edt_email) {

        String str = edt_email.getText().toString();

        if (validateTor.isEmpty(str)) {
            edt_email.setError("Field is empty!");
        }

        if (!validateTor.isEmail(str)) {
            edt_email.setError("Invalid Email entered!");
        } else {
            Toast.makeText(getApplication(), "Valid Email!", Toast.LENGTH_SHORT).show();
        }
    }

    public void validatePasswordField(EditText edt_password) {
        String password = edt_password.getText().toString();
        // Check if password field is empty
        if (validateTor.isEmpty(password)) {
            edt_password.setError("Field is empty!");
        }


// Check password string to be of minimum length of 8 characters and should have
// atleast 1 digit, 1 upppercase letter and 1 special character
        if (validateTor.isAtleastLength(password, 8)
                && validateTor.hasAtleastOneDigit(password)
                && validateTor.hasAtleastOneUppercaseCharacter(password)
                && validateTor.hasAtleastOneSpecialCharacter(password)) {

            // Valid Password

        } else {
            // Invalid Password, handle in ui
            edt_password.setError("Password needs to be of minimum length of 8 characters and should have " +
                    "atleast 1 digit, 1 upppercase letter and 1 special character ");
        }
    }

    public void validateCreditCardField(EditText edt_email) {

        String str = edt_email.getText().toString();

        if (validateTor.isEmpty(str)) {
            edt_email.setError("Field is empty!");
        }

        if (!validateTor.validateCreditCard(str)) {
            edt_email.setError("Invalid Credit Card number!");
        } else {
            Toast.makeText(getApplication(), "Valid Credit Card Number!", Toast.LENGTH_SHORT).show();
        }
    }
}
