package com.example.dell.qls.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dell.bai2lab1.R;

import com.example.dell.qls.adapter.NguoiDungAdapter;
import com.example.dell.qls.dao.NguoiDungDao;
import com.example.dell.qls.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoidungActivity extends AppCompatActivity {
    public static List<NguoiDung> dsNguoiDung = new ArrayList<>();
    ListView lvnguoidung;
    NguoiDungAdapter adapter=null;
    NguoiDungDao nguoiDungDao;

    @Override
    protected void onResume() {
        super.onResume();
        dsNguoiDung.clear();
        dsNguoiDung = nguoiDungDao.getAllNguoiDung();
        adapter.changeDataset(nguoiDungDao.getAllNguoiDung());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoidung);
        setTitle("Nguời Dùng");


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        lvnguoidung = findViewById(R.id.customlvnguoidung);
        nguoiDungDao = new NguoiDungDao(NguoidungActivity.this);
        dsNguoiDung = nguoiDungDao.getAllNguoiDung();

        adapter = new NguoiDungAdapter(dsNguoiDung, this);

        lvnguoidung.setAdapter(adapter);
        lvnguoidung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NguoidungActivity.this,ChiTietNguoiDungActivity.class);
                Bundle b = new Bundle() ;
                b.putString("USERNAME",dsNguoiDung.get(position).getUserName());
                b.putString("PHONE",dsNguoiDung.get(position).getPhone());
                b.putString("FULLNAME",dsNguoiDung.get(position).getHoTen());
                intent.putExtras(b);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionnguoidung, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.adduser:
                Intent a = new Intent(NguoidungActivity.this, ThemNguoiDungActivity.class);
                startActivity(a);
                break;
            case R.id.changepass:
                Intent b = new Intent(NguoidungActivity.this, DoiMatKhauActivity.class);
                startActivity(b);
                break;
            case R.id.dangxuat:
                SharedPreferences preferences = getSharedPreferences("USER_FILE",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                Intent c = new Intent(NguoidungActivity.this,LoginActivity.class);
                startActivity(c);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
