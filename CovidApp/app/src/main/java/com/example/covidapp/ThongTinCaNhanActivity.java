package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.covidapp.api.ConNguoiService;
import com.example.covidapp.api.NguoiDungService;
import com.example.covidapp.model.entity.ConNguoi;
import com.example.covidapp.model.entity.NguoiDung;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ThongTinCaNhanActivity extends AppCompatActivity {

    private ImageButton ibtn_back;
    private EditText edtHoTen;
    private EditText edtNgaySinh;
    private EditText edtSDT;
    private RadioGroup rdbGioiTinh;
    private RadioButton rdbNam;
    private RadioButton rdbNu;
    private EditText edtCCCD;
    private EditText edtThanhPho;
    private EditText edtQuanHuyen;
    private EditText edtPhuongXa;
    private EditText edtThonXomSoNha;
    private AppCompatButton btnLuuThongTin;
    private String uID;


    private boolean isDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        Objects.requireNonNull(getSupportActionBar()).hide();
        anhXa();
    }


    private void anhXa(){
        Intent intent = getIntent();
        isDangKy = intent.getBooleanExtra("isDangKy",false);
        uID = intent.getStringExtra("uid");
        ibtn_back = findViewById(R.id.ibtn_back);
        edtSDT = findViewById(R.id.edt_sodienthoai);
        edtCCCD = findViewById(R.id.edt_cancuoc);
        edtThanhPho = findViewById(R.id.edt_thanhpho);
        edtQuanHuyen = findViewById(R.id.edt_quan_huyen);
        edtPhuongXa = findViewById(R.id.edt_phuong_xa);
        edtHoTen = findViewById(R.id.edt_hoten);
        rdbGioiTinh = findViewById(R.id.rdg_gioitinh);
        edtNgaySinh = findViewById(R.id.edt_ngaysinh);
        edtThonXomSoNha = findViewById(R.id.edt_thon_xom_sonha);
        btnLuuThongTin = findViewById(R.id.btnLuuThongTin);
        rdbNu = findViewById(R.id.rbtn_nu);
        rdbNam = findViewById(R.id.rbtn_nam);
        ibtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Back");
                finish();
            }
        });
        edtNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Chọn ngay sinh");
                chonNgay();
            }
        });
        btnLuuThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDangKy)
                {
                    dangKyConNguoi();
                }
                else
                {
                    suaThongIinConNguoi();
                }
            }
        });

        if(isDangKy == false)
            setThongTin();


    }

    private void suaThongIinConNguoi() {

    }

    private void dangKyConNguoi() {

        ConNguoi conNguoi = new ConNguoi();
        conNguoi.setCmnd(edtCCCD.getText().toString().trim());
        conNguoi.setGioiTinh(rdbNam.isChecked() == true ? "Nam":"Nữ");
        conNguoi.setSdt(edtSDT.getText().toString().trim());
        conNguoi.setNgaySinh(edtNgaySinh.getText().toString());
        conNguoi.setHoTen(edtHoTen.getText().toString().trim());
        String dc = edtThonXomSoNha.getText().toString().trim()+", "+edtPhuongXa.getText().toString().trim()+", "
                +edtQuanHuyen.getText().toString().trim()+", "+edtThanhPho.getText().toString().trim();
        conNguoi.setDiaChi(dc);
        ConNguoiService.conNguoiService.addConNguoi(conNguoi).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.body() == false)
                    Log.e("ThemConNguoi","Đã tồn tại con người");
                themMoiNguoiDung(conNguoi);
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.e("ThemConNguoi","Lỗi call API");
            }
        });
    }

    private void themMoiNguoiDung(ConNguoi conNguoi) {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setuID(uID);
        nguoiDung.setCmnd_ConNguoi(conNguoi);
        NguoiDungService.nguoiDungService.addNguoiDung(nguoiDung).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.body() == true)
                {
                    Toast.makeText(ThongTinCaNhanActivity.this,"Thêm mới thông tin thành công!",Toast.LENGTH_SHORT).show();
                    goToHomeActivity(nguoiDung);
                }
                else
                    Toast.makeText(ThongTinCaNhanActivity.this,"Thêm mới thông tin thất bại!",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(ThongTinCaNhanActivity.this,"Call API thất bại!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToHomeActivity(NguoiDung nguoiDung) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("uid",nguoiDung.getuID());
        intent.putExtra("cmnd",nguoiDung.getCmnd_ConNguoi().getCmnd());
        startActivity(intent);
        finishAffinity();
    }

    private void setThongTin() {
        String[] dataTest = {"Phan Vũ Lợi", "Nam", "10/06/2001", "0924875780", "123456789112", "TP. Hồ Chí Minh", "Bình Chánh", "Vĩnh Lộc A"};
        if(rdbGioiTinh != null){
            switch (dataTest[1]){
                case "Nam":
                    rdbNam.setChecked(true);
                    break;
                case "Nữ":
                    rdbNu.setChecked(true);
                    break;
            }
        }
        edtHoTen.setText(dataTest[0]);
        edtNgaySinh.setText(dataTest[2]);
        edtSDT.setText(dataTest[3]);
        edtCCCD.setText(dataTest[4]);
        edtThanhPho.setText(dataTest[5]);
        edtQuanHuyen.setText(dataTest[6]);
        edtPhuongXa.setText(dataTest[7]);
    }

    private void chonNgay(){
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int nam, int thang, int ngay) {
                calendar.set(nam, thang, ngay);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtNgaySinh.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
}