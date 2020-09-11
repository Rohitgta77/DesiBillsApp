package com.example.desiparcha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        ArrayList<ItemsDetails> arrayList =(ArrayList<ItemsDetails>) getIntent().getSerializableExtra("data");

        int itemsCount=arrayList.size();
        for(int i=0; i<itemsCount; i++){
            String itemsName = arrayList.get(i).getItemsName();
            String rate = String.valueOf(arrayList.get(i).getRate());
            ArrayList itemsWeight =arrayList.get(i).getItemsWeight();
            ArrayList packageWeight =arrayList.get(i).getPackageWeight();
            ArrayList<String> array = new ArrayList<String>();
            array.add(itemsName);
            array.add(rate);
            for (int j=0; j<itemsWeight.size(); j++){
                array.add(String.valueOf(itemsWeight.get(j)));
            }
            for (int k=0; k<packageWeight.size();k++){
                array.add(String.valueOf(packageWeight.get(k)));
            }
            LinearLayout linearLayout =new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            setContentView(linearLayout);

            for(int m=0; m<array.size(); m++){
                TextView textView=new TextView(this);
                textView.setText(array.get(m));
                linearLayout.addView(textView);
            }
        }








    }
}