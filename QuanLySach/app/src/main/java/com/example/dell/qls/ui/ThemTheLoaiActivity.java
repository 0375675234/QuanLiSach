package com.example.dell.qls.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.bai2lab1.R;
import com.example.dell.qls.dao.TheLoaiDao;
import com.example.dell.qls.model.Theloai;


public class ThemTheLoaiActivity extends AppCompatActivity {

    private Button showtheloai;

    private EditText edtMaTheLoai;
    private EditText edttentheloai;
    private EditText edtmota;
    private EditText edtvitri;
    private Button btnHuyAddTheLoai;
    private Button btnAddTheLoai;
    TheLoaiDao theLoaiDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtheloai);
        initView();
        setTitle("Thêm Thể Loại");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        showtheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemTheLoaiActivity.this, TheLoaiActivity.class);
                startActivity(intent);
            }
        });
        btnAddTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTheloai();
            }
        });
        btnHuyAddTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    public void addTheloai() {
        theLoaiDao = new TheLoaiDao(ThemTheLoaiActivity.this);
        Theloai theloai = new Theloai(edtMaTheLoai.getText().toString(), edttentheloai.getText().toString(),
                edtmota.getText().toString(), edtvitri.getText().toString());
        try {
            if (validateForm()>0){
                if (theLoaiDao.insertTheLoai(theloai)>0){
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    Intent b = new Intent(ThemTheLoaiActivity.this, TheLoaiActivity.class);
                    startActivity(b);

                }else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception e){
            Log.e("Error",e.toString());

        }
    }

    public int validateForm() {
        int check = 1;
        if (edtMaTheLoai.getText().length() == 0 || edttentheloai.getText().length() == 0
                || edtvitri.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        if (edtMaTheLoai.getText().length()>5){
            edtMaTheLoai.setError("Mã không quá 5 kí tự");
        }


        return check;
    }

    private void initView() {


        edtMaTheLoai = (EditText) findViewById(R.id.edtMaTheLoai);
        edttentheloai = (EditText) findViewById(R.id.edttentheloai);
        edtmota = (EditText) findViewById(R.id.edtmota);
        edtvitri = (EditText) findViewById(R.id.edtvitri);
        btnHuyAddTheLoai = (Button) findViewById(R.id.btnHuyAddTheLoai);
        btnAddTheLoai = (Button) findViewById(R.id.btnAddTheLoai);
        showtheloai = (Button) findViewById(R.id.showtheloai);

    }
}
