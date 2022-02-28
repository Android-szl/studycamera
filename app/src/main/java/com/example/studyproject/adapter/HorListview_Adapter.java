package com.example.studyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studyproject.Bean.SmallPic;
import com.example.studyproject.R;
import com.example.studyproject.tools.Click;

import java.util.ArrayList;

public class HorListview_Adapter extends BaseAdapter {
    private ArrayList<SmallPic> smallPics;
    private LayoutInflater inflater;
    private Context context;
    private Click click;
    public HorListview_Adapter(ArrayList<SmallPic> smallPics, Context context)
    {
        inflater=LayoutInflater.from(context);
        this.context=context;
        this.smallPics=smallPics;
    }
    public void setClick(Click click)
    {
        this.click=click;
    }
    @Override
    public int getCount() {
        return smallPics.size();
    }

    @Override
    public Object getItem(int position) {
        return smallPics.get(position);
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
            convertView=inflater.inflate(R.layout.item_hor_choose_pic,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=convertView.findViewById(R.id.image_view);
            viewHolder.tv=convertView.findViewById(R.id.text_view);
            viewHolder.linear=convertView.findViewById(R.id.linear);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(smallPics.get(position).getUrl());
        viewHolder.tv.setText(smallPics.get(position).getName());
        viewHolder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.clicks(smallPics.get(position));
            }
        });
        return convertView;
    }
    public class ViewHolder
    {
        ImageView imageView;
        TextView tv;
        LinearLayout linear;
    }
}
