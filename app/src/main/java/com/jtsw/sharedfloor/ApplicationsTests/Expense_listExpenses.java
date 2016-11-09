package com.jtsw.sharedfloor.ApplicationsTests;

import android.app.Application;

import com.jtsw.sharedfloor.model.Expense;
import com.jtsw.sharedfloor.model.Home;
import com.jtsw.sharedfloor.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//clase con datos ficticios para el testeo

public class Expense_listExpenses extends ArrayList<Expense> {

    public static Expense_listExpenses expenseslist;

    public void addExpense(Expense expense){
        add(expense);
    }

    //obtener la lista (el arraylist de los elementos) y si no lo tiene le da memoria
    public static Expense_listExpenses getExpenseslist(){
        if(expenseslist==null){
            expenseslist= new Expense_listExpenses();
        }
        return expenseslist;
    }

    //constructor
    private Expense_listExpenses(){
        String[] nombres={"luz","Gas","Agua","Internet","Café","Limpieza"};
        User usuario= new User("Usuarido","eluser69@suspenso.com","upcuo");
        Home choso= new Home("choso de usuarido",usuario);
        Random posRnd=new Random();
        int posRandom;

        for (int i=0;i<10;i++){
            posRandom=(int)(posRnd.nextDouble()*nombres.length);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {e.printStackTrace();}

            addExpense(new Expense(nombres[posRandom],posRandom*10.5,usuario,choso));
        }
    }

}
