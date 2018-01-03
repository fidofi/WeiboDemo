package com.fidofi.VO;

import com.fidofi.entity.User;

/**
 * Created by fido on 2018/1/3.
 */
public class SearchUser {
    private User user;
    private boolean follow;

    public SearchUser() {
    }

    public SearchUser(User user, boolean follow) {
        this.user = user;
        this.follow = follow;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }

    @Override
    public String toString() {
        return "SearchUser{" +
                "user=" + user +
                ", follow=" + follow +
                '}';
    }
}
