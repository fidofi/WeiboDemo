package com.fidofi.entity;

import java.util.Date;

public class Comment {
    private Integer commentid;

    private String username;

    private Integer newsid;

    private String commenttext;

    private Boolean commentstatus;

    private Date commenttime;

    public Comment(Integer commentid, String username, Integer newsid, String commenttext, Boolean commentstatus, Date commenttime) {
        this.commentid = commentid;
        this.username = username;
        this.newsid = newsid;
        this.commenttext = commenttext;
        this.commentstatus = commentstatus;
        this.commenttime = commenttime;
    }

    public Comment() {
        super();
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
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

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext == null ? null : commenttext.trim();
    }

    public Boolean getCommentstatus() {
        return commentstatus;
    }

    public void setCommentstatus(Boolean commentstatus) {
        this.commentstatus = commentstatus;
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }
}