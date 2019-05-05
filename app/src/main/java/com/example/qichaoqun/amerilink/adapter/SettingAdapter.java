package com.example.qichaoqun.amerilink.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qichaoqun.amerilink.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/22
 */
public class SettingAdapter extends BaseAdapter {
    private Context mContext;
    private final LayoutInflater mLayoutInflater;
    private List<String> mList = null;

    public SettingAdapter(Context context,List<String> list){
        mContext = context;
        mList = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    private int[] listName = new int[]{R.string.language,R.string.money,R.string.danwei};
    private int[] images = new int[] { R.drawable.language, R.drawable.money,R.drawable.change };

    @Override
    public int getCount() {
        return listName.length;
    }

    @Override
    public Object getItem(int position) {
        return listName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(R.layout.list_item,null);

        ImageView imageView = convertView.findViewById(R.id.count_image);
        imageView.setImageResource(images[position]);

        TextView textView = convertView.findViewById(R.id.acount_text);
        textView.setText(listName[position]);

        TextView textInfor = convertView.findViewById(R.id.acount_infor);
        textInfor.setText(mList.get(position));
        return convertView;
    }
}
