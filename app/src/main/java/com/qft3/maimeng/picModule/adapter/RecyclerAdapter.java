package com.qft3.maimeng.picModule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qft3.maimeng.R;
import com.qft3.maimeng.bean.PictureAllBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by qj on 2016/9/9.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private List<PictureAllBean.ResultsBean> resultsBeanList = new ArrayList<>();

    public RecyclerAdapter(Context mContext, List<PictureAllBean.ResultsBean> resultsBeanList) {
        this.mContext = mContext;
        this.resultsBeanList = resultsBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_picture_fragment_layout, parent, false);
        ViewHolder viewHolder=new ViewHolder(itemView) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(mContext).load(resultsBeanList.get(position).getSourceImages()).into(holder.imageView);
        Picasso.with(mContext).load(resultsBeanList.get(position).getUserIDInfo().getImages()).into(holder.circleImageView);
        holder.autorTxt.setText(resultsBeanList.get(position).getUserIDInfo().getName());
        holder.praistTxt.setText(resultsBeanList.get(position).getPraiseCount());
        holder.commentTxt.setText(resultsBeanList.get(position).getContentCount());
    }

    @Override
    public int getItemCount() {
        return resultsBeanList == null ? 0 : resultsBeanList.size();
    }
}


