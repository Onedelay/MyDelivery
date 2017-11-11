package com.hanium.mydelivery.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hanium.mydelivery.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                finish();
            }
        }, 2000);
    }
}
