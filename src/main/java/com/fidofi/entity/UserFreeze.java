package com.fidofi.entity;

import java.util.Date;

public class UserFreeze extends UserFreezeKey {
    private Date freezetime;

    private String freezeresult;

    public UserFreeze(String rootname, String username, Date freezetime, String freezeresult) {
        super(rootname, username);
        this.freezetime = freezetime;
        this.freezeresult = freezeresult;
    }

    public UserFreeze() {
        super();
    }

    public Date getFreezetime() {
        return freezetime;
    }

    public void setFreezetime(Date freezetime) {
        this.freezetime = freezetime;
    }

    public String getFreezeresult() {
        return freezeresult;
    }

    public void setFreezeresult(String freezeresult) {
        this.freezeresult = freezeresult == null ? null : freezeresult.trim();
    }
}