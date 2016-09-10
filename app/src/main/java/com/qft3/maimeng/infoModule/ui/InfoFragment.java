package com.qft3.maimeng.infoModule.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qft3.maimeng.R;
import com.qft3.maimeng.bean.InfoListBean;
import com.qft3.maimeng.infoModule.adapter.InforListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class InfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<InfoListBean> infoListBeen=new ArrayList<>();

    private String mParam1;
    private String mParam2;
    private Context mContext;

    @BindView(R.id.info_fragment_lv)
    PullToRefreshListView mListView;
    @BindView(R.id.info_fragment_search_iv)
    ImageView searchImage;
    @BindView(R.id.info_fragment_title_tv)
    TextView titleText;
    @BindView(R.id.info_fragment_notify_iv)
    ImageView notifyImage;
    private InforListAdapter inforListAdapter;

    public InfoFragment() {

    }

    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        ButterKnife.bind(this, view);
        setupView();
        return view;
    }

    private void setupView() {
        inforListAdapter = new InforListAdapter(infoListBeen,mContext);
        setupHeaderView();
        mListView.setAdapter(inforListAdapter);
    }

    private void setupHeaderView() {
        View headerView = LayoutInflater.from(mContext).inflate(R.layout.info_fragment_header_view_layout, null);

    }


}
