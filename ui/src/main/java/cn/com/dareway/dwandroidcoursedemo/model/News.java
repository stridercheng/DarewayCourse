package cn.com.dareway.dwandroidcoursedemo.model;

/**
 * description:
 * DwAndroidCourseDemo : 38:
 * Created by chengz on 2016/9/19.
 * Copyright (c) 2016.DareWay  Inc. All rights reserved.
 */
public class News {

    /**
     * cid : 2
     * cvtPubTime : 1474269720000
     * id : 3991306
     * pubTime : 2016-09-19 15:22
     * sourceUrl : http://www.yinews.cn/article/3991306.shtm
     * subTitle : 社保中断怎么办？不了解这些，可能吃大亏！
     * title : 社保中断怎么办？不了解这些，可能吃大亏！
     */

    private String cid;
    private long cvtPubTime;
    private String id;
    private String pubTime;
    private String sourceUrl;
    private String subTitle;
    private String title;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public long getCvtPubTime() {
        return cvtPubTime;
    }

    public void setCvtPubTime(long cvtPubTime) {
        this.cvtPubTime = cvtPubTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
