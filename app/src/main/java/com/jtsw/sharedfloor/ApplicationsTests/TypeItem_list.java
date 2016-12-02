package com.jtsw.sharedfloor.ApplicationsTests;

import com.jtsw.sharedfloor.model.TypeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TypeItem_list extends ArrayList<TypeItem>{

        public static TypeItem_list typeList;

        public static TypeItem_list getInstance(){
            if(typeList==null)
                typeList= new TypeItem_list();

            return  typeList;
        }

        public List<TypeItem> getListElement(){

            return  typeList;
        }


        public void addItem(TypeItem t){
            add(t);
        }

        public List<TypeItem> getAll(){
            return  typeList;
        }


    //constructor
        public TypeItem_list(){
            this.addItem(new TypeItem("magia"));
            this.addItem(new TypeItem("limpieza"));
            this.addItem(new TypeItem("dulce"));
            this.addItem(new TypeItem("repostería"));
            this.addItem(new TypeItem("alcohol"));
            this.addItem(new TypeItem("bebida"));
            this.addItem(new TypeItem("utensilios"));
            this.addItem(new TypeItem("Lo necesario para aprobar DEINT"));
        }
    }
