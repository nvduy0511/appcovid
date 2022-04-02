package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.covidapp.adapter.KhaiBaoYteViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;

public class KhaiBaoYTe extends AppCompatActivity {

    private ImageButton ibtn_back;
    private TabLayout tabLayoutKhaiBaoYTe;
    private ViewPager2 viewPagerKhaiBaoYTe;
    private KhaiBaoYteViewPagerAdapter khaiBaoYteViewPagerAdapter;
    private TextView tvTieuDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_khaibaoyte);
        anhXa();
        getDataInten();
    }

    private void anhXa() {
        //
        ibtn_back = (ImageButton) findViewById(R.id.ibtn_back);
        ibtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();;
            }
        });
        tvTieuDe = (TextView) findViewById(R.id.tvTieuDe);
        tabLayoutKhaiBaoYTe = (TabLayout) findViewById(R.id.tablayOutKhaiBaoYTe);
        viewPagerKhaiBaoYTe =  (ViewPager2)findViewById(R.id.viewPageKhaiBaoYte);

        khaiBaoYteViewPagerAdapter = new KhaiBaoYteViewPagerAdapter(this);
        viewPagerKhaiBaoYTe.setAdapter(khaiBaoYteViewPagerAdapter);
        new TabLayoutMediator(tabLayoutKhaiBaoYTe, viewPagerKhaiBaoYTe, (tab, position) -> {
            switch (position)
            {
                case 0:
                    tab.setText("Khai báo y tế");
                    break;
                case 1:
                    tab.setText("Tờ khai y tế");
                    break;
                default:
                    tab.setText("Khai báo y tế");
                    break;
            }
        }).attach();
    }

    private void getDataInten()
    {
        String strUID = getIntent().getStringExtra("uid");
    }
}