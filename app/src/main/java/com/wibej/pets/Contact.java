package com.wibej.pets;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tufrac on 6/30/17.
 */

public class Contact extends AppCompatActivity {
    private TextInputEditText editTextName;
    private TextInputEditText editTextEmail;
    private TextInputEditText editTextMessage;
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutMessage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        editTextName = (TextInputEditText) findViewById(R.id.tietName);
        editTextEmail = (TextInputEditText) findViewById(R.id.tietEmail);
        editTextMessage = (TextInputEditText) findViewById(R.id.tietMessage);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        textInputLayoutName = (TextInputLayout) findViewById(R.id.tilName);
        textInputLayoutMessage = (TextInputLayout) findViewById(R.id.tilMessage);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void buttonSend(View v){
        if(!validateContactFields()){
            sendEmail();
            Intent intentMain = new Intent(this, MainActivity.class);
            startActivity(intentMain);
        }
    }
    private Boolean validateContactFields(){
        String mailError = null;
        String isRequiredMessage = null;
        Boolean isInvalid = false;
        if(TextUtils.isEmpty(editTextName.getText())){
            isRequiredMessage = "This field is required";
            isInvalid = true;
        }
        toggleTextInputLayoutError(textInputLayoutName, isRequiredMessage);

        isRequiredMessage = null;
        if(TextUtils.isEmpty(editTextEmail.getText())){
            isRequiredMessage = "This field is required";
            isInvalid = true;
        }
        toggleTextInputLayoutError(textInputLayoutEmail, isRequiredMessage);

        isRequiredMessage = null;
        if(TextUtils.isEmpty(editTextMessage.getText())){
            isRequiredMessage = "This field is required";
            isInvalid = true;
        }
        toggleTextInputLayoutError(textInputLayoutMessage, isRequiredMessage);

        if(!isEmailValid(editTextEmail.getText().toString())){
            mailError = "Invalid Email";
            isInvalid = true;
        }

        toggleTextInputLayoutError(textInputLayoutEmail, mailError);

        return isInvalid;
    }
    private void sendEmail() {
        String email = editTextEmail.getText().toString().trim();
        String subject = editTextName.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        SendMail sm = new SendMail(this, email, subject, message);

        sm.execute();
    }


    public static boolean isEmailValid(String email){
        boolean isValid = false;
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(email.matches(emailPattern) && email.length() > 0){
            isValid = true;
        }

        return isValid;
    }

    /**
     * Display/hides TextInputLayout error.
     *
     * @param msg the message, or null to hide
     */
    private static void toggleTextInputLayoutError(@NonNull TextInputLayout textInputLayout, String msg){
        textInputLayout.setError(msg);
        if (msg == null){
            textInputLayout.setErrorEnabled(false);
        } else{
            textInputLayout.setErrorEnabled(true);
        }
    }

}
