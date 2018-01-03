package com.fidofi.entity;

public class NewsDeletionKey {
    private Integer newsid;

    private String rootname;

    public NewsDeletionKey(Integer newsid, String rootname) {
        this.newsid = newsid;
        this.rootname = rootname;
    }

    public NewsDeletionKey() {
        super();
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getRootname() {
        return rootname;
    }

    public void setRootname(String rootname) {
        this.rootname = rootname == null ? null : rootname.trim();
    }
}