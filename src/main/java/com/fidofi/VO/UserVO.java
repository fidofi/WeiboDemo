package com.fidofi.VO;

/**
 * Created by fido on 2018/1/7.
 */
public class UserVO {
    private String username;

    private String userbrief;

    private boolean usersex;

    private boolean userstatus;

    private String freezeResult;

    private String rootName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserbrief() {
        return userbrief;
    }

    public void setUserbrief(String userbrief) {
        this.userbrief = userbrief;
    }

    public boolean isUsersex() {
        return usersex;
    }

    public void setUsersex(boolean usersex) {
        this.usersex = usersex;
    }

    public boolean isUserstatus() {
        return userstatus;
    }

    public void setUserstatus(boolean userstatus) {
        this.userstatus = userstatus;
    }

    public String getFreezeResult() {
        return freezeResult;
    }

    public void setFreezeResult(String freezeResult) {
        this.freezeResult = freezeResult;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "username='" + username + '\'' +
                ", userbrief='" + userbrief + '\'' +
                ", usersex=" + usersex +
                ", userstatus=" + userstatus +
                ", freezeResult='" + freezeResult + '\'' +
                ", rootName='" + rootName + '\'' +
                '}';
    }
}
