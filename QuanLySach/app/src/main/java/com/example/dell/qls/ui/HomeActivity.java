package com.example.dell.qls.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dell.bai2lab1.R;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout gioithieu;
    private LinearLayout loaisach;
    private LinearLayout sach;
    private LinearLayout hoadon;
    private LinearLayout thongke;
    private LinearLayout sachbanchay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        ;
        gioithieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NguoidungActivity.class);
                startActivity(intent);
            }
        });
        loaisach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(HomeActivity.this, TheLoaiActivity.class);
                startActivity(a);
            }
        });
        sach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(HomeActivity.this, SachActivity.class);
                startActivity(b);
            }
        });
        hoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(HomeActivity.this, HoaDonActivity.class);
                startActivity(c);
            }
        });
        thongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(HomeActivity.this, ThongKeActivity.class);
                startActivity(d);
            }
        });
        sachbanchay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(HomeActivity.this, SachBanChayActivity.class);
                startActivity(e);
            }
        });
    }


    private void initView() {
        gioithieu = (LinearLayout) findViewById(R.id.gioithieu);
        loaisach = (LinearLayout) findViewById(R.id.loaisach);
        sach = (LinearLayout) findViewById(R.id.sach);
        hoadon = (LinearLayout) findViewById(R.id.hoadon);
        thongke = (LinearLayout) findViewById(R.id.thongke);
        sachbanchay = (LinearLayout) findViewById(R.id.sachbanchay);
    }
}
