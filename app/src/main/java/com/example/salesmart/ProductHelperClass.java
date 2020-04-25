package com.example.salesmart;

import android.os.storage.StorageManager;

public class ProductHelperClass {

    String pName;
    String pDescription;
    String pStatus;
    String pPrice;
    StorageManager img;


    public ProductHelperClass() {
    }

    public ProductHelperClass(String pName, String pDescription, String pStatus, String pPrice, StorageManager img) {
        this.pName = pName;
        this.pDescription = pDescription;
        this.pStatus = pStatus;
        this.pPrice = pPrice;
        this.img=img;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpImg() {
        return String.valueOf(img);
    }
    public void setpImg(StorageManager img) {
        this.img = img;
    }

    public void setpImg(String toString) {
    }
}
