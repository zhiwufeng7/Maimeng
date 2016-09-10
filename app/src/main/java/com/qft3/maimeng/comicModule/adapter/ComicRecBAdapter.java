package com.qft3.maimeng.comicModule.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qft3.maimeng.R;
import com.qft3.maimeng.bean.BaseBean;
import com.qft3.maimeng.bean.ComicRecBean0;
import com.qft3.maimeng.bean.ComicRecBean3;
import com.qft3.maimeng.bean.ComicRecBean6;
import com.qft3.maimeng.comicModule.ui.ComicRecCon1ConFragment;
import com.qft3.maimeng.test.OtherFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/8.
 */
public class ComicRecBAdapter extends BaseAdapter {

    private Context mContext;
    private FragmentManager manager;
    private List<BaseBean> results = new ArrayList<BaseBean>();

    public ComicRecBAdapter(Context context, FragmentManager manager, List<BaseBean> results) {
        mContext = context;
        this.manager = manager;
        this.results = results;
    }

    @Override
    public int getCount() {
        return results == null ? 0 : results.size();
    }

    @Override
    public Object getItem(int position) {
        return results == null ? 0 : results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        switch (position) {
            case 0:
            case 2:
            case 4:
            case 5:
            case 7:
                view = initComicRec0(view, parent, position);
                break;
            case 1:
                view = initComicRec1(view, parent, position);
                break;
            case 3:
                view = initComicRec3(view, parent);
                break;
            case 6:
                view = initComicRec6(view, parent);
                break;
        }
        return view;
    }

    private View initComicRec0(View view, ViewGroup parent, int position) {
//        if (view == null) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con0, parent, false);
//            view.setTag(position);
//        }else if((int)view.getTag() != position){
//            view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con0, parent, false);
//            view.setTag(position);
//        }
        ComicRecBean0 recBean = (ComicRecBean0) results.get(position);
        ComicRecCon0Holder recCon0Holder = new ComicRecCon0Holder(view, recBean, position);
        return view;
    }

    class ComicRecCon0Holder {

        @BindView(R.id.comic_rec_con0_icon_iv)
        public ImageView con0IconIv;
        @BindView(R.id.comic_rec_con0_title_tv)
        public TextView con0titleTv;
        @BindView(R.id.comic_rec_con0_desc_tv)
        public TextView con0DescTv;
        @BindView(R.id.comic_rec_con0_more_iv)
        public ImageView con0MoreIv;
        @BindView(R.id.comic_rec_con0_content_rv)
        public RecyclerView con0ContentRv;
        @BindView(R.id.comic_rec_con0_collect_iv)
        public ImageView con0CollectIv;

        public ComicRecCon0Holder(View view, ComicRecBean0 recBean, int position) {
            ButterKnife.bind(this, view);
            this.init(recBean, position);
        }

        private void init(ComicRecBean0 recBean, int position) {
            String icon = recBean.getIcon();
            String title = recBean.getTitle();
            String desc = recBean.getDesc();

            Picasso.with(mContext).load(icon).into(con0IconIv);
            con0titleTv.setText(title);
            con0DescTv.setText(desc);

            switch (position) {
                case 0:
                    break;
                case 2:
                    this.initPosition2(recBean);
                    break;
                case 4:
                    this.initPosition4(recBean);
                    break;
            }
        }

        private void initPosition2(ComicRecBean0 recBean) {
            List<BaseBean> cartoonSetList = recBean.getCartoonSetList();
            ComicRecCon2ConRVAdapter con2ConRVAdapter = new ComicRecCon2ConRVAdapter(mContext,cartoonSetList);
            con0ContentRv.setAdapter(con2ConRVAdapter);
            con0ContentRv.setLayoutManager(new LinearLayoutManager(mContext));
        }

        private void initPosition4(ComicRecBean0 recBean) {
            List<BaseBean> cartoonSetList = recBean.getCartoonSetList();
            ComicRecCon4ConRVAdapter con4ConRVAdapter = new ComicRecCon4ConRVAdapter(mContext,cartoonSetList);
            con0ContentRv.setAdapter(con4ConRVAdapter);
            con0ContentRv.setLayoutManager(new LinearLayoutManager(mContext));
            con0CollectIv.setVisibility(View.VISIBLE);
        }
    }

    private View initComicRec1(View view, ViewGroup parent, int position) {
//        if (view == null) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con1, parent, false);
//            viewMap.put(position,view);
//            view.setTag(position);
//        }else if((int)view.getTag() != position){
//            view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con1, parent, false);
//            view.setTag(position);
//        }
        ComicRecBean0 recBean = (ComicRecBean0) results.get(position);
        ComicRecCon1Holder recCon1Holder = new ComicRecCon1Holder(view, recBean);
        return view;
    }

    class ComicRecCon1Holder implements ViewPager.OnPageChangeListener {

