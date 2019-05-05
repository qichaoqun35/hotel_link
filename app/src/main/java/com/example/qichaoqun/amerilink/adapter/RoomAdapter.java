package com.example.qichaoqun.amerilink.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.bean.RoomInfor;

import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/29
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {

    private List<RoomInfor.RoomListBean> mList = null;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public RoomAdapter(Context context,List<RoomInfor.RoomListBean> list){
        mList = list;
        mContext = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.room_item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        //设置相关的信息
        holder.mRoomName.setText(mList.get(position).getRoom_name().split("<br />")[0]);
        holder.mRoomMoney.setText("$"+mList.get(position).getRates_and_cancellation_policies().get(0).getTotal_amount_after_tax());
        //设置取消政策和预定的监听事件
        holder.mRoomCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null){
                    Log.i("position的值是多少：：", "onClick: "+position);
                    mOnItemClickListener.onCancelClick(holder.mRoomCancle,position);
                }
            }
        });
        holder.mRoomBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onBookingClick(holder.mRoomBooking,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView mRoomName;
        private final TextView mRoomCancle;
        private final TextView mRoomFood;
        private final TextView mRoomMoney;
        private final TextView mRoomBooking;

        public MyViewHolder(View itemView) {
            super(itemView);
            mRoomName = (TextView)itemView.findViewById(R.id.room_name);
            mRoomCancle = (TextView)itemView.findViewById(R.id.room_cancel);
            mRoomFood = (TextView)itemView.findViewById(R.id.room_food);
            mRoomMoney = (TextView)itemView.findViewById(R.id.room_money);
            mRoomBooking = (TextView)itemView.findViewById(R.id.room_booking);
        }
    }

    /**
     * 点击事件的回调方法
     * @param itemClickListener 接口对象，用来实现的
     */
    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        mOnItemClickListener = itemClickListener;
    }
}
