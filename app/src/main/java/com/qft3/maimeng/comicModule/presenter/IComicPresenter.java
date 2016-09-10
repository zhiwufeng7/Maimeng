package com.qft3.maimeng.comicModule.presenter;

import com.qft3.maimeng.bean.ComicRecBean;

/**
 * Created by yangjw on 2016/8/26.
 */
public interface IComicPresenter {

    void getComicRecList();

    void getComicRecAd();

    interface Callback {
        void success(int key,String req);
    }
}
