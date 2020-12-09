package com.hieu.thecoffeehouse;

public class Rcv_Item {
    private int resourceID;
    private String title,giatien;
    public Rcv_Item(){}
    public Rcv_Item(int resourceID, String title,String giatien) {
        this.resourceID = resourceID;
        this.title = title;
        this.giatien = giatien;
    }

    public String getGiaTien() {
        return giatien;
    }

    public void setGiaTien(String giatien) {
        this.giatien = giatien;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

