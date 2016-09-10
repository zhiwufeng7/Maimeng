package com.qft3.maimeng.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public class ComicRecBean0 extends BaseBean {

    /**
     * id : 1
     * title : 继续撸
     * type : 0
     * valueType : 0
     * valueID :
     * url : cartoonSet/userContinueReadList
     * showMode : 1
     * showNums : 3
     * priority : 0
     * status : 1
     * desc : 上次看过的又有更新咯！
     * createTime : 2016-08-10 10:24:12
     * modifyTime : 2015-12-11 18:16:48
     * userID : 4
     * cartoonSetList : []
     * icon : http://api.playsm.com/resource/img/icon/continue.png
     */

    private String id;
    private String title;
    private String type;
    private String valueType;
    private String valueID;
    private String url;
    private String showMode;
    private String showNums;
    private String priority;
    private String status;
    private String desc;
    private String createTime;
    private String modifyTime;
    private String userID;
    private String icon;
    private List<BaseBean> cartoonSetList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValueID() {
        return valueID;
    }

    public void setValueID(String valueID) {
        this.valueID = valueID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShowMode() {
        return showMode;
    }

    public void setShowMode(String showMode) {
        this.showMode = showMode;
    }

    public String getShowNums() {
        return showNums;
    }

    public void setShowNums(String showNums) {
        this.showNums = showNums;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<BaseBean> getCartoonSetList() {
        return cartoonSetList;
    }

    public void setCartoonSetList(List<BaseBean> cartoonSetList) {
        this.cartoonSetList = cartoonSetList;
    }
}
