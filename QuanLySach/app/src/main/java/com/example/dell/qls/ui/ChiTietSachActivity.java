package com.example.dell.qls.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dell.bai2lab1.R;
import com.example.dell.qls.dao.SachDao;
import com.example.dell.qls.dao.TheLoaiDao;

public class ChiTietSachActivity extends AppCompatActivity {
    SachDao sachDAO;
    TheLoaiDao theLoaiDAO;
    Spinner spnTheLoai;
    EditText edMaSach, edTenSach, edNXB, edTacGia, edGiaBia, edSoLuong;
    String maTheLoai = "";
    private EditText edMaSachThemSach;
    private EditText edTenSachThemSach;
    private EditText edTacGiaThemSach;
    private EditText edNXBThemSach;
    private EditText edGiaThemSach;
    private EditText edSoluongThemSach;
    private Button btnThemThemSach;
    private Button btnHuyThemSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sach);

        sachDAO = new SachDao(ChiTietSachActivity.this);
        // load data

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
            edMaSach.setText(b.getString("MASACH"));
            String maTheLoai = b.getString("MATHELOAI");
            edTenSach.setText(b.getString("TENSACH"));
            edNXB.setText(b.getString("NXB"));
            edTacGia.setText(b.getString("TACGIA"));
            edGiaBia.setText(b.getString("GIABIA"));
            edSoLuong.setText(b.getString("SOLUONG"));


        initView();
    }

    public void UpdateSach(View view) {
        if (sachDAO.updateSach(edMaSach.getText().toString(),maTheLoai,
                edTenSach.getText().toString(), edNXB.getText().toString(),
                edTacGia.getText().toString(),String.valueOf(edGiaBia.getText().toString()),
                String.valueOf(edSoLuong.getText().toString())) > 0) {
            Toast.makeText(getApplicationContext(), "Lưu Thành Công", Toast.LENGTH_SHORT).show();

            Intent a = new Intent(ChiTietSachActivity.this, SachActivity.class);
            startActivity(a);
        }
    }

    public void huyupdatesach(View view) {
        finish();
    }

    private void initView() {
        edMaSachThemSach = (EditText) findViewById(R.id.edMaSach_ThemSach);
        edTenSachThemSach = (EditText) findViewById(R.id.edTenSach_ThemSach);
        edTacGiaThemSach = (EditText) findViewById(R.id.edTacGia_ThemSach);
        edNXBThemSach = (EditText) findViewById(R.id.edNXB_ThemSach);
        edGiaThemSach = (EditText) findViewById(R.id.edGia_ThemSach);
        edSoluongThemSach = (EditText) findViewById(R.id.edSoluong_ThemSach);
        btnThemThemSach = (Button) findViewById(R.id.btnThem_ThemSach);
        btnHuyThemSach = (Button) findViewById(R.id.btnHuy_ThemSach);
    }
}
