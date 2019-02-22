package com.example.dhruvil.spit_it_out;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhruvil.spit_it_out.Models.PhoneNumberModel;

public class LoginActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    String phonenum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        button = findViewById(R.id.buttonN);
        editText=findViewById(R.id.edittext1);
        phonenum=editText.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(LoginActivity.this, OTP_verification.class).putExtra("phonenum",phonenum);


                if(isValidPhone(editText.getText().toString())){
                    startActivity(intent);


                    Toast.makeText(getApplicationContext(),"Phone number is valid",Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(getApplicationContext(),"Phone number is not valid",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    public boolean isValidPhone(CharSequence phone) {
        if ( TextUtils.isEmpty(phone)) return false;
        else {
            return android.util.Patterns.PHONE.matcher(phone).matches();

        }
    }
}

