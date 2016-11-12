package com.jtsw.sharedfloor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jtsw.sharedfloor.ApplicationsTests.Purchase_list_elements;
import com.jtsw.sharedfloor.R;
import com.jtsw.sharedfloor.model.PurchaseItem;
import com.jtsw.sharedfloor.model.TypeItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PurchaseAdapter extends ArrayAdapter<PurchaseItem> implements Comparable{

    public static final int SORTBYNAME=0;
    public static final int SORTBYTYPE=1;
    boolean cambioNombre=false;
    Context context;
    List<PurchaseItem> shoppingList=Purchase_list_elements.getInstance();


    public PurchaseAdapter(Context context) {
        super(context, R.layout.expense_expense_item, Purchase_list_elements.getInstance());

        this.context=context;
    }

    public void sortBy(int type){
        switch (type){
            case SORTBYNAME:

                break;
            case SORTBYTYPE:
                Collections.sort(shoppingList,PurchaseItem.SORTBYTYPE);
                break;
        }
      //  notifyDataSetChanged();
    }
    public boolean addItem(PurchaseItem p){
        shoppingList.add(p);
       // notifyDataSetChanged();
        return true;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        PurchaseHolder purchaseHolder;
        if (item == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            item = inflater.inflate(R.layout.purchase_item, null);

            purchaseHolder = new PurchaseHolder();

            purchaseHolder.edtItemName = (EditText) item.findViewById(R.id.purchaseItemEDTelemtName);
            purchaseHolder.txvTypeName=(TextView)item.findViewById(R.id.purchaseItemTXVtypeelement);
            purchaseHolder.btnEditname = (Button) item.findViewById(R.id.purchaseItemBTNeditElement);

            item.setTag(purchaseHolder);
        } else {

            purchaseHolder=(PurchaseHolder)item.getTag();
        }
        purchaseHolder.edtItemName.setText(getItem(position).getName());
        purchaseHolder.edtItemName.setEnabled(cambioNombre);
        purchaseHolder.txvTypeName.setText(getItem(position).getType().getNameType());

        return item;
    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }

    class PurchaseHolder{
        EditText edtItemName;
        TextView txvTypeName;
        Button btnEditname;
    }
}
