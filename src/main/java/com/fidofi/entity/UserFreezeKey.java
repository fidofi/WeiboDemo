package com.fidofi.entity;

public class UserFreezeKey {
    private String rootname;

    private String username;

    public UserFreezeKey(String rootname, String username) {
        this.rootname = rootname;
        this.username = username;
    }

    public UserFreezeKey() {
        super();
    }

    public String getRootname() {
        return rootname;
    }

    public void setRootname(String rootname) {
        this.rootname = rootname == null ? null : rootname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}