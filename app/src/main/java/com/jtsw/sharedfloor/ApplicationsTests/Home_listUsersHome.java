package com.jtsw.sharedfloor.ApplicationsTests;

import com.jtsw.sharedfloor.model.User;

import java.util.ArrayList;


public class Home_listUsersHome extends ArrayList<User>{
    //clase con datos ficticios para el testeo

        public static Home_listUsersHome homeUserlist;

        public void addUser(User usuario){
            add(usuario);
        }

        //obtener la lista (el arraylist de los elementos) y si no lo tiene le da memoria
        public static Home_listUsersHome getExpenseslist(){
            if(homeUserlist==null){
                homeUserlist= new Home_listUsersHome();
            }
            return homeUserlist;
        }

        //constructor
        private Home_listUsersHome(){
            addUser(new User("Haprender","DonalDuck@sheep.com","upcuoeslaclave"));
    }
}
