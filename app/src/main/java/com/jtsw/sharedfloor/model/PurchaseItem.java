package com.jtsw.sharedfloor.model;

import java.io.Serializable;
import java.util.Comparator;

public class PurchaseItem implements Serializable{
    private String id;
    private String name;
    private TypeItem type;

    public PurchaseItem(String name,TypeItem type){
        this.name=name;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeItem getType() {
        return type;
    }

    public String getId() {
        return id;
    }


}
