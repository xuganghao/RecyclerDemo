package com.example.xgh.recyclerdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xgh on 2018/9/22.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>implements View.OnClickListener,View.OnLongClickListener{
    private List<String> mList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public HomeAdapter(Context mContext,List<String>mList){
        this.mContext = mContext;
        this.mList = mList;
    }
    public interface OnItemClickListener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view,int position);

    }
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
    {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(
                mContext).inflate(R.layout.item_recycler, parent,
                false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return holder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {
        holder.itemView.setTag(position);
        holder.tv.setText(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }

    }

    @Override
    public boolean onLongClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemLongClick(view,(int)view.getTag());
        }
        return true;

    }







    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;
        public MyViewHolder(View view)
        {
            super(view);
            tv = view.findViewById(R.id.tv_item);
        }
    }
}
