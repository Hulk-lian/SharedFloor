package com.jtsw.sharedfloor.ApplicationsTests;


import com.jtsw.sharedfloor.model.PurchaseItem;
import com.jtsw.sharedfloor.model.TypeItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Purchase_list_elements extends ArrayList<PurchaseItem>{

    static Purchase_list_elements shopList;

    private TypeItem_list tiposElementos;

    public static Purchase_list_elements getInstance(){
        if(shopList==null)
            shopList= new Purchase_list_elements();

        return  shopList;
    }

    public void addItem(PurchaseItem p){
        add(p);
    }

    public static List<PurchaseItem> getAllItems(){
        return  shopList;
    }

    public static void sortBy(int type, boolean order){

        if(type==0) {
            if(order) {
                Collections.sort(shopList, (item, t1) -> item.getName().toLowerCase().compareTo(t1.getName().toLowerCase()));
            }
            else {
                Collections.sort(shopList, (item, t1) -> t1.getName().toLowerCase().compareTo(item.getName().toLowerCase()));
            }
        }
        else if(type==1){
            if(order) {
                Collections.sort(shopList, (item, t1) -> item.getType().getNameType().toLowerCase().compareTo(t1.getType().getNameType().toLowerCase()));
            }
            else {
                Collections.sort(shopList, (item, t1) -> t1.getType().getNameType().toLowerCase().compareTo(item.getType().getNameType().toLowerCase()));
            }
        }

    }
    //constructor
    public Purchase_list_elements(){
        tiposElementos= new TypeItem_list();
        List<TypeItem> typeItems= tiposElementos.getInstance();
        String[] nombre={"Farla","Prozac","Suboxone","una cabra","3 ovejas","ojo de triton","ojo de triton" , "Kit - Kat","las 7 bolas de dragon"};
        Random posRnd=new Random();
        int tipo=0,nombrepos=0;

        for (int i=0;i<20;i++){
            try {
                nombrepos=(int)(posRnd.nextDouble()*nombre.length);
                Thread.sleep(10);
                tipo=(int)(posRnd.nextDouble()*typeItems.size());

            } catch (InterruptedException e) {e.printStackTrace();}

            PurchaseItem p=(new PurchaseItem(nombre[nombrepos],typeItems.get(tipo)));

            this.addItem(p);
        }
    }
}
