package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterOTPActivity extends AppCompatActivity {

    private EditText edtOTP;
    private Button btnSendOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_o_t_p);
        anhXa();
        btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSendOTP();
            }
        });
    }

    private void onClickSendOTP() {

    }

    private void anhXa() {
        edtOTP = (EditText) findViewById(R.id.edtOTP);
        btnSendOTP = (Button) findViewById(R.id.btnSendOTP);
    }
}