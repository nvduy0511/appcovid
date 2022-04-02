package com.example.covidapp.api;

import com.example.covidapp.model.entity.ConNguoi;
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
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface PhieuKhaiBaoYTeService {
    Gson gson = new GsonBuilder()
            .setDateFormat("dd-MM-yyyy HH:mm:ss")
            .create();
    PhieuKhaiBaoYTeService phieuKhaiBaoYTeService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.246:8081/")
            .addConverterFactory(new NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(PhieuKhaiBaoYTeService.class);

    @GET("phieukhaibaoyte/getone")
    Call<PhieuKhaiBaoYTe> getOnePhieuKhaiBaoYTe(@Query("maphieu") String maphieu);

    @POST("phieukhaibaoyte/add")
    Call<Boolean> addPhieuKhaiBaoYTe(@Body PhieuKhaiBaoYTe phieuKhaiBaoYTe);

    @PUT("phieukhaibaoyte/update")
    Call<Boolean> updatePhieuKhaiBaoYTe(@Query("maphieu") String maphieu,@Body PhieuKhaiBaoYTe phieuKhaiBaoYTe);
}
