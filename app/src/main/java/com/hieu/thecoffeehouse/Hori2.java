package com.hieu.thecoffeehouse;

public class Hori2 {
    private int resourceID;
    private String title,mota;
    public Hori2(){}
    public Hori2(int resourceID, String title,String mota) {
        this.resourceID = resourceID;
        this.title = title;
        this.mota = mota;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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

