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
public class ComicRecCon2ConRVAdapter extends RecyclerView.Adapter<ComicRecCon2ConHolder> {

    private Context mContext;
    private List<BaseBean> cartoonSetList = new ArrayList<BaseBean>();

    public ComicRecCon2ConRVAdapter(Context context, List<BaseBean> cartoonSetList) {
        mContext = context;
        this.cartoonSetList = cartoonSetList;
    }

    @Override
    public ComicRecCon2ConHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con2_con, parent, false);
        ComicRecCon2ConHolder holder = new ComicRecCon2ConHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ComicRecCon2ConHolder holder, int position) {
        ComicRecCartoonSetBean cartoonSetBean = (ComicRecCartoonSetBean) cartoonSetList.get(position);

        Picasso.with(mContext).load(cartoonSetBean.getImages()).into(holder.conImagesIv);
        holder.conNameTv.setText(cartoonSetBean.getName());
        holder.conUpdateInfoTv.setText(cartoonSetBean.getUpdateInfo());
        holder.conAuthorTv.setText(cartoonSetBean.getAuthor());
        holder.conCategoryLabelTv.setText(cartoonSetBean.getCategoryLabel());
        holder.conIntroductionTv.setText(cartoonSetBean.getIntroduction());

        if (position == 0) {
            holder.conIntroductionTv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return cartoonSetList == null ? 0 : cartoonSetList.size();
    }
}

class ComicRecCon2ConHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.comic_rec_con2_con_images)
    public ImageView conImagesIv;
    @BindView(R.id.comic_rec_con2_con_name)
    public TextView conNameTv;
    @BindView(R.id.comic_rec_con2_con_updateInfo)
    public TextView conUpdateInfoTv;
    @BindView(R.id.comic_rec_con2_con_author)
    public TextView conAuthorTv;
    @BindView(R.id.comic_rec_con2_con_categoryLabel)
    public TextView conCategoryLabelTv;
    @BindView(R.id.comic_rec_con2_con_introduction)
    public TextView conIntroductionTv;

    public ComicRecCon2ConHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}