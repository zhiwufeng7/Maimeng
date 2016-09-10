package com.qft3.maimeng.comicModule.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;

import com.qft3.maimeng.R;
import com.qft3.maimeng.bean.BaseBean;
import com.qft3.maimeng.bean.ComicRecAdBean;
import com.qft3.maimeng.bean.ComicRecBean;
import com.qft3.maimeng.bean.ComicRecBean0;
import com.qft3.maimeng.bean.ComicRecBean3;
import com.qft3.maimeng.bean.ComicRecBean6;
import com.qft3.maimeng.comicModule.adapter.ComicFPAdapter;
import com.qft3.maimeng.comicModule.adapter.ComicRecBAdapter;
import com.qft3.maimeng.comicModule.presenter.IComicPresenter;
import com.qft3.maimeng.comicModule.presenter.impl.ComicPresenterImpl;
import com.qft3.maimeng.comicModule.view.IComicRecView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/6.
 */
public class ComicRecFragment extends Fragment implements IComicRecView {

    @BindView(R.id.comic_rec_content_lv)
    ListView recContentLv;

    private Context mContext;
    private IComicPresenter mRecPresenter;
    private FragmentManager fragmentManager;
    private FragmentManager childFragmentManager;
    private ComicRecBAdapter recBAdapter;

    public static ComicRecFragment newInstance() {
        ComicRecFragment fragment = new ComicRecFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        fragmentManager = getFragmentManager();
        childFragmentManager = getChildFragmentManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_rec, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        mRecPresenter = new ComicPresenterImpl(this);
        mRecPresenter.getComicRecAd();
    }

    @Override
    public void refreshListView(ComicRecBean recBean) {
        List<BaseBean> results = recBean.getResults();
        recBAdapter = new ComicRecBAdapter(mContext, childFragmentManager, results);
        recContentLv.setAdapter(recBAdapter);
    }

    @Override
    public void refreshComicRecAd(ComicRecAdBean recAdBean) {
        List<BaseBean> results = recAdBean.getResults();
        ComicRecAdHolder recAdHolder = new ComicRecAdHolder(mContext, results);
        mRecPresenter.getComicRecList();
    }

    class ComicRecAdHolder implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

        @BindView(R.id.comic_rec_ad_content_vp)
        ViewPager recAdContentVp;
        @BindView(R.id.comic_rec_ad_page_rg)
        RadioGroup recAdPageRg;
        @BindView(R.id.comic_rec_ad_page0_rb)
        RadioButton recAdPage0Rb;
        @BindView(R.id.comic_rec_ad_page1_rb)
        RadioButton recAdPage1Rb;
        @BindView(R.id.comic_rec_ad_page2_rb)
        RadioButton recAdPage2Rb;
        @BindView(R.id.comic_rec_ad_page3_rb)
        RadioButton recAdPage3Rb;
        @BindView(R.id.comic_rec_ad_page4_rb)
        RadioButton recAdPage4Rb;
        @BindView(R.id.comic_rec_ad_search_sv)
        SearchView recAdSearchSv;

        private List<BaseBean> results = new ArrayList<BaseBean>();

        public Timer timer;
        private int adPage = 0;

        public ComicRecAdHolder(Context mContext, List<BaseBean> results) {
            View headView = LayoutInflater.from(mContext).inflate(R.layout.head_comic_rec_ad, null);
            ButterKnife.bind(this, headView);

            this.results = results;
            initHeadView(headView);

            recContentLv.addHeaderView(headView);
            timer = new Timer();
            timer.schedule(timerTask, 0);
        }

        private Handler mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    int pageNow = msg.arg1 % 5;
                    recAdContentVp.setCurrentItem(pageNow);
                    switch (pageNow) {
                        case 0:
                            recAdPage0Rb.setChecked(true);
                            break;
                        case 1:
                            recAdPage1Rb.setChecked(true);
                            break;
                        case 2:
                            recAdPage2Rb.setChecked(true);
                            break;
                        case 3:
                            recAdPage3Rb.setChecked(true);
                            break;
                        case 4:
                            recAdPage4Rb.setChecked(true);
                            break;
                    }
                }
            }
        };

        private void initHeadView(View headView) {
            List<Fragment> fragments = initComicRecAdFragment(results);
            ComicFPAdapter adapter = new ComicFPAdapter(childFragmentManager, fragments);
            recAdContentVp.setAdapter(adapter);

            recAdContentVp.addOnPageChangeListener(this);
            recAdPageRg.setOnCheckedChangeListener(this);
        }

        private List<Fragment> initComicRecAdFragment(List<BaseBean> results) {
            List<Fragment> fragments = new ArrayList<Fragment>();
            for (int i = 0; i < 5; i++) {
                BaseBean baseBean = results.get(i);
                fragments.add(ComicRecAdFragment.newInstance(i, baseBean));
            }
            return fragments;
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int position) {
            switch (position) {
                case R.id.comic_rec_ad_page0_rb:
                    recAdContentVp.setCurrentItem(0);
                    adPage = 0;
                    break;
                case R.id.comic_rec_ad_page1_rb:
                    recAdContentVp.setCurrentItem(1);
                    adPage = 1;
                    break;
                case R.id.comic_rec_ad_page2_rb:
                    recAdContentVp.setCurrentItem(2);
                    adPage = 2;
                    break;
                case R.id.comic_rec_ad_page3_rb:
                    recAdContentVp.setCurrentItem(3);
                    adPage = 3;
                    break;
                case R.id.comic_rec_ad_page4_rb:
                    recAdContentVp.setCurrentItem(4);
                    adPage = 4;
                    break;
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    recAdPage0Rb.setChecked(true);
                    break;
                case 1:
                    recAdPage1Rb.setChecked(true);
                    break;
                case 2:
                    recAdPage2Rb.setChecked(true);
                    break;
                case 3:
                    recAdPage3Rb.setChecked(true);
                    break;
                case 4:
                    recAdPage4Rb.setChecked(true);
                    break;
            }
            adPage = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Message msg = new Message();
                    msg.what = 0;
                    msg.arg1 = adPage + 1;

                    mHandler.sendMessage(msg);
                }
            }
        };
    }
}
