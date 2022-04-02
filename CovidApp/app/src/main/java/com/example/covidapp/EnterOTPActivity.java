package com.example.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class EnterOTPActivity extends AppCompatActivity {

    private String TAG = EnterOTPActivity.class.getName();
    private TextInputLayout txtlOTP;
    private AppCompatButton btnSendOTP;
    private TextView tvSendOTPAgain;
    private TextView tvSDT;
    private String strPhonNumber;
    private String strVerifyID;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.ForceResendingToken mForceResendingToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_o_t_p);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        getDataInten();
        anhXa();


    }

    private void getDataInten()
    {
        strPhonNumber = getIntent().getStringExtra("phone_number");
        strVerifyID = getIntent().getStringExtra("verifyID");
    }

    private void anhXa() {
        tvSDT = (TextView) findViewById(R.id.tvSDT_OTP);
        txtlOTP = (TextInputLayout) findViewById(R.id.txtlOTP);
        btnSendOTP = (AppCompatButton) findViewById(R.id.btnSendOTP);
        tvSendOTPAgain = (TextView) findViewById(R.id.tvSendOTPAgain);
        btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSendOTP(txtlOTP.getEditText().getText().toString().trim());
            }
        });

        tvSendOTPAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOTP_Again();
            }
        });
        tvSDT.setText(strPhonNumber);
    }

    private void onClickSendOTP(String strOTP) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(strVerifyID, strOTP);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.e(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            // Update UI
                            goToMainActivity(user.getUid());
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.e(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(EnterOTPActivity.this,"signInWithPhoneAuthCredential Fail",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

    private void sendOTP_Again() {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(strPhonNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)// Activity (for callback binding)
                        .setForceResendingToken(mForceResendingToken)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signInWithPhoneAuthCredential(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(EnterOTPActivity.this,"onVerificationFailed",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verifyID, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(verifyID, forceResendingToken);
                                strVerifyID = verifyID;
                                mForceResendingToken = forceResendingToken;
                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

    private void goToMainActivity(String uid) {
        Intent intent = new Intent(this, KhaiBaoYTe.class);
        intent.putExtra("uid",uid);
        startActivity(intent);
        finishAffinity();
    }


}