package com.example.covidapp.api;

import com.example.covidapp.model.entity.NguoiDung;
import com.example.covidapp.model.entity.PhieuKhaiBaoYTe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NguoiDungService {
    Gson gson = new GsonBuilder()
            .setDateFormat("dd-MM-yyyy HH:mm:ss")
            .create();
    NguoiDungService nguoiDungService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.246:8081/")
            .addConverterFactory(new NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(NguoiDungService.class);

    @GET("nguoidung/getone")
    Call<NguoiDung> getOneNguoiDung(@Query("uID") String uID);

    @POST("nguoidung/add")
    Call<Boolean> addNguoiDung(@Body NguoiDung nguoiDung);
}
