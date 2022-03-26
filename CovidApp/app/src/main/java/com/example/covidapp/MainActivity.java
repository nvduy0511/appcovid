package com.example.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.covidapp.adapter.KhaiBaoYteViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ImageButton ibtn_back;
    private TabLayout tabLayoutKhaiBaoYTe;
    private ViewPager2 viewPagerKhaiBaoYTe;
    private KhaiBaoYteViewPagerAdapter khaiBaoYteViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        ibtn_back = (ImageButton) findViewById(R.id.ibtn_back);
//
//        ibtn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"Set Fragment",Toast.LENGTH_SHORT).show();
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.add(R.id.frameLayout, new ToKhaiYTeFragment());
//                fragmentTransaction.commit();
//            }
//        });
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
}