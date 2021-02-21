package com.example.dell.qls.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.dell.qls.database.DatabaseHelper;
import com.example.dell.qls.model.Theloai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDao {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public static final String TABLE_NAME = "TheLoai";
    public static final String SQL_THE_LOAI = "CREATE TABLE TheLoai(matheloai " +
            "text primary key, tentheloai text, mota text, vitri text);";
    public static final String TAG = "TheLoaiDao";

    public TheLoaiDao(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();

    }

    //insert
    public int insertTheLoai(Theloai theloai) {
        ContentValues values = new ContentValues();
        values.put("matheloai", theloai.getMaTheLoai());
        values.put("tentheloai", theloai.getTenTheLoai());
        values.put("mota", theloai.getMoTa());
        values.put("vitri", theloai.getViTri());

        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    //getall
    public List<Theloai> getAllTheLoai() {
        List<Theloai> dsTheLoai = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Theloai ee = new Theloai();
            ee.setMaTheLoai(c.getString(0));
            ee.setTenTheLoai(c.getString(1));
            ee.setMoTa(c.getString(2));
            ee.setViTri(c.getString(3));
            dsTheLoai.add(ee);
            Log.d("//======", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsTheLoai;
    }

    //update


//    public int updateTheLoai(Theloai theloai) {
//        ContentValues values = new ContentValues();
//        values.put("matheloai", theloai.getMaTheLoai());
//        values.put("tentheloai", theloai.getTenTheLoai());
//        values.put("mota", theloai.getMoTa());
//        values.put("vitri", theloai.getViTri());
//        int result = db.update(TABLE_NAME, values, "matheloai=?", new
//                String[]{theloai.getMaTheLoai()});
//        if (result == 0) {
//            return -1;
//        }
//        return 1;
//    }





    //delete

    public  int deleteTheLoaiByID(String matheloai){
        int result = db.delete(TABLE_NAME, "matheloai=?", new
                String[]{matheloai});
        if (result==0)
            return  -1;
        return 1;
    }


    public int updateTheLoai(String matheloai, String tentheloai, String mota, String vitri) {
        ContentValues values = new ContentValues();
        values.put("matheloai", matheloai);
        values.put("tentheloai", tentheloai);
        values.put("mota", mota);
        values.put("vitri", vitri);
        int result = db.update(TABLE_NAME, values, "matheloai=?", new
                String[]{matheloai});
        if (result == 0) {
            return -1;
        }
        return 1;
    }
    public  Theloai getTheLoaiByID(String matheloai){

        return null;
    }
}
