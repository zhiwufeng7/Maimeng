package com.qft3.maimeng.picModule.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qft3.maimeng.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by qj on 2016/9/10.
 */
class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.item_picture_fragment_main_iv)
    ImageView imageView;
    @BindView(R.id.item_picture_fragment_autor_iv)
    CircleImageView circleImageView;
    @BindView(R.id.item_picture_fragment_autor_tv)
    TextView autorTxt;
    @BindView(R.id.item_picture_fragment_comment_tv)
    TextView commentTxt;
    @BindView(R.id.item_picture_fragment_praise_tv)
    TextView praistTxt;

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}