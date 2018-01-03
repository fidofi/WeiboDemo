package com.fidofi.entity;

public class Manager {
    private String rootname;

    private String rootpassword;

    private String rootsalt;

    private Byte rootpower;

    public Manager(String rootname, String rootpassword, String rootsalt, Byte rootpower) {
        this.rootname = rootname;
        this.rootpassword = rootpassword;
        this.rootsalt = rootsalt;
        this.rootpower = rootpower;
    }

    public Manager() {
        super();
    }

    public String getRootname() {
        return rootname;
    }

    public void setRootname(String rootname) {
        this.rootname = rootname == null ? null : rootname.trim();
    }

    public String getRootpassword() {
        return rootpassword;
    }

    public void setRootpassword(String rootpassword) {
        this.rootpassword = rootpassword == null ? null : rootpassword.trim();
    }

    public String getRootsalt() {
        return rootsalt;
    }

    public void setRootsalt(String rootsalt) {
        this.rootsalt = rootsalt == null ? null : rootsalt.trim();
    }

    public Byte getRootpower() {
        return rootpower;
    }

    public void setRootpower(Byte rootpower) {
        this.rootpower = rootpower;
    }
}