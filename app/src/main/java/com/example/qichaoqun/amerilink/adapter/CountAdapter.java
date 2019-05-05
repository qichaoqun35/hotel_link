package com.example.qichaoqun.amerilink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qichaoqun.amerilink.R;

/**
 * @author qichaoqun
 * @date 2018/8/22
 */
public class CountAdapter extends BaseAdapter {

    private Context mContext;
    private final LayoutInflater mLayoutInflater;

    public CountAdapter(Context context){
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 存储listview中的文字和图片
     */
    private int[] listName = new int[]{R.string.search,R.string.login,R.string.devlope_panel};
    private int[] images = new int[]{R.drawable.first_page,
            R.drawable.singn,R.drawable.devlope_panel};

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
        return convertView;
    }
}
