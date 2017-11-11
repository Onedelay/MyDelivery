package com.hanium.mydelivery.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hanium.mydelivery.R;
import com.hanium.mydelivery.api.domain.ImageLoginUserDTO;
import com.hanium.mydelivery.api.domain.LoginUserDTO;
import com.hanium.mydelivery.api.domain.ResponseDTO;
import com.hanium.mydelivery.util.RetrofitHelper;

import java.io.FileNotFoundException;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginTestActivity extends AppCompatActivity {
    public static final int REQUEST_IMAGE = 100;
    private EditText loginID;
    private String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);

        // Adding Toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textTitle = (TextView)toolbar.findViewById(R.id.text_title);
        textTitle.setText("My Delivery - 업체정보");

        Button image_select_btn = (Button) findViewById(R.id.image_select);
        image_select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_IMAGE);
            }
        });

        loginID = (EditText) findViewById(R.id.sign_id);

        Button signLoginBtn = (Button) findViewById(R.id.sign_login);
        signLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageLoginUserDTO dto = new ImageLoginUserDTO();
                dto.setName(loginID.getText().toString());
                dto.setImageName(imageName);
                RetrofitHelper.getInstance().requestImageLogin(dto, new Callback<ResponseDTO>() {
                    @Override
                    public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                        if(response.body().getSuccess() == 1)
                            doLogin();
                        else
                            Toast.makeText(LoginTestActivity.this, "로그인 실패"+imageName, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(LoginTestActivity.this, "서버오류", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    //Uri에서 이미지 이름을 얻어온다.
                    // String name_Str = getImageNameToUri(data.getData());
                    imageName = getImageNameToUri(data.getData());

                    TextView textView = (TextView) findViewById(R.id.sign_name);
                    textView.setText(imageName);

                    //이미지 데이터를 비트맵으로 받아온다.
                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    ImageView image = (ImageView) findViewById(R.id.sign_image);

                    //배치해놓은 ImageView에 set
                    image.setImageBitmap(image_bitmap);


                    //Toast.makeText(getBaseContext(), "name_Str : "+name_Str , Toast.LENGTH_SHORT).show();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public String getImageNameToUri(Uri data)
    {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);

        return imgName;
    }

    public void doLogin() {
        Toast.makeText(LoginTestActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginTestActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
