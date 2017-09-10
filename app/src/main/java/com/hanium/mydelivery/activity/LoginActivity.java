package com.hanium.mydelivery.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanium.mydelivery.handler.BackPressCloseHandler;
import com.hanium.mydelivery.R;
import com.hanium.mydelivery.api.domain.LoginUserDTO;
import com.hanium.mydelivery.api.domain.ResponseDTO;
import com.hanium.mydelivery.util.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private BackPressCloseHandler backPressCloseHandler;
    private EditText loginID;
    private EditText loginPassword;

    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backPressCloseHandler = new BackPressCloseHandler(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textTitle = (TextView)toolbar.findViewById(R.id.text_title);
        textTitle.setText("My Delivery - 로그인");
        setSupportActionBar(toolbar);

        loginID = (EditText) findViewById(R.id.input_id);
        loginPassword = (EditText) findViewById(R.id.input_password);

        Button login_btn = (Button) findViewById(R.id.login_button);
        login_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUserDTO dto = new LoginUserDTO();
                dto.setName(loginID.getText().toString());
                dto.setPassword(loginPassword.getText().toString());
                RetrofitHelper.getInstance().requestLogin(dto, new Callback<ResponseDTO>() {
                    @Override
                    public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                        if(response.body().getSuccess() == 1)
                            doLogin();
                        else
                            Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(LoginActivity.this, "서버오류", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button register_btn = (Button) findViewById(R.id.register);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(LoginActivity.this, "회원가입 버튼 클릭", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Button find_btn = (Button) findViewById(R.id.find_id_pass);
        find_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "아이디/비밀번호 찾기 버튼 클릭", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void doLogin() {
        Toast.makeText(LoginActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
