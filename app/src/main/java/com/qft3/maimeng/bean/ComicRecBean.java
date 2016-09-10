package com.qft3.maimeng.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class ComicRecBean extends BaseBean{

    /**
     * categorys :
     * page : 1
     * r : v6/recommend/getUserRecommendList
     * isNew : 1
     * size : 999
     * REQUEST_METHOD : GET
     */

    private ParamsBean params;
    /**
     * countTotal : 8
     * otherType : 0
     * otherTitle :
     */

    private ExtraInfoBean extraInfo;
    /**
     * params : {"categorys":"","page":"1","r":"v6/recommend/getUserRecommendList","isNew":"1","size":"999","REQUEST_METHOD":"GET"}
     * extraInfo : {"countTotal":"8","otherType":0,"otherTitle":""}
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
        private String categorys;
        private String page;
        private String r;
        private String isNew;
        private String size;
        private String REQUEST_METHOD;

        public String getCategorys() {
            return categorys;
        }

        public void setCategorys(String categorys) {
            this.categorys = categorys;
        }

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

        public String getIsNew() {
            return isNew;
        }

        public void setIsNew(String isNew) {
            this.isNew = isNew;
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
        private int otherType;
        private String otherTitle;

        public String getCountTotal() {
            return countTotal;
        }

        public void setCountTotal(String countTotal) {
            this.countTotal = countTotal;
        }

        public int getOtherType() {
            return otherType;
        }

        public void setOtherType(int otherType) {
            this.otherType = otherType;
        }

        public String getOtherTitle() {
            return otherTitle;
        }

        public void setOtherTitle(String otherTitle) {
            this.otherTitle = otherTitle;
        }
    }
}
