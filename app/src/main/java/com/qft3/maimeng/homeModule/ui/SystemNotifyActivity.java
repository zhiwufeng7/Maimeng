package com.qft3.maimeng.homeModule.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qft3.maimeng.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SystemNotifyActivity extends AppCompatActivity {

    @BindView(R.id.system_notify_activity_back_iv)
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_notify);
        ButterKnife.bind(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
