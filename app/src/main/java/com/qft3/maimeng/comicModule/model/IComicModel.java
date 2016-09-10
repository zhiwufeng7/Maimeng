package com.qft3.maimeng.comicModule.model;

import com.qft3.maimeng.comicModule.presenter.IComicPresenter;

/**
 * Created by Administrator on 2016/9/6.
 */
public interface IComicModel {

    void queryComicRecList(IComicPresenter.Callback callback);

    void queryComicRecAd(IComicPresenter.Callback callback);

}
