package com.jtsw.sharedfloor.ApplicationsTests;

import android.app.Application;

import com.jtsw.sharedfloor.model.Expense;
import com.jtsw.sharedfloor.model.Home;
import com.jtsw.sharedfloor.model.User;

import java.util.ArrayList;
import java.util.List;

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
        int posRnd;

        for (int i=0;i<10;i++){
            posRnd=((int)Math.random()*(0-(nombres.length+1)+0));
            addExpense(new Expense(nombres[posRnd],Math.random()*100,usuario,choso));
        }
    }

}
