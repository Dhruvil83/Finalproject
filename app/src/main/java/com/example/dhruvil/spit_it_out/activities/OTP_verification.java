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

import com.example.dhruvil.spit_it_out.Models.Register;
import com.example.dhruvil.spit_it_out.R;
import com.example.dhruvil.spit_it_out.webservices.RetrofitInterface;
import com.example.dhruvil.spit_it_out.webservices.Retrofitclient;
import com.google.gson.JsonElement;

import java.util.Random;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
        registerApi();
        sendotp();
    }private void findview() {

        button1 = findViewById(R.id.next1);
        editText1 = findViewById(R.id.otp1);
        editText2 = findViewById(R.id.otp2);
        editText3 = findViewById(R.id.otp3);
        editText4 = findViewById(R.id.otp4);
        imageView = findViewById(R.id.back);
        otpcode = findViewById(R.id.otpcode);
        mobilenum = findViewById(R.id.mobilenum);
    }
    private void setlistner() {

        mobilenum.setText(phonenum);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpinput = editText1.getText().toString() + editText2.getText().toString() + editText3.getText().toString() + editText4.getText().toString();
                confirmtelstore();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                Intent intent = new Intent(OTP_verification.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
private void  confirmtelstore(){

    Register mobile = new Register();
    RetrofitInterface retrofitInterface = Retrofitclient.getClient().create(RetrofitInterface.class);
    Call<ResponseBody> call = retrofitInterface.updateOTPOnServer( phonenum,"1234","android");
    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (otpinput.equals(checkNum)) {
                startActivity(new Intent(OTP_verification.this, Successfully_register.class));
                Toast.makeText(OTP_verification.this, "Api is working", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(OTP_verification.this, "Please enter correct otp", Toast.LENGTH_LONG).show();
            }
        }
        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {

            Toast.makeText(OTP_verification.this, "Api is not working", Toast.LENGTH_LONG).show();
        }
    });

}
private  void registerApi(){

    RetrofitInterface retrofitInterface = Retrofitclient.getClient().create(RetrofitInterface.class);
    Call<JsonElement> call = retrofitInterface.registeruser("123", phonenum,"android");
    call.enqueue(new Callback<JsonElement>() {
        @Override
        public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {

            Toast.makeText(OTP_verification.this, "Response Success", Toast.LENGTH_LONG).show();
        }
        @Override
        public void onFailure(Call<JsonElement> call, Throwable t) {
            Toast.makeText(OTP_verification.this,"Response failure",Toast.LENGTH_LONG).show();
        }
    });
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
        sendotp();
    }
private void sendotp(){
    RetrofitInterface retrofitInterface = Retrofitclient.getClient().create(RetrofitInterface.class);
    Call<ResponseBody> call = retrofitInterface.gettoken(phonenum,checkNum);
    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            Toast.makeText(OTP_verification.this, "otpApi is working", Toast.LENGTH_LONG).show();
        }

        @Override

        public void onFailure(Call<ResponseBody> call, Throwable t) {

            Toast.makeText(OTP_verification.this, "otpApi is not working", Toast.LENGTH_LONG).show();
        }
    });
}

    public void intent() {
        Bundle bundle = getIntent().getExtras();
        if ( bundle != null ) {
            phonenum = bundle.getString("phonenum");
            Log.e("phone_to_confirm", phonenum);
        }

    }
}
