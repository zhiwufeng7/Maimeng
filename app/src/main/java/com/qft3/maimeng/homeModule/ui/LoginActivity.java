package com.qft3.maimeng.homeModule.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qft3.maimeng.R;

import java.util.HashMap;

import cn.sharesdk.framework.ShareSDK;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        SMSSDK.initSDK(this, "16f5ab308ed0e", "ab9be13eefe03fc1dbc4157efba9af21");
//        //打开注册页面
//        RegisterPage registerPage = new RegisterPage();
//        registerPage.setRegisterCallback(new EventHandler() {
//            public void afterEvent(int event, int result, Object data) {
//                // 解析注册结果
//                if (result == SMSSDK.RESULT_COMPLETE) {
//                    @SuppressWarnings("unchecked")
//                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
//                    String country = (String) phoneMap.get("country");
//                    String phone = (String) phoneMap.get("phone");
//
//              // 提交用户信息（此方法可以不调用）
//                   // registerUser(country, phone);
//                }
//            }
//        });
//        registerPage.show(this);


    }


}
