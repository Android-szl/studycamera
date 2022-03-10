package com.example.studyproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.studyproject.Bean.FLS;
import com.example.studyproject.R;

import java.util.ArrayList;

/**
 * @auther 孙培翔
 * @description:
 * @data :2022/3/1 11:28
 */
public class category_HorListview_Adapter extends BaseAdapter {
    private ArrayList<FLS> fls;
    private LayoutInflater inflater;
    private Context context;
    public category_HorListview_Adapter(ArrayList<FLS> fls, Context context)
    {
        this.fls=fls;
        inflater=LayoutInflater.from(context);
        this.context=context;
    }
    @Override
    public int getCount() {
        return fls.size();
    }

    @Override
    public Object getItem(int position) {
        return fls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null)
        {
            convertView=inflater.inflate(R.layout.item_category,null);
            viewHolder=new ViewHolder();
            viewHolder.tv=convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(fls.get(position).getName());
        if (fls.get(position).isChecked())
        {
            viewHolder.tv.setBackgroundColor(Color.parseColor("#FFC0D88A"));
        }
        else
        {
            viewHolder.tv.setBackgroundColor(Color.parseColor("#00000000"));
        }
        return convertView;
    }
    public class ViewHolder
    {
        TextView tv;
    }
}
