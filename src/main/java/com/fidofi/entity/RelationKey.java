package com.fidofi.entity;

public class RelationKey {
    private String firstuser;

    private String secondeuser;

    public RelationKey(String firstuser, String secondeuser) {
        this.firstuser = firstuser;
        this.secondeuser = secondeuser;
    }

    public RelationKey() {
        super();
    }

    public String getFirstuser() {
        return firstuser;
    }

    public void setFirstuser(String firstuser) {
        this.firstuser = firstuser == null ? null : firstuser.trim();
    }

    public String getSecondeuser() {
        return secondeuser;
    }

    public void setSecondeuser(String secondeuser) {
        this.secondeuser = secondeuser == null ? null : secondeuser.trim();
    }
}