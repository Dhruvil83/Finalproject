package com.example.dhruvil.spit_it_out.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhruvil.spit_it_out.R;

import java.util.Random;


public class OTP_verification extends AppCompatActivity {
    Button button1;
    EditText editText1, editText2, editText3, editText4;
    ImageView imageView;
    String otpinput, checkNum, phonenum;
    TextView mobilenum, otpcode;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        findview();
        setlistner();
        otp();
        intent();
        sendconfirmation();
    }

    private void setlistner() {

        mobilenum.setText(phonenum);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpinput = editText1.getText().toString() + editText2.getText().toString() + editText3.getText().toString() + editText4.getText().toString();
                if (otpinput.equals(checkNum)) {
                    startActivity(new Intent(OTP_verification.this, Successfully_register.class));
                } else {
                    Toast.makeText(OTP_verification.this, "Please Enter correct otp", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(OTP_verification.this, "Successfully Registered", Toast.LENGTH_LONG).show();
            }


        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                Intent intent = new Intent(OTP_verification.this, LoginActivity.class);
                startActivity(intent);


            }

        });    }

    private void findview() {

        button1 = findViewById(R.id.next1);
        editText1 = findViewById(R.id.otp1);
        editText2 = findViewById(R.id.otp2);
        editText3 = findViewById(R.id.otp3);
        editText4 = findViewById(R.id.otp4);
        imageView = findViewById(R.id.back);
        otpcode = findViewById(R.id.otpcode);
        mobilenum = findViewById(R.id.mobilenum);
    }

    public void otp() {
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ( editText1 != null ) {
                    editText2.requestFocus();
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ( editText2 != null ) {
                    editText3.requestFocus();
                }
            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ( editText3 != null ) {
                    editText4.requestFocus();
                }
            }
        });
    }

    private void sendconfirmation() {
        checkNum = "";

        final Random rand = new Random();
        int min = 1000;
        int max = 9999;


        Log.w("confirmation", "sending confirmation sms to :" + phonenum);

        checkNum = Integer.toString(rand.nextInt((max - min) + 1) + min);
        otpcode.setText(checkNum);

    }

    public void intent() {
        Bundle bundle = getIntent().getExtras();
        if ( bundle != null ) {
            phonenum = bundle.getString("phonenum");
            Log.e("phone_to_confirm", phonenum);
        }

    }
}
