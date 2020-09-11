package com.example.desiparcha;

import android.widget.ArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class ItemsDetails implements Serializable {
    public String itemsName;
    public Float rate;
    public ArrayList<Float> itemsWeight = new ArrayList<>();
    public ArrayList<Float> packageWeight = new ArrayList<>();

    public  ItemsDetails(){}

    public ItemsDetails(String itemsName, Float rate){
        this.itemsName = itemsName;
        this.rate = rate;
    }
    public void setItemsName(String itemsName){this.itemsName=itemsName;}
    public void setRate(Float rate){this.rate=rate;}
    public void setItemsWeight(Float weight){this.itemsWeight.add(weight);}
    public void setPackageWeight(Float weight){this.packageWeight.add(weight);}

    public String getItemsName(){return itemsName;}
    public Float getRate(){return rate;}
    public ArrayList<Float> getItemsWeight(){return itemsWeight;}
    public ArrayList<Float> getPackageWeight(){return packageWeight;}


}
