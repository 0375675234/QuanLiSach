package com.example.dell.qls.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.bai2lab1.R;
import com.example.dell.qls.dao.SachDao;
import com.example.dell.qls.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachAdapter extends BaseAdapter implements Filterable {
    List<Sach> arrSach;
    List<Sach> arrSortSach;
    private Filter sachFilter;
    public Activity context;
    public LayoutInflater inflater;
    SachDao sachDao;

    public SachAdapter(List<Sach> arrSach, Activity context) {
        super();
        this.arrSach = arrSach;
        this.context = context;
        this.arrSortSach = arrSach;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        sachDao = new SachDao(context);
    }

    @Override
    public int getCount() {
        return arrSach.size();
    }

    @Override
    public Object getItem(int position) {
        return arrSach.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Filter getFilter() {
        if (sachFilter == null)
            sachFilter = new CustomFilder();
        return sachFilter;
    }

    public static class ViewHolder {
        ImageView img, imgDelete;
        TextView txtTenSach, txtGiaBan, txtSoLuong;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.customsach, null);
            holder.img = (ImageView) convertView.findViewById(R.id.imgavatarsach);
            holder.txtTenSach = (TextView) convertView.findViewById(R.id.tvnamesach);
            holder.txtSoLuong = (TextView) convertView.findViewById(R.id.tvsoluongsach);
            holder.txtGiaBan = (TextView) convertView.findViewById(R.id.tvBookPrice);

            holder.imgDelete = (ImageView) convertView.findViewById(R.id.imgdeletesach);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sachDao.deleteSachByID(arrSach.get(position).getMaSach());
                    arrSach.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();
        Sach entry = (Sach) arrSach.get(position);
        holder.img.setImageResource(R.drawable.bookicon);
        holder.txtTenSach.setText("Mã Sách: " + entry.getMaSach());
        holder.txtSoLuong.setText("Số Lượng: " + entry.getSoLuong());
        holder.txtGiaBan.setText("Mã Sách: " + entry.getGiaBan());


        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<Sach> items) {
        this.arrSach = items;
        notifyDataSetChanged();
    }

    public void resetData() {
        arrSach = arrSortSach;
    }

    private class CustomFilder extends Filter {


        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = arrSortSach;
                results.count = arrSortSach.size();
            } else {
                List<Sach> lsSach = new ArrayList<Sach>();
                for (Sach p : arrSach) {
                    if (p.getMaSach().toUpperCase().startsWith(constraint.toString().toUpperCase()))
                        ;
                    lsSach.add(p);
                }
                results.values = lsSach;
                results.count = lsSach.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                arrSach = (List<Sach>) results.values;
                notifyDataSetChanged();
            }
        }
    }
}
