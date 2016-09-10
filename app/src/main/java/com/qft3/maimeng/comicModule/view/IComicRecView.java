package com.qft3.maimeng.comicModule.view;

import com.qft3.maimeng.bean.ComicRecAdBean;
import com.qft3.maimeng.bean.ComicRecBean;

/**
 * Created by Administrator on 2016/9/6.
 */
public interface IComicRecView {

    void refreshListView(ComicRecBean recBean);

    void refreshComicRecAd(ComicRecAdBean recAdBean);

}
