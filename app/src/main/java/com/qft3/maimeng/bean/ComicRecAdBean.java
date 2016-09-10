package com.qft3.maimeng.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class ComicRecAdBean extends BaseBean {

    /**
     * page : 1
     * r : adImage/list
     * customPosition : 2
     * size : 999
     * REQUEST_METHOD : GET
     */

    private ParamsBean params;
    /**
     * countTotal : 5
     */

    private ExtraInfoBean extraInfo;
    /**
     * params : {"page":"1","r":"adImage/list","customPosition":"2","size":"999","REQUEST_METHOD":"GET"}
     * extraInfo : {"countTotal":"5"}
     * code : 0
     * error :
     * results : []
     */

    private int code;
    private String error;
    private List<BaseBean> results;

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public ExtraInfoBean getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfoBean extraInfo) {
        this.extraInfo = extraInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<BaseBean> getResults() {
        return results;
    }

    public void setResults(List<BaseBean> results) {
        this.results = results;
    }

    public static class ParamsBean {
        private String page;
        private String r;
        private String customPosition;
        private String size;
        private String REQUEST_METHOD;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getR() {
            return r;
        }

        public void setR(String r) {
            this.r = r;
        }

        public String getCustomPosition() {
            return customPosition;
        }

        public void setCustomPosition(String customPosition) {
            this.customPosition = customPosition;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getREQUEST_METHOD() {
            return REQUEST_METHOD;
        }

        public void setREQUEST_METHOD(String REQUEST_METHOD) {
            this.REQUEST_METHOD = REQUEST_METHOD;
        }
    }

    public static class ExtraInfoBean {
        private String countTotal;

        public String getCountTotal() {
            return countTotal;
        }

        public void setCountTotal(String countTotal) {
            this.countTotal = countTotal;
        }
    }
}
