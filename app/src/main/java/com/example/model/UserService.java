package com.example.model;

import com.google.gson.annotations.JsonAdapter;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {


    @POST("user/authentication")
     Call<ResObj> login(@Body Auth auth);

    @POST("user")
    Call<UserModel> create(@Body UserModel user);


}
