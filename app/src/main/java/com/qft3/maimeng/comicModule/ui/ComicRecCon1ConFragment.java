package com.qft3.maimeng.comicModule.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qft3.maimeng.R;
import com.qft3.maimeng.bean.BaseBean;
import com.qft3.maimeng.comicModule.adapter.ComicRecCon1ConRVAdapter;
import com.qft3.maimeng.comicModule.presenter.IComicPresenter;
import com.qft3.maimeng.comicModule.presenter.impl.ComicPresenterImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/9.
 */
public class ComicRecCon1ConFragment extends Fragment {

    @BindView(R.id.comic_rec_con1_con_page_rv)
    RecyclerView con1ConPageRv;

    private static final String ARG_PARAM1 = "dataList";
    private Context mContext;

    private List<BaseBean> dataList = new ArrayList<BaseBean>();

    public static ComicRecCon1ConFragment newInstance(List<BaseBean> dataList) {
        ComicRecCon1ConFragment fragment = new ComicRecCon1ConFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, (Serializable) dataList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dataList = (List<BaseBean>) getArguments().getSerializable(ARG_PARAM1);
        }
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_rec_con1_con, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        ComicRecCon1ConRVAdapter conRVAdapter = new ComicRecCon1ConRVAdapter(mContext,dataList);
        con1ConPageRv.setAdapter(conRVAdapter);
        con1ConPageRv.setLayoutManager(new GridLayoutManager(mContext,2, LinearLayoutManager.HORIZONTAL,false));
    }
}
