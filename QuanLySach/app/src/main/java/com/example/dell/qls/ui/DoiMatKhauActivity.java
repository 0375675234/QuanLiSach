package com.example.dell.qls.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.bai2lab1.R;
import com.example.dell.qls.dao.NguoiDungDao;
import com.example.dell.qls.model.NguoiDung;

public class DoiMatKhauActivity extends AppCompatActivity {
    EditText edpass, edRepass;
    NguoiDungDao nguoiDungDao;
    Button btnchangePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass_word);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Đổi Mật Khẩu");
        edpass = (EditText) findViewById(R.id.edtnewPassword);
        edRepass = (EditText) findViewById(R.id.edtnewPassword2);
        btnchangePass = (Button) findViewById(R.id.btnsavepass);
//
//        Intent intent=getIntent();
//        Bundle bundle=intent.getBundleExtra("key");
//        final String username=bundle.getString("username1");

        btnchangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(edpass.getText().toString().matches("")){
//                    edpass.setError("Nhập password");
//                }
//                if(edRepass.getText().toString().matches("")){
//                    edRepass.setError("Nhập password mới");
//                }
//                NguoiDung user1=nguoiDungDao.getUser(username);
//                String password1=user1.getPassword();
//
//                NguoiDung user=new NguoiDung();
//                user.setPassword(edRepass.getText().toString());
//                if(password1.matches(edpass.getText().toString().trim())) {
//                    nguoiDungDao.changePassword(username, user);
//                    Intent intent3=new Intent(getApplicationContext(),NguoidungActivity.class);
//                    startActivity(intent3);
//                }else {
//                    edpass.setError("Password chưa chính xác");
//                }


                SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
                String strUserName = pref.getString("USERNAME", "");
                nguoiDungDao = new NguoiDungDao(DoiMatKhauActivity.this);
                NguoiDung user = new NguoiDung(strUserName, edpass.getText().toString(), "",
                        "");
                try {
                    if (validateForm() > 0) {
                        if (nguoiDungDao.changePasswordNguoiDung(user) > 0) {
                            Toast.makeText(getApplicationContext(), "Lưu thành công",
                                    Toast.LENGTH_SHORT).show();
                            Intent b = new Intent(DoiMatKhauActivity.this, NguoidungActivity.class);
                            startActivity(b);
                        } else {
                            Toast.makeText(getApplicationContext(), "Lưu thất bại",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (Exception ex) {
                    Log.e("Error", ex.toString());
                }
            }
        });

    }

    public int validateForm() {
        int check = 1;
        if (edpass.getText().length() == 0 || edRepass.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edpass.getText().toString();
            String rePass = edRepass.getText().toString();

            if (pass.length() < 6) {
                edpass.setError(getString(R.string.notify_length_pass));
                check = -1;
            }
            if (!pass.equals(rePass)) {
                edRepass.setError("Mật khẩu không trùng");
                check = -1;
            }
        }
        return check;
    }


    public void CancelChangePass(View view) {
        finish();
    }
}
