package com.jtsw.sharedfloor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jtsw.sharedfloor.adapter.PurchaseAdapter;
import com.jtsw.sharedfloor.adapter.TypeItemAdapter;
import com.jtsw.sharedfloor.model.PurchaseItem;
import com.jtsw.sharedfloor.model.TypeItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AddItem_activity extends AppCompatActivity {

    Spinner spinner;
    EditText edtName;

    private TypeItemAdapter typeItemAdapter;
    ArrayAdapter<CharSequence> adapterForSpiner;
    List typesNames;

    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_activity);

        i= getIntent();

        typeItemAdapter=new TypeItemAdapter(this);
        typesNames= new ArrayList();

        populateAdapter();
        adapterForSpiner= new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,typesNames);


        spinner=(Spinner)findViewById(R.id.additemSPNtypeelement);
        edtName=(EditText)findViewById(R.id.additemEDTname);

        spinner.setAdapter(adapterForSpiner);

    }
    private void populateAdapter(){
        for (TypeItem item : typeItemAdapter.getAll()){
            typesNames.add(item.getNameType());
        }
    }

    public void clickAdd(View v){

        if(edtName.getText().toString().trim().length()>0){
            PurchaseItem p=new PurchaseItem(edtName.getText().toString(),new TypeItem(spinner.getSelectedItem().toString()));
            i.putExtra("element",p);
            setResult(RESULT_OK,i);
            finish();
        }
        else{
            Toast.makeText(this,R.string.no_item_name,Toast.LENGTH_LONG).show();
        }
    }
}
