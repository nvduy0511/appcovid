package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;


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
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        Objects.requireNonNull(getSupportActionBar()).hide();
        anhXa();
    }

    private void anhXa(){
        String[] dataTest = {"Phan Vũ Lợi", "Nam", "10/06/2001", "0924875780", "123456789112", "TP. Hồ Chí Minh", "Bình Chánh", "Vĩnh Lộc A"};
        ibtn_back = findViewById(R.id.ibtn_back);
        ibtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Back");
                finish();
            }
        });

        edtHoTen = findViewById(R.id.edt_hoten);
        edtHoTen.setText(dataTest[0]);

        rdbGioiTinh = findViewById(R.id.rdg_gioitinh);
        if(rdbGioiTinh != null){
            switch (dataTest[1]){
                case "Nam":
                    rdbNam = findViewById(R.id.rbtn_nam);
                    rdbNam.setChecked(true);
                    break;
                case "Nữ":
                    rdbNu = findViewById(R.id.rbtn_nu);
                    rdbNu.setChecked(true);
                    break;
            }
        }

        edtNgaySinh = findViewById(R.id.edt_ngaysinh);
        edtNgaySinh.setText(dataTest[2]);
        edtNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                System.out.println("Chọn ngay sinh");
                chonNgay();

            }
        });

        edtSDT = findViewById(R.id.edt_sodienthoai);
        edtSDT.setText(dataTest[3]);

        edtCCCD = findViewById(R.id.edt_cancuoc);
        edtCCCD.setText(dataTest[4]);

        edtThanhPho = findViewById(R.id.edt_thanhpho);
        edtThanhPho.setText(dataTest[5]);

        edtQuanHuyen = findViewById(R.id.edt_quan_huyen);
        edtQuanHuyen.setText(dataTest[6]);

        edtPhuongXa = findViewById(R.id.edt_phuong_xa);
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