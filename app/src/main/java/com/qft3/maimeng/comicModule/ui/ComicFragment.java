package com.qft3.maimeng.comicModule.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qft3.maimeng.R;
import com.qft3.maimeng.comicModule.adapter.ComicTitleFPAdapter;
import com.qft3.maimeng.test.OtherFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/6.
 */
public class ComicFragment extends Fragment {

    @BindView(R.id.comic_tab_tl)
    TabLayout comicTabTl;
    @BindView(R.id.comic_content_vp)
    ViewPager comicContentVp;

    private Context mContext;
    private FragmentManager manager;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private List<String> titles = new ArrayList<String>();
    private ComicTitleFPAdapter adapter;

    public static ComicFragment newInstance() {
        ComicFragment fragment = new ComicFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        manager = getChildFragmentManager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        initData();
        adapter = new ComicTitleFPAdapter(manager, titles, fragments);
        comicContentVp.setAdapter(adapter);
        comicTabTl.setupWithViewPager(comicContentVp);
    }

    private void initData() {
        if (titles.size() == 0) {
            titles.add("推荐");
            titles.add("专题");
            titles.add("类别");
            titles.add("书架");
        }
        if (fragments.size() == 0) {
            fragments.add(ComicRecFragment.newInstance());
            fragments.add(OtherFragment.newInstance("1"));
            fragments.add(OtherFragment.newInstance("2"));
            fragments.add(OtherFragment.newInstance("3"));
        }
    }
}
