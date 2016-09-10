package com.qft3.maimeng.picModule.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.qft3.maimeng.R;
import com.qft3.maimeng.bean.PictureAllBean;
import com.qft3.maimeng.picModule.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PictureFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<PictureAllBean.ResultsBean> resultsBean=new ArrayList<>();

    private String mParam1;
    private String mParam2;
    private Context mContext;

    @BindView(R.id.picture_fragment_add_iv)
    ImageView addImage;
    @BindView(R.id.picture_fragment_sdcard_iv)
    ImageView sdkImage;
    @BindView(R.id.picture_fragment_all_btn)
    Button allBtn;
    @BindView(R.id.picture_fragment_picture_btn)
    Button pictureBtn;
    @BindView(R.id.picture_fragment_other_btn)
    Button otherBtn;
    @BindView(R.id.picture_fragment_refresh_iv)
    ImageView refreshImage;
    @BindView(R.id.picture_fragment_swip_resh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.picture_fragment_recycler_view)
    RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    public PictureFragment() {

    }

    public static PictureFragment newInstance(String param1, String param2) {
        PictureFragment fragment = new PictureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mContext=getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        ButterKnife.bind(this, view);
        initListener();
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {

        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerAdapter=new RecyclerAdapter(mContext, resultsBean);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void initListener() {
        addImage.setOnClickListener(this);
        sdkImage.setOnClickListener(this);
        refreshImage.setOnClickListener(this);

        allBtn.setOnClickListener(this);
        pictureBtn.setOnClickListener(this);
        otherBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.picture_fragment_add_iv:
                break;
            case R.id.picture_fragment_sdcard_iv:
                break;
            case R.id.picture_fragment_refresh_iv:
                break;
            case R.id.picture_fragment_all_btn:
                break;
            case R.id.picture_fragment_picture_btn:
                break;
            case R.id.picture_fragment_other_btn:
                break;
        }
    }
}
