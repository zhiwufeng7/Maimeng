package com.qft3.maimeng.comicModule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qft3.maimeng.R;
import com.qft3.maimeng.bean.BaseBean;
import com.qft3.maimeng.bean.ComicRecCartoonSetBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/9.
 */
public class ComicRecCon1ConRVAdapter extends RecyclerView.Adapter<ComicRecCon1ConHolder> {

    private Context mContext;
    private List<BaseBean> dataList = new ArrayList<BaseBean>();

    public ComicRecCon1ConRVAdapter(Context context, List<BaseBean> dataList) {
        mContext = context;
        this.dataList = dataList;
    }

    @Override
    public ComicRecCon1ConHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con1_con, parent, false);
        ComicRecCon1ConHolder holder = new ComicRecCon1ConHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ComicRecCon1ConHolder holder, int position) {
        ComicRecCartoonSetBean cartoonSetBean = (ComicRecCartoonSetBean) dataList.get(position);

        Picasso.with(mContext).load(cartoonSetBean.getImages()).into(holder.conImageIv);
        holder.conUpdateInfoTv.setText(cartoonSetBean.getUpdateInfo());
        holder.conNameTv.setText(cartoonSetBean.getName());
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}

class ComicRecCon1ConHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.comic_rec_con1_con_images)
    public ImageView conImageIv;
    @BindView(R.id.comic_rec_con1_con_updateInfo)
    public TextView conUpdateInfoTv;
    @BindView(R.id.comic_rec_con1_con_name)
    public TextView conNameTv;

    public ComicRecCon1ConHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}