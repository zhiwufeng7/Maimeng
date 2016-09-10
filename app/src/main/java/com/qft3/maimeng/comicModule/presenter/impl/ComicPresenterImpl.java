package com.qft3.maimeng.comicModule.presenter.impl;

import com.qft3.maimeng.bean.ComicRecAdBean;
import com.qft3.maimeng.bean.ComicRecBean;
import com.qft3.maimeng.comicModule.control.DataKey;
import com.qft3.maimeng.comicModule.model.IComicModel;
import com.qft3.maimeng.comicModule.model.impl.ComicModelImpl;
import com.qft3.maimeng.comicModule.presenter.IComicPresenter;
import com.qft3.maimeng.comicModule.view.IComicRecView;
import com.qft3.maimeng.comicModule.control.JsonTools;

/**
 * Created by yangjw on 2016/8/26.
 */
public class ComicPresenterImpl implements IComicPresenter, IComicPresenter.Callback {

    IComicModel mComicRecModel;
    IComicRecView recView;

    public ComicPresenterImpl(IComicRecView recView) {
        this.mComicRecModel = new ComicModelImpl();
        this.recView = recView;
    }

    /**
     * @param key
     * @param req
     */
    @Override
    public void success(int key, String req) {
        switch (key) {
            case DataKey.KEY_COMIC_REC:
                refreshListView(req);
                break;
            case DataKey.KEY_COMIC_REC_AD:
                refreshComicRecAd(req);
                break;
        }
    }

    private void refreshComicRecAd(String req) {
        if (req != null) {
            ComicRecAdBean recAdBean = JsonTools.getComicRecAd(req);
            recView.refreshComicRecAd(recAdBean);
        }
    }

    private void refreshListView(String req) {
        if (req != null) {
            ComicRecBean recBean = JsonTools.getComicRec(req);
            recView.refreshListView(recBean);
        }
    }

    @Override
    public void getComicRecList() {
        mComicRecModel.queryComicRecList(this);
    }

    @Override
    public void getComicRecAd() {
        mComicRecModel.queryComicRecAd(this);
    }
}
