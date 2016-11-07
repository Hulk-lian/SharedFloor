package com.jtsw.sharedfloor.model;

import java.util.Comparator;

public class Expense implements Comparable<Expense>{

    private Home home;//the home of the expense

    private String id;
    private String name;
    private double amount;
    private double amountPerUser;
    private User paid;//the user who paid the expense

    //region getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountPerUser() {
        return amountPerUser;
    }

    public User getPaid() {
        return paid;
    }

    public void setPaid(User paid) {
        this.paid = paid;
    }
//endregion

    //constructor
    public Expense(String name,Double amount,User paid,Home homeE){
        this.name=name;
        this.amount=amount;
        this.amountPerUser=amount/homeE.getNumberUsers();
        this.paid=paid;
        this.home=homeE;
    }
    @Override
    public int compareTo(Expense expense) {
        int res=0;

        //comparacion de precios
        return res;
    }
}
