package com.fidofi.entity;

import java.util.Date;

public class Relay {
    private Integer relayid;

    private String username;

    private Integer newsid;

    private String relaytext;

    private Boolean relaystatus;

    private Date relaytime;

    public Relay(Integer relayid, String username, Integer newsid, String relaytext, Boolean relaystatus, Date relaytime) {
        this.relayid = relayid;
        this.username = username;
        this.newsid = newsid;
        this.relaytext = relaytext;
        this.relaystatus = relaystatus;
        this.relaytime = relaytime;
    }

    public Relay() {
        super();
    }

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
        this.username = username == null ? null : username.trim();
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getRelaytext() {
        return relaytext;
    }

    public void setRelaytext(String relaytext) {
        this.relaytext = relaytext == null ? null : relaytext.trim();
    }

    public Boolean getRelaystatus() {
        return relaystatus;
    }

    public void setRelaystatus(Boolean relaystatus) {
        this.relaystatus = relaystatus;
    }

    public Date getRelaytime() {
        return relaytime;
    }

    public void setRelaytime(Date relaytime) {
        this.relaytime = relaytime;
    }
}