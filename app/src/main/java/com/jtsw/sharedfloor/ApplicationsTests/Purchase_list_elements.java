package com.jtsw.sharedfloor.ApplicationsTests;


import com.jtsw.sharedfloor.model.PurchaseItem;
import com.jtsw.sharedfloor.model.TypeItem;

import java.util.ArrayList;
import java.util.Random;

public class Purchase_list_elements extends ArrayList<PurchaseItem>{

    public static Purchase_list_elements shoppingList;

    public static Purchase_list_elements getInstance(){
        if(shoppingList==null)
            shoppingList= new Purchase_list_elements();

        return  shoppingList;
    }

    public void addItem(PurchaseItem p){
        add(p);
    }

    //constructor
    public Purchase_list_elements(){

        TypeItem[] typeItems={ new TypeItem("Estupefaciente"),new TypeItem("Cafeina"),  new TypeItem("Limpieza"), new TypeItem("Cenas"), new TypeItem("Otros"), new TypeItem("Magic"),new TypeItem("Lo necesario para aprobar DEINT")};
        String[] nombre={"Farla","Prozac","Suboxone","una cabra","3 ovejas","ojo de triton","ojo de triton" , "Kit - Kat","las 7 bolas de dragon"};
        Random posRnd=new Random();
        int tipo=0,nombrepos=0;

        for (int i=0;i<50;i++){
            try {
                nombrepos=(int)(posRnd.nextDouble()*nombre.length);
                Thread.sleep(10);
                tipo=(int)(posRnd.nextDouble()*typeItems.length);

            } catch (InterruptedException e) {e.printStackTrace();}

            PurchaseItem p=(new PurchaseItem(nombre[nombrepos],typeItems[tipo]));

            this.addItem(p);
        }
    }
}
