package com.qft3.maimeng.homeModule.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.qft3.maimeng.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.home_fragment_login_circle_iv)
    CircleImageView circleImageView;
    @BindView(R.id.home_fragment_login_btn)
    Button loginBtn;
    @BindView(R.id.home_fragment_notify_ll)
    LinearLayout notifyLinearLayout;
    @BindView(R.id.home_fragment_shop_ll)
    LinearLayout shopLinearLayout;
    @BindView(R.id.home_fragment_setting_ll)
    LinearLayout settingLinearLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        initListener();
        return view;
    }

    private void initListener() {
        circleImageView.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        notifyLinearLayout.setOnClickListener(this);
        shopLinearLayout.setOnClickListener(this);
        settingLinearLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent  intent=new Intent();
        switch (v.getId()){
            case R.id.home_fragment_login_circle_iv:
                intent.setClass(getActivity(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.home_fragment_login_btn:
                intent.setClass(getActivity(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.home_fragment_notify_ll:
               intent.setClass(getActivity(),NotifyActivity.class);
                startActivity(intent);
                break;
            case R.id.home_fragment_shop_ll:
                intent.setClass(getActivity(),LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.home_fragment_setting_ll:
                intent.setClass(getActivity(),SettingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
