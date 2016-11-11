package com.jtsw.sharedfloor.ApplicationsTests;


import com.jtsw.sharedfloor.model.PurchaseItem;
import com.jtsw.sharedfloor.model.TypeItem;

import java.util.ArrayList;
import java.util.Random;

public class Purchase_list_elements extends ArrayList<PurchaseItem>{
    public static Purchase_list_elements shoppingList;

    public void addItem(PurchaseItem item){
        shoppingList.add(item);
    }

    public static Purchase_list_elements getShoppingList(){
        if(shoppingList==null)
            shoppingList= new Purchase_list_elements();

        return  shoppingList;
    }

    //constructor
    public Purchase_list_elements(){
        TypeItem[] typeItems={
                new TypeItem("Estupefaciente"),
                new TypeItem("Cafeina"),
                new TypeItem("Limpieza"),
                new TypeItem("Cenas"),
                new TypeItem("Otros"),
                new TypeItem("Magic")
        };
        String[] nombre={"Farla","Prozac","Suboxone","una cabra","3 ovejas","ojo de triton"};
        Random posRnd=new Random();
        int tipo=0,nombrepos=0;

        for (int i=0;i<10;i++){
            try {
                nombrepos=(int)(posRnd.nextDouble()*nombre.length);
                Thread.sleep(100);
                tipo=(int)(posRnd.nextDouble()*typeItems.length);

            } catch (InterruptedException e) {e.printStackTrace();}

            addItem(new PurchaseItem(nombre[nombrepos],typeItems[tipo]));
        }
    }
}
