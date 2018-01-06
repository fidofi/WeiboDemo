package com.fidofi.VO;

import com.fidofi.entity.News;

import java.util.Date;

/**
 * Created by fido on 2018/1/6.
 * 转发消息的展示
 */
public class RelayVO {
    private Integer relayid;

    private String username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                ", username='" + username + '\'' +
                ", news=" + news +
                ", relaytext='" + relaytext + '\'' +
                ", relaystatus=" + relaystatus +
                ", relaytime=" + relaytime +
                '}';
    }
}
