package com.jtsw.sharedfloor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jtsw.sharedfloor.ApplicationsTests.Expense_listExpenses;
import com.jtsw.sharedfloor.R;
import com.jtsw.sharedfloor.model.Expense;

import java.util.Collections;
import java.util.List;

public class ExpenseAdapter extends ArrayAdapter<Expense> {

    Context context;
    List<Expense> expenseList;
    public ExpenseAdapter(Context context){
        super(context, R.layout.expense_expense_ITEM, Expense_listExpenses.getExpenseslist());
        this.context=context;
        expenseList=Expense_listExpenses.getExpenseslist();
    }

    public void order(int orderType){
        //por ahora solo esta ordenado por cantidad(amount)
        switch (orderType){

            default:
                Collections.sort(expenseList,Expense.AMOUNT_COMPARATOR);
                break;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item= convertView;
        ExpenseHolder expenseHolder;

        if(item==null){
            //create the inflater object
            LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //inflate the view
            item=inflater.inflate(R.layout.expense_expense_ITEM,null);

            //memory for the holder
            expenseHolder= new ExpenseHolder();

            //vinculate
            expenseHolder.txvnameExp=(TextView)item.findViewById(R.id.expenseTXVNameExp);
            expenseHolder.txvamountExp=(TextView)item.findViewById(R.id.expenseTXVamount);
            expenseHolder.txvwhopaindExp=(TextView)item.findViewById(R.id.expenseTXVWhoPaid);
            expenseHolder.txvpriceperuserExp=(TextView)item.findViewById(R.id.expenseTXVPricePerUser);

        }
        else{
            expenseHolder=(ExpenseHolder)item.getTag();
        }

        expenseHolder.txvnameExp.setText(getItem(position).getName());
        expenseHolder.txvamountExp.setText(String.valueOf(getItem(position).getAmount()));
        expenseHolder.txvwhopaindExp.setText(getItem(position).getPaid().getName());
        expenseHolder.txvpriceperuserExp.setText(String.valueOf(getItem(position).getAmountPerUser()));

        return item;
    }

    class ExpenseHolder {
        TextView txvnameExp,txvamountExp,txvwhopaindExp,txvpriceperuserExp;
    }
}
