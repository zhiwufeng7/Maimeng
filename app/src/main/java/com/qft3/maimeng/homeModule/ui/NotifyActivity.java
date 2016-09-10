package com.qft3.maimeng.homeModule.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qft3.maimeng.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotifyActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.notify_activity_back_iv)
    ImageView imageView;
    @BindView(R.id.notify_activity_back_comment_ll)
    LinearLayout commentLinearLayout;
    @BindView(R.id.notify_activity_praise_ll)
    LinearLayout praiseLinearLayout;
    @BindView(R.id.notify_activity_feedback_ll)
    LinearLayout feedbackLinearLayout;
    @BindView(R.id.notify_activity_system_notify_ll)
    LinearLayout systemLinearLayout;
    @BindView(R.id.notify_actify_private_letter_ll)
    LinearLayout letterLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        ButterKnife.bind(this);
      initListener();
    }

    private void initListener() {
        imageView.setOnClickListener(this);
        commentLinearLayout.setOnClickListener(this);
        praiseLinearLayout.setOnClickListener(this);
        feedbackLinearLayout.setOnClickListener(this);
        systemLinearLayout.setOnClickListener(this);
        letterLinearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.notify_activity_back_iv:
                onBackPressed();
                break;
            case R.id.notify_activity_back_comment_ll:
                break;
            case R.id.notify_activity_praise_ll:
                break;
            case R.id.notify_activity_feedback_ll:
                intent.setClass(this,FeedbackActivity.class);
                startActivity(intent);
                break;
            case R.id.notify_activity_system_notify_ll:
                intent.setClass(this,SystemNotifyActivity.class);
                startActivity(intent);
                break;
            case R.id.notify_actify_private_letter_ll:
                break;
        }
    }
}
