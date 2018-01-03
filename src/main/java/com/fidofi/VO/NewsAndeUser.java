package com.fidofi.VO;

import com.fidofi.entity.User;

import java.util.Date;

/**
 * Created by fido on 2018/1/3.
 * 用于展示用
 */
public class NewsAndeUser {
    private Integer newsid;

    private String newstext;

    private String newsphoto;

    private User user;

    private Integer newscomment;

    private Integer newsrelay;

    private Integer newslike;

    private Date newstime;

    private Boolean newsstatus;

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
        this.newstext = newstext;
    }

    public String getNewsphoto() {
        return newsphoto;
    }

    public void setNewsphoto(String newsphoto) {
        this.newsphoto = newsphoto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "NewsAndeUser{" +
                "newsid=" + newsid +
                ", newstext='" + newstext + '\'' +
                ", newsphoto='" + newsphoto + '\'' +
                ", user=" + user +
                ", newscomment=" + newscomment +
                ", newsrelay=" + newsrelay +
                ", newslike=" + newslike +
                ", newstime=" + newstime +
                ", newsstatus=" + newsstatus +
                '}';
    }
}
