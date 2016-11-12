package com.jtsw.sharedfloor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.jtsw.sharedfloor.adapter.TypeItemAdapter;

public class ListTypeElement extends AppCompatActivity {

   private TypeItemAdapter typeItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_type_element);

        ListView typeItemList=(ListView)findViewById(R.id.listtypeElement_listview);
        typeItemAdapter= new TypeItemAdapter(this);
        typeItemList.setAdapter(typeItemAdapter);
    }
}
