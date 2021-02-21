package com.example.dell.qls.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.bai2lab1.R;
import com.example.dell.qls.dao.TheLoaiDao;
import com.example.dell.qls.model.Theloai;

import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {

    List<Theloai> theloaiList;
    public Activity context;
    public LayoutInflater inflater;
    TheLoaiDao theLoaiDao;

    public TheLoaiAdapter(List<Theloai> theloaiList, Activity context) {
        super();
        this.theloaiList = theloaiList;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        theLoaiDao = new TheLoaiDao(context);
    }

    @Override
    public int getCount() {
        return theloaiList.size();
    }

    @Override
    public Object getItem(int position) {
        return theloaiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder{
        ImageView img, imgdelete;
        TextView txtMaTheLoai,txtTenTheLoai;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       ViewHolder holder;
       if (convertView==null){
           holder= new ViewHolder();
           convertView=inflater.inflate(R.layout.customtheloai,null);
           holder.img = (ImageView) convertView.findViewById(R.id.imgavatartheloai);
           holder.txtMaTheLoai = (TextView) convertView.findViewById(R.id.tvmatheloai);
           holder.txtTenTheLoai = (TextView) convertView.findViewById(R.id.tvtentheloai);
           holder.imgdelete = (ImageView) convertView.findViewById(R.id.imgdeletetheloai);
       holder.imgdelete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               theLoaiDao.deleteTheLoaiByID(theloaiList.get(position).getMaTheLoai());
               theloaiList.remove(position);
               notifyDataSetChanged();
           }
       });
       convertView.setTag(holder);
       }else
           holder=(ViewHolder)convertView.getTag();
           Theloai entry =(Theloai)theloaiList.get(position);
           holder.img.setImageResource(R.drawable.cateicon);
           holder.txtMaTheLoai.setText(entry.getMaTheLoai());
           holder.txtTenTheLoai.setText(entry.getTenTheLoai());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<Theloai> items){
        this.theloaiList=items;
        notifyDataSetChanged();
    }
}
