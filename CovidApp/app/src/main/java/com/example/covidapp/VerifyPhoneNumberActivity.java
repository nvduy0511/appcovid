package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VerifyPhoneNumberActivity extends AppCompatActivity {

    private Button btnVerify;
    private EditText edtPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_number);
        anhXa();
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = edtPhoneNumber.getText().toString().trim();
                onClickVerifyPhoneNumber(phoneNumber);
            }
        });
    }

    private void onClickVerifyPhoneNumber(String phoneNumber) {

    }

    private void anhXa() {
        btnVerify = (Button) findViewById(R.id.btnVerify);
        edtPhoneNumber = (EditText) findViewById(R.id.edtSDT);
    }
}