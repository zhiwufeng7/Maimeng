package com.qft3.maimeng.comicModule.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qft3.maimeng.R;
import com.qft3.maimeng.bean.BaseBean;
import com.qft3.maimeng.bean.ComicRecAdBean0;
import com.qft3.maimeng.bean.ComicRecAdBean3;
import com.qft3.maimeng.bean.ComicRecAdBean4;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/8.
 */
public class ComicRecAdFragment extends Fragment {

    @BindView(R.id.comic_rec_ad_images_iv)
    ImageView comicRecAdImagesIv;
    @BindView(R.id.comic_rec_ad_title_tv)
    TextView comicRecAdTitleTv;

    private static final String ARG_PARAM1 = "page";
    private static final String ARG_PARAM2 = "baseBean";

    private Context mContext;
    private int page;
    private BaseBean baseBean;

    public static ComicRecAdFragment newInstance(int page,BaseBean baseBean) {
        ComicRecAdFragment fragment = new ComicRecAdFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1,page);
        args.putSerializable(ARG_PARAM2,baseBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        if (getArguments() != null) {
            page = getArguments().getInt(ARG_PARAM1);
            baseBean = (BaseBean) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_comic_rec_ad, container, false);
        ButterKnife.bind(this,view);
        init();
        return view;
    }

    private void init() {
        String images = "";
        String title = "";
        switch (page){
            case 3:
                ComicRecAdBean3 recAdBean3 = (ComicRecAdBean3) baseBean;
                images = recAdBean3.getImages();
                title = recAdBean3.getTitle();
                break;
            case 4:
                ComicRecAdBean4 recAdBean4 = (ComicRecAdBean4) baseBean;
                images = recAdBean4.getImages();
                title = recAdBean4.getTitle();
                break;
            default:
                ComicRecAdBean0 recAdBean0 = (ComicRecAdBean0) baseBean;
                images = recAdBean0.getImages();
                title = recAdBean0.getTitle();
                break;
        }
        Picasso.with(mContext).load(images).into(comicRecAdImagesIv);
        comicRecAdTitleTv.setText(title);
    }
}