        @BindView(R.id.comic_rec_con1_icon_iv)
        public ImageView con1IconIv;
        @BindView(R.id.comic_rec_con1_title_tv)
        public TextView con1titleTv;
        @BindView(R.id.comic_rec_con1_desc_tv)
        public TextView con1DescTv;
        @BindView(R.id.comic_rec_con1_more_iv)
        public ImageView con1MoreIv;

        @BindView(R.id.comic_rec_con1_content_vp)
        public ViewPager con1ContentVp;

        //        @BindView(R.id.comic_rec_con1_page_rg)
//        RadioGroup con1PageRg;
        @BindView(R.id.comic_rec_con1_page0_rb)
        RadioButton con1Page0Rb;
        @BindView(R.id.comic_rec_con1_page1_rb)
        RadioButton con1Page1Rb;
        @BindView(R.id.comic_rec_con1_page2_rb)
        RadioButton con1Page2Rb;
        @BindView(R.id.comic_rec_con1_page3_rb)
        RadioButton con1Page3Rb;
        @BindView(R.id.comic_rec_con1_page4_rb)
        RadioButton con1Page4Rb;

        public ComicRecCon1Holder(View view, ComicRecBean0 recBean) {
            ButterKnife.bind(this, view);
            this.init(recBean);
        }

        private void init(ComicRecBean0 recBean) {
            String icon = recBean.getIcon();
            String title = recBean.getTitle();
            String desc = recBean.getDesc();

            Picasso.with(mContext).load(icon).into(con1IconIv);
            con1titleTv.setText(title);
            con1DescTv.setText(desc);

            List<BaseBean> cartoonSetList = recBean.getCartoonSetList();
            List<Fragment> fragments = this.initFragments(cartoonSetList);
            ComicFPAdapter adapter = new ComicFPAdapter(manager, fragments);
            con1ContentVp.setAdapter(adapter);
            con1ContentVp.addOnPageChangeListener(this);
        }

        private List<Fragment> initFragments(List<BaseBean> cartoonSetList) {
            List<Fragment> fragments = new ArrayList<Fragment>();
            for (int page = 0; page < 5; page++) {
                List<BaseBean> dataList = new ArrayList<BaseBean>();
                for (int i = page * 6; i < (page + 1) * 6; i++) {
                    dataList.add(cartoonSetList.get(i));
                }
                fragments.add(ComicRecCon1ConFragment.newInstance(dataList));
            }
            return fragments;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    con1Page0Rb.setChecked(true);
                    break;
                case 1:
                    con1Page1Rb.setChecked(true);
                    break;
                case 2:
                    con1Page2Rb.setChecked(true);
                    break;
                case 3:
                    con1Page3Rb.setChecked(true);
                    break;
                case 4:
                    con1Page4Rb.setChecked(true);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private View initComicRec3(View view, ViewGroup parent) {
//        if (view == null) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con3, parent, false);
//            view.setTag(3);
//        }else if((int)view.getTag() != 3){
//            view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con3, parent, false);
//            view.setTag(3);
//        }
        ComicRecBean3 recBean = (ComicRecBean3) results.get(3);
        ComicRecCon3Holder recCon3Holder = new ComicRecCon3Holder(view, recBean);
        return view;
    }

    class ComicRecCon3Holder {

        @BindView(R.id.comic_rec_con3_images)
        public ImageView con3Images;
        @BindView(R.id.comic_rec_con3_images2)
        public ImageView con3Images2;

        public ComicRecCon3Holder(View view, ComicRecBean3 recBean) {
            ButterKnife.bind(this, view);
            this.init(recBean);
        }

        private void init(ComicRecBean3 recBean) {
            String images = recBean.getImages();
            String images2 = recBean.getImages2();

            Picasso.with(mContext).load(images).into(con3Images);
            Picasso.with(mContext).load(images2).into(con3Images2);
        }
    }

    private View initComicRec6(View view, ViewGroup parent) {
//        if (view == null) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con6, parent, false);
//            view.setTag(6);
//        }else if((int)view.getTag() != 6){
//            view = LayoutInflater.from(mContext).inflate(R.layout.item_comic_rec_con6, parent, false);
//            view.setTag(6);
//        }
        ComicRecBean6 recBean = (ComicRecBean6) results.get(6);
        ComicRecCon6Holder recCon6Holder = new ComicRecCon6Holder(view, recBean);
        return view;
    }

    class ComicRecCon6Holder {

        @BindView(R.id.comic_rec_con6_images)
        public ImageView con6Images;
        @BindView(R.id.comic_rec_con6_desc)
        public TextView con6Desc;

        public ComicRecCon6Holder(View view, ComicRecBean6 recBean) {
            ButterKnife.bind(this, view);
            this.init(recBean);
        }

        private void init(ComicRecBean6 recBean) {
            String images = recBean.getImages();
            String desc = recBean.getDesc();

            Picasso.with(mContext).load(images).into(con6Images);
            con6Desc.setText(desc);
        }
    }

}
