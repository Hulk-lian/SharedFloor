package com.jtsw.sharedfloor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jtsw.sharedfloor.ApplicationsTests.TypeItem_list;
import com.jtsw.sharedfloor.R;
import com.jtsw.sharedfloor.model.TypeItem;

import java.util.List;

public class TypeItemAdapter extends ArrayAdapter<TypeItem> {

    Context context;
    List<TypeItem> typeItemList=TypeItem_list.getInstance();
    public TypeItemAdapter(Context context) {
        super(context, R.layout.type_item_item, TypeItem_list.getInstance());

        this.context=context;
    }

    public String getTypeNameAt(int position){
        return typeItemList.get(position).getNameType();
    }
    public List<TypeItem> getAll(){
        return typeItemList;
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

            purchaseHolder.txvTypeName=(TextView) item.findViewById(R.id.purchaseItemTXVtypeelement);

            item.setTag(purchaseHolder);
        } else {

            purchaseHolder=(PurchaseHolder)item.getTag();
        }

        purchaseHolder.txvTypeName.setText(getItem(position).getNameType());

        return item;
    }
    class PurchaseHolder {
        TextView txvTypeName;
    }

}
