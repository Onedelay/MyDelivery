package com.hanium.mydelivery.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hanium.mydelivery.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        // Adding Toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textTitle = (TextView)toolbar.findViewById(R.id.text_title);
        textTitle.setText("My Delivery - 회원가입");
        setSupportActionBar(toolbar);

        Spinner spinner = (Spinner) findViewById(R.id.head_address);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.H_address, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button register_ok = (Button)findViewById(R.id.register_ok);
        register_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Button register_cancel = (Button)findViewById(R.id.register_cancel);
        register_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "회원가입이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
