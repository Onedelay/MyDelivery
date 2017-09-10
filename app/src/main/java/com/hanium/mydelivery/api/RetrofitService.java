package com.hanium.mydelivery.api;

import com.hanium.mydelivery.data.Shop;
import com.hanium.mydelivery.api.domain.LoginUserDTO;
import com.hanium.mydelivery.api.domain.ResponseDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by su_me on 2017-09-02.
 */

public interface RetrofitService {
    @POST("user/login")
    Call<ResponseDTO> loginUser(@Body LoginUserDTO loginUserDTO);

    @GET("rstr/list")
    Call<ArrayList<Shop>> getRstrList(@Query("type") int type);
}
