package com.example.covidapp.api;

import com.example.covidapp.model.entity.ConNguoi;
import com.example.covidapp.model.thongtincanhiem.ThongTinCaNhiem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ConNguoiService{
    Gson gson = new GsonBuilder()
            .setDateFormat("dd-MM-yyyy HH:mm:ss")
            .create();
    ConNguoiService conNguoiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.246:8081/")
            .addConverterFactory(new NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ConNguoiService.class);

    @GET("connguoi/getone")
    Call<ConNguoi> getOneConNguoi(@Query("cmnd") String cmnd);

    @POST("connguoi/add")
    Call<Boolean> addConNguoi(@Body ConNguoi conNguoi);

    @PUT("connguoi/update")
    Call<Boolean> updateConNguoi(@Query("cmnd") String cmnd,@Body ConNguoi conNguoi);

}
