package com.example.dhruvil.spit_it_out.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.dhruvil.spit_it_out.R;

public class Successfully_register extends AppCompatActivity {
    private static int splash = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfully_register);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Successfully_register.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splash);


    }

}

