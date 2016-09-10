package com.qft3.maimeng.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qft3.maimeng.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtherFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;
    private Context mContext;

    @BindView(R.id.other_content_tv)
    TextView otherContentTv;

    public static OtherFragment newInstance(String param1) {
        OtherFragment fragment = new OtherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other, container, false);
        ButterKnife.bind(this, view);

        otherContentTv.setText(mParam1);
        return view;
    }

}
