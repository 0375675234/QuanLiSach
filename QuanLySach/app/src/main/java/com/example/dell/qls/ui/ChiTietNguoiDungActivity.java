package com.example.dell.qls.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.bai2lab1.R;
import com.example.dell.qls.dao.NguoiDungDao;

public class ChiTietNguoiDungActivity extends AppCompatActivity {

    private EditText edFullName;
    private EditText edPhone;
    NguoiDungDao nguoiDungDao;
    String username,fullname,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_nguoi_dung);
        initView();
        setTitle("Chi Tiết Người Dùng");


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        nguoiDungDao= new NguoiDungDao(ChiTietNguoiDungActivity.this);
        Intent intent = getIntent();
        Bundle b= intent.getExtras();
        fullname = b.getString("FULLNAME");
        phone=b.getString("PHONE");
        username=b.getString("USERNAME");
        edFullName.setText(fullname);
        edPhone.setText(phone);
    }

    public void UpdateUser(View view) {
        if (nguoiDungDao.updateInfoNguoiDung(username,edPhone.getText().toString(),
                edFullName.getText().toString())>0){
            Toast.makeText(getApplicationContext(), "Lưu Thành Công", Toast.LENGTH_SHORT).show();

            Intent a = new Intent(ChiTietNguoiDungActivity.this,NguoidungActivity.class);
            startActivity(a);
        }

    }

    public void Huy(View view) {
finish();
    }

    private void initView() {
        edFullName = (EditText) findViewById(R.id.edFullName);
        edPhone = (EditText) findViewById(R.id.edPhone);
    }


}
