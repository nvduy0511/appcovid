package com.example.covidapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView tvTenNguoiDung;
    private RelativeLayout rlKhaiBaoYTe;
    private RelativeLayout rlThongTinCaNhiem;
    private RelativeLayout rlThongTinCaNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        anhXa();
    }

    private void anhXa(){
        tvTenNguoiDung = findViewById(R.id.tv_user_name);
        rlKhaiBaoYTe = findViewById((R.id.rectangle_3));
        rlThongTinCaNhiem = findViewById(R.id.btn_thongtincanhiem);
        rlThongTinCaNhan =  findViewById(R.id.btn_thongtincanhan);

        String userName = "Phan Vũ Lợi";
        tvTenNguoiDung.setText(String.format("Xin chào, %s", userName));



        // Chuyển sang màn hình thông tin ca nhiễm cộng đồng
        rlKhaiBaoYTe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Chuyển sang màn hình thông tin ca nhiễm cộng đồng
        rlThongTinCaNhiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ThongTinCaNhiemActivity.class);
                startActivity(intent);
            }
        });

        // Chuyển sang màn hình thông tin cá nhân
        rlThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Click");
                Intent intent = new Intent(HomeActivity.this, ThongTinCaNhanActivity.class);
                startActivity(intent);
            }
        });
    }
}