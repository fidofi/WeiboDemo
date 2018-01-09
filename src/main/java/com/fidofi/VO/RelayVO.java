package com.fidofi.VO;

import com.fidofi.entity.News;
import com.fidofi.entity.User;

import java.util.Date;

/**
 * Created by fido on 2018/1/6.
 * 转发消息的展示
 */
public class RelayVO {
    private Integer relayid;

    private User user;

    private News news;

    private String relaytext;

    private boolean relaystatus;

    private Date relaytime;

    public Integer getRelayid() {
        return relayid;
    }

    public void setRelayid(Integer relayid) {
        this.relayid = relayid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;

    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getRelaytext() {
        return relaytext;
    }

    public void setRelaytext(String relaytext) {
        this.relaytext = relaytext;
    }

    public boolean isRelaystatus() {
        return relaystatus;
    }

    public void setRelaystatus(boolean relaystatus) {
        this.relaystatus = relaystatus;
    }

    public Date getRelaytime() {
        return relaytime;
    }

    public void setRelaytime(Date relaytime) {
        this.relaytime = relaytime;
    }

    @Override
    public String toString() {
        return "RelayVO{" +
                "relayid=" + relayid +
                ", user=" + user +
                ", news=" + news +
                ", relaytext='" + relaytext + '\'' +
                ", relaystatus=" + relaystatus +
                ", relaytime=" + relaytime +
                '}';
    }
}
