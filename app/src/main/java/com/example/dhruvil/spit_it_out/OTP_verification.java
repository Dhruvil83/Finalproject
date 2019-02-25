package com.example.dhruvil.spit_it_out;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class OTP_verification extends AppCompatActivity {
    Button button1;
    String phonenum;
    EditText editText1,editText2,editText3,editText4;
    ImageView imageView;
    String otpinput;
    TextView mobilenum;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        findview();
        setlistner();
        otp();
        intent();
    }

    private void setlistner() {

        mobilenum.setText(phonenum);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpinput = editText1.getText().toString() + editText2.getText().toString() + editText3.getText().toString() + editText4.getText().toString();


            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                Intent intent=new Intent(OTP_verification.this, Successfully_register.class);
                startActivity(intent);


            }

        });
    }
    private void findview() {

        button1 = findViewById(R.id.next1);
        editText1 = findViewById(R.id.otp1);
        editText2 = findViewById(R.id.otp2);
        editText3 = findViewById(R.id.otp3);
        editText4 = findViewById(R.id.otp4);
        imageView = findViewById(R.id.back);
        mobilenum = findViewById(R.id.mobilenum);
    }

    public void otp()
    {
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText1!=null)
                {
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
                if(editText2!=null)
                {
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
                if(editText3!=null)
                {
                    editText4.requestFocus();
                }
            }
        });
     }

     public void intent()
     {
         Bundle bundle=getIntent().getExtras();
         phonenum=bundle.getString("phonenum");

     }

}
