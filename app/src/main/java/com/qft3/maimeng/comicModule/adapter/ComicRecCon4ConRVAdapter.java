package com.qft3.maimeng.comicModule.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
public class ComicRecCon4ConRVAdapter extends RecyclerView.Adapter<ComicRecCon4ConHolder> {

    private Context mContext;
    private List<BaseBean> cartoonSetList = new ArrayList<BaseBean>();

    public ComicRecCon4ConRVAdapter(Context context, List<BaseBean> cartoonSetList) {
        mContext = context;
        this.cartoonSetList = cartoonSetList;
    }

    @Override
    public ComicRecCon4ConHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con4_con, parent, false);
        ComicRecCon4ConHolder holder = new ComicRecCon4ConHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ComicRecCon4ConHolder holder, int position) {
        ComicRecCartoonSetBean cartoonSetBean = (ComicRecCartoonSetBean) cartoonSetList.get(position);

        Picasso.with(mContext).load(cartoonSetBean.getImages()).into(holder.conImagesIv);
        holder.conNameTv.setText(cartoonSetBean.getName());
        holder.conAuthorTv.setText(cartoonSetBean.getAuthor());
        holder.conCategoryLabelTv.setText(cartoonSetBean.getCategoryLabel());
        holder.conUpdateInfoTv.setText(cartoonSetBean.getUpdateInfo());

        Resources resources = mContext.getResources();
        int bitmapId = 0;
        if (position == 0) {
            bitmapId = R.drawable.image_most_collect_one;
        } else if (position == 1) {
            bitmapId = R.drawable.image_most_collect_two;
        } else if (position == 2) {
            bitmapId = R.drawable.image_most_collect_three;
        }
        Bitmap bitmap = BitmapFactory.decodeResource(resources, bitmapId);
        holder.conLevelIv.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return cartoonSetList == null ? 0 : cartoonSetList.size();
    }
}

class ComicRecCon4ConHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.comic_rec_con4_con_images)
    public ImageView conImagesIv;
    @BindView(R.id.comic_rec_con4_con_name)
    public TextView conNameTv;
    @BindView(R.id.comic_rec_con4_con_author)
    public TextView conAuthorTv;
    @BindView(R.id.comic_rec_con4_con_categoryLabel)
    public TextView conCategoryLabelTv;
    @BindView(R.id.comic_rec_con4_con_updateInfo)
    public TextView conUpdateInfoTv;
    @BindView(R.id.comic_rec_con4_con_level)
    public ImageView conLevelIv;

    public ComicRecCon4ConHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}