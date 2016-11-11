package com.jtsw.sharedfloor.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.jtsw.sharedfloor.ApplicationsTests.Purchase_list_elements;
import com.jtsw.sharedfloor.R;
import com.jtsw.sharedfloor.model.PurchaseItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchaseAdapter extends ArrayAdapter<PurchaseItem> {

    Context context;
    List<PurchaseItem> shoppingList;


    public PurchaseAdapter(Context context) {
        super(context, R.layout.expense_expense_item, Purchase_list_elements.getShoppingList());
        this.context=context;
    }

    public void order(int orderType){
        //por ahora solo esta ordenado por cantidad(amount)
        switch (orderType){
            case 1:
                Collections.sort(shoppingList,PurchaseItem.SORTBYNAME);
                break;
            case 2:
                Collections.sort(shoppingList,PurchaseItem.SORTBYTYPE);
                break;
        }
        notifyDataSetChanged();
    }


}
