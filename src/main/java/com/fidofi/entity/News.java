package com.fidofi.entity;

import java.util.Date;

public class News {
    private Integer newsid;

    private String newstext;

    private String newsphoto;

    private String username;

    private Integer newscomment;

    private Integer newsrelay;

    private Integer newslike;

    private Date newstime;

    private Boolean newsstatus;

    public News(Integer newsid, String newstext, String newsphoto, String username, Integer newscomment, Integer newsrelay, Integer newslike, Date newstime, Boolean newsstatus) {
        this.newsid = newsid;
        this.newstext = newstext;
        this.newsphoto = newsphoto;
        this.username = username;
        this.newscomment = newscomment;
        this.newsrelay = newsrelay;
        this.newslike = newslike;
        this.newstime = newstime;
        this.newsstatus = newsstatus;
    }

    public News() {
        super();
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewstext() {
        return newstext;
    }

    public void setNewstext(String newstext) {
        this.newstext = newstext == null ? null : newstext.trim();
    }

    public String getNewsphoto() {
        return newsphoto;
    }

    public void setNewsphoto(String newsphoto) {
        this.newsphoto = newsphoto == null ? null : newsphoto.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getNewscomment() {
        return newscomment;
    }

    public void setNewscomment(Integer newscomment) {
        this.newscomment = newscomment;
    }

    public Integer getNewsrelay() {
        return newsrelay;
    }

    public void setNewsrelay(Integer newsrelay) {
        this.newsrelay = newsrelay;
    }

    public Integer getNewslike() {
        return newslike;
    }

    public void setNewslike(Integer newslike) {
        this.newslike = newslike;
    }

    public Date getNewstime() {
        return newstime;
    }

    public void setNewstime(Date newstime) {
        this.newstime = newstime;
    }

    public Boolean getNewsstatus() {
        return newsstatus;
    }

    public void setNewsstatus(Boolean newsstatus) {
        this.newsstatus = newsstatus;
    }
}