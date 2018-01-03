package com.fidofi.entity;

public class User {
    private String username;

    private String userpassword;

    private String usersalt;

    private String userbrief;

    private Boolean usersex;

    private String userphoto;

    public User(String username, String userpassword, String usersalt, String userbrief, Boolean usersex, String userphoto) {
        this.username = username;
        this.userpassword = userpassword;
        this.usersalt = usersalt;
        this.userbrief = userbrief;
        this.usersex = usersex;
        this.userphoto = userphoto;
    }

    public User() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUsersalt() {
        return usersalt;
    }

    public void setUsersalt(String usersalt) {
        this.usersalt = usersalt == null ? null : usersalt.trim();
    }

    public String getUserbrief() {
        return userbrief;
    }

    public void setUserbrief(String userbrief) {
        this.userbrief = userbrief == null ? null : userbrief.trim();
    }

    public Boolean getUsersex() {
        return usersex;
    }

    public void setUsersex(Boolean usersex) {
        this.usersex = usersex;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }
}