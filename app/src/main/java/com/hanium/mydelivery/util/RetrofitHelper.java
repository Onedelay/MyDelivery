package com.hanium.mydelivery.util;

import com.hanium.mydelivery.Data.Shop;
import com.hanium.mydelivery.api.RetrofitService;
import com.hanium.mydelivery.api.domain.LoginUserDTO;
import com.hanium.mydelivery.api.domain.ResponseDTO;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by su_me on 2017-09-02.
 */

public class RetrofitHelper {
    private static final String BASE_URL = "http://52.79.105.67:3000";
    private static RetrofitHelper instance;
    private Retrofit retrofit;
    private RetrofitService retrofitService;

    public static RetrofitHelper getInstance() {
        if(instance == null) {
            instance = new RetrofitHelper();
        }
        return instance;
    }

    private RetrofitHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }

    public void requestLogin(LoginUserDTO dto, Callback<ResponseDTO> callback) {
        retrofitService.loginUser(dto).enqueue(callback);
    }

    public void getRstrList(Callback<ArrayList<Shop>> callback, int type){
        retrofitService.getRstrList(type).enqueue(callback);
    }
}
