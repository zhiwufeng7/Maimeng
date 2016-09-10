package com.qft3.maimeng.comicModule.control;

import com.google.gson.Gson;
import com.qft3.maimeng.bean.BaseBean;
import com.qft3.maimeng.bean.ComicRecAdBean;
import com.qft3.maimeng.bean.ComicRecAdBean0;
import com.qft3.maimeng.bean.ComicRecAdBean3;
import com.qft3.maimeng.bean.ComicRecAdBean4;
import com.qft3.maimeng.bean.ComicRecBean;
import com.qft3.maimeng.bean.ComicRecBean0;
import com.qft3.maimeng.bean.ComicRecBean3;
import com.qft3.maimeng.bean.ComicRecBean6;
import com.qft3.maimeng.bean.ComicRecCartoonSetBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class JsonTools {

    public static ComicRecBean getComicRec(String jsonString) {
        Gson gson = new Gson();
        ComicRecBean recBean = gson.fromJson(jsonString, ComicRecBean.class);
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            List<BaseBean> results = initComicRecResult(gson, jsonObject);
            recBean.setResults(results);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recBean;
    }

    private static List<BaseBean> initComicRecResult(Gson gson, JSONObject jsonObject) throws JSONException {
        List<BaseBean> results = new ArrayList<BaseBean>();
        JSONArray resultsJA = jsonObject.getJSONArray("results");
        for (int i = 0; i < 8; i++) {
            JSONObject resultsJO = resultsJA.getJSONObject(i);
            if (i == 3) {
                ComicRecBean3 recBean3 = gson.fromJson(resultsJO.toString(), ComicRecBean3.class);
                results.add(recBean3);
            } else if (i == 6) {
                ComicRecBean6 recBean6 = gson.fromJson(resultsJO.toString(), ComicRecBean6.class);
                results.add(recBean6);
            } else {
                ComicRecBean0 recBean0 = gson.fromJson(resultsJO.toString(), ComicRecBean0.class);
                int count = 0;
                switch (i){
                    case 0:
                        count = 0;
                        break;
                    case 1:
                        count = 30;
                        break;
                    case 2:
                        count = 4;
                        break;
                    case 4:
                        count = 3;
                        break;
                    case 5:
                        count = 3;
                        break;
                    case 7:
                        count = 9;
                        break;
                }
                List<BaseBean> cartoonSetList = initComicRecCartoonSetList(gson, resultsJO,count);
                recBean0.setCartoonSetList(cartoonSetList);
                results.add(recBean0);
            }
        }
        return results;
    }

    private static List<BaseBean> initComicRecCartoonSetList(Gson gson, JSONObject resultsJO, int count) throws JSONException {
        List<BaseBean> cartoonSetList = new ArrayList<BaseBean>();
        JSONArray cartoonSetListJA = resultsJO.getJSONArray("cartoonSetList");
        for (int i = 0; i < count; i++) {
            JSONObject cartoonSetListJO = cartoonSetListJA.getJSONObject(i);
            ComicRecCartoonSetBean cartoonSetBean = gson.fromJson(cartoonSetListJO.toString(), ComicRecCartoonSetBean.class);
            cartoonSetList.add(cartoonSetBean);
        }
        return cartoonSetList;
    }

    public static ComicRecAdBean getComicRecAd(String jsonString) {
        Gson gson = new Gson();
        List<BaseBean> baseBeanList = new ArrayList<BaseBean>();
        ComicRecAdBean recBean = gson.fromJson(jsonString, ComicRecAdBean.class);
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray results = jsonObject.getJSONArray("results");
            for (int i = 0; i < 5; i++) {
                JSONObject resultsJSONObject = results.getJSONObject(i);
                if (i == 3) {
                    ComicRecAdBean3 recAdBean3 = gson.fromJson(resultsJSONObject.toString(), ComicRecAdBean3.class);
                    baseBeanList.add(recAdBean3);
                } else if (i == 4) {
                    ComicRecAdBean4 recAdBean4 = gson.fromJson(resultsJSONObject.toString(), ComicRecAdBean4.class);
                    baseBeanList.add(recAdBean4);
                } else {
                    ComicRecAdBean0 recAdBean0 = gson.fromJson(resultsJSONObject.toString(), ComicRecAdBean0.class);
                    baseBeanList.add(recAdBean0);
                }
            }
            recBean.setResults(baseBeanList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recBean;
    }
}
