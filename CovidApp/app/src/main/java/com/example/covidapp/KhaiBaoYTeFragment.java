package com.example.covidapp;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidapp.api.ConNguoiService;
import com.example.covidapp.api.PhieuKhaiBaoYTeService;
import com.example.covidapp.model.entity.ConNguoi;
import com.example.covidapp.model.entity.PhieuKhaiBaoYTe;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.ramotion.foldingcell.FoldingCell;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KhaiBaoYTeFragment extends Fragment {

    private static final String TAG = KhaiBaoYTe.class.getName().toString();
    private View mView;
    private AppCompatButton btn;
    private FoldingCell fc;
    private Button btnExtend;
    private Button btnColab;
    private TextView tvHoTenColab;
    private TextView tvHotenExtend;

    private CheckBox cbKhaiBaoHoColab;
    private CheckBox cbKhaiBaoHoExtend;
    private RadioButton rdQuestion1;
    private RadioButton rdQuestion2;
    private RadioButton rdQuestion3_1;
    private RadioButton rdQuestion3_2;
    private RadioButton rdQuestion3_3;
    private RadioButton rdGioiTinh;

    private TextInputEditText tilHoTen;
    private TextInputLayout tlNgayThangNamSinh;
    private TextInputLayout tlCCCD;
    private TextInputLayout tlDiaChi;
    private TextInputLayout tlSDT;

    private AppCompatButton btnSubmit;


    public KhaiBaoYTeFragment() {
    }

    public static KhaiBaoYTeFragment newInstance(String param1, String param2) {
        KhaiBaoYTeFragment fragment = new KhaiBaoYTeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_khai_bao_y_te, container, false);
        anhXa();
        return mView;
    }

    private void anhXa()
    {
        fc= (FoldingCell) mView.findViewById(R.id.folding_cell);
        btnExtend = (Button) mView.findViewById(R.id.btnExtend);
        btnColab = (Button) mView.findViewById(R.id.btnColab);

        cbKhaiBaoHoExtend = (CheckBox) mView.findViewById(R.id.cbExtend);
        cbKhaiBaoHoColab = (CheckBox) mView.findViewById(R.id.cbColab);

        rdQuestion1 = (RadioButton) mView.findViewById(R.id.rd_quest1yes);
        rdQuestion2 = (RadioButton) mView.findViewById(R.id.rd_quest2yes);
        rdQuestion3_1 = (RadioButton) mView.findViewById(R.id.rd_quest3_1yes);
        rdQuestion3_2 = (RadioButton) mView.findViewById(R.id.rd_quest3_2yes);
        rdQuestion3_3 = (RadioButton) mView.findViewById(R.id.rd_quest3_3yes);
        rdGioiTinh = (RadioButton) mView.findViewById(R.id.radioButtonNam);

        tilHoTen = (TextInputEditText) mView.findViewById(R.id.txti_hoTen);
        tlNgayThangNamSinh = (TextInputLayout) mView.findViewById(R.id.l_NamSinh);
        tlCCCD = (TextInputLayout) mView.findViewById(R.id.l_CCCD);
        tlDiaChi = (TextInputLayout) mView.findViewById(R.id.lDiaChi);
        tlSDT = (TextInputLayout) mView.findViewById(R.id.l_SDT);

        tvHoTenColab = (TextView) mView.findViewById(R.id.tv_hoTenColab);
        tvHotenExtend = (TextView) mView.findViewById(R.id.tv_hoTenExtend);

        btnSubmit = (AppCompatButton) mView.findViewById(R.id.btn_GuiPhieuKhaiBao);

        tilHoTen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvHoTenColab.setText(tilHoTen.getText().toString());
                tvHotenExtend.setText(tilHoTen.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        cbKhaiBaoHoColab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbKhaiBaoHoExtend.setChecked(cbKhaiBaoHoColab.isChecked());
            }
        });


        cbKhaiBaoHoExtend.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbKhaiBaoHoColab.setChecked(cbKhaiBaoHoExtend.isChecked());
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitDataToSever();
            }
        });

        btnExtend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.toggle(false);
            }
        });
        btnColab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.toggle(false);
            }
        });
    }

    private void submitDataToSever() {

        ConNguoi cn = new ConNguoi();
        if(cbKhaiBaoHoExtend.isChecked() == true)
        {

            cn.setHoTen(tilHoTen.getText().toString().trim());
            cn.setCmnd(tlCCCD.getEditText().getText().toString().trim());
            cn.setDiaChi(tlDiaChi.getEditText().getText().toString().trim());
            cn.setNgaySinh(tlNgayThangNamSinh.getEditText().getText().toString().trim());
            cn.setSdt(tlSDT.getEditText().getText().toString().trim());
            cn.setGioiTinh(rdGioiTinh.isChecked() == true ? "Nam":"Nữ");


            ConNguoiService.conNguoiService.addConNguoi(cn).enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if(response.body() == true)
                        Log.e(TAG,"Them thanh cong!");
                    else
                        Log.e(TAG,"Da ton tai con nguoi khong can them !");
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    Log.e(TAG,t.toString());
                }
            });
        }
        // thêm phiếu khai báo y tế
       themPhieuKhaiBaoYTe(cn);
    }

    private void themPhieuKhaiBaoYTe(ConNguoi conNguoi) {
        PhieuKhaiBaoYTe phieuKhaiBaoYTe = new PhieuKhaiBaoYTe();
        phieuKhaiBaoYTe.setCauHoi1(rdQuestion1.isChecked());
        phieuKhaiBaoYTe.setCauHoi2(rdQuestion2.isChecked());
        phieuKhaiBaoYTe.setCauHoi3_1(rdQuestion3_1.isChecked());
        phieuKhaiBaoYTe.setCauHoi3_2(rdQuestion3_2.isChecked());
        phieuKhaiBaoYTe.setCauHoi3_3(rdQuestion3_3.isChecked());
        phieuKhaiBaoYTe.setCmnd_ConNguoi(conNguoi);

        PhieuKhaiBaoYTeService.phieuKhaiBaoYTeService.addPhieuKhaiBaoYTe(phieuKhaiBaoYTe).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.body() == true)
                    Toast.makeText(getContext(),"Gửi thành công phiếu khai báo",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(),"Gửi thất bại",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(getContext(),"Lỗi khi gọi API!",Toast.LENGTH_SHORT).show();
            }
        });
    }

}