package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.covidapp.adapter.TinhThanhAdapter;
import com.example.covidapp.adapter.ToKhaiYTeAdapter;
import com.example.covidapp.model.TinhThanh;

import java.util.ArrayList;
import java.util.List;

public class ThongTinCaNhiemActivity extends AppCompatActivity {

    private ImageButton ibtn_back;
    private RecyclerView rcv_thongTinTinhThanh;
    private TinhThanhAdapter tinhThanhAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhiem);
        getSupportActionBar().hide();

        ibtn_back = (ImageButton) findViewById(R.id.ibtn_backThongTinCaNhiem);
        ibtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        rcv_thongTinTinhThanh = (RecyclerView) findViewById(R.id.rcv_ThongTinCaNhiemTinhThanh);

        tinhThanhAdapter = new TinhThanhAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this , RecyclerView.VERTICAL, false );
        rcv_thongTinTinhThanh.setLayoutManager(linearLayoutManager);
        tinhThanhAdapter.setData(getLsTinhThanh());
        rcv_thongTinTinhThanh.setAdapter(tinhThanhAdapter);
    }

    private List<TinhThanh> getLsTinhThanh() {
        List<TinhThanh> ls   = new ArrayList<>();
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));

        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));

        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));
        ls.add(new TinhThanh("Hà Nội","129.123","1.221","123.02"));

        return ls;
    }
}