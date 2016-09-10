package com.qft3.maimeng.comicModule.model.impl;

import com.qft3.maimeng.comicModule.control.DataKey;
import com.qft3.maimeng.comicModule.model.IComicModel;
import com.qft3.maimeng.comicModule.presenter.IComicPresenter;
import com.qft3.maimeng.util.HttpUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/6.
 */
public class ComicModelImpl implements IComicModel {

    @Override
    public void queryComicRecList(final IComicPresenter.Callback callback) {
        HttpUtils.create().queryComicRec()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String req) {
                        callback.success(DataKey.KEY_COMIC_REC, req);
                    }
                });
    }

    @Override
    public void queryComicRecAd(final IComicPresenter.Callback callback) {
        HttpUtils.create().queryComicRecAd()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String req) {
                        callback.success(DataKey.KEY_COMIC_REC_AD, req);
                    }
                });
    }

}
