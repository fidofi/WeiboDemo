package com.fidofi.entity;

import java.util.Date;

public class NewsDeletion extends NewsDeletionKey {
    private String deleteresult;

    private Date deletetime;

    public NewsDeletion(Integer newsid, String rootname, String deleteresult, Date deletetime) {
        super(newsid, rootname);
        this.deleteresult = deleteresult;
        this.deletetime = deletetime;
    }

    public NewsDeletion() {
        super();
    }

    public String getDeleteresult() {
        return deleteresult;
    }

    public void setDeleteresult(String deleteresult) {
        this.deleteresult = deleteresult == null ? null : deleteresult.trim();
    }

    public Date getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }
}