package com.example.qichaoqun.amerilink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qichaoqun.amerilink.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/23
 */
public class GeneralAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList = null;
    private final LayoutInflater mLayoutInflater;

    public GeneralAdapter(Context context, List<String> list){
        mContext = context;
        mList = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(R.layout.language_item,null);
        TextView textView = convertView.findViewById(R.id.language_item_text);
        textView.setText(mList.get(position));
        return convertView;
    }
}
