package com.fidofi.entity;

public class Relation extends RelationKey {
    private Boolean relationstatus;

    public Relation(String firstuser, String secondeuser, Boolean relationstatus) {
        super(firstuser, secondeuser);
        this.relationstatus = relationstatus;
    }

    public Relation() {
        super();
    }

    public Boolean getRelationstatus() {
        return relationstatus;
    }

    public void setRelationstatus(Boolean relationstatus) {
        this.relationstatus = relationstatus;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "relationstatus=" + relationstatus +
                "firstUser"+this.getFirstuser()+"secondeUser"+this.getSecondeuser()+
                '}';
    }
}