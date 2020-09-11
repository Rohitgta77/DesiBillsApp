package com.example.desiparcha;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout weightRegionLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        ImageView button = (ImageView) findViewById(R.id.add_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWeightView();
            }
        });
        Button btn = (Button) findViewById(R.id.btn_getParch);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParcha();
            }
        });
    }

    private void getParcha(){
        ArrayList<ItemsDetails> arrayList= new ArrayList<>();
        ItemsDetails itemsDetails =new ItemsDetails();
        boolean isValid =true;
        LinearLayout weightRegion =(LinearLayout) findViewById(R.id.weightRegion);
        int count = weightRegion.getChildCount();
        if (count==0) {
            Toast.makeText(MainActivity.this,"Please add some Items's weight",Toast.LENGTH_SHORT).show();
            return;
        }
        EditText et1 = (EditText) findViewById(R.id.etItemsName);
        EditText et2 = (EditText) findViewById(R.id.etRate);
        String itemName =et1.getText().toString();
        String rate =et2.getText().toString();
        if (TextUtils.isEmpty(itemName)){
            et1.requestFocus();
            et1.setError("Please Enter Item Name");
            isValid=false;
        }
        else {
            itemsDetails.setItemsName(itemName);
        }
        if (TextUtils.isEmpty(rate)){
            et2.requestFocus();
            et2.setError("Please enter Rate");
            isValid=false;
        }
        else {
            itemsDetails.setRate(Float.parseFloat(rate));
        }

        for (int i=0; i<count; i++){
            LinearLayout add_weight_ll =(LinearLayout) weightRegion.getChildAt(i);
            EditText e1 =(EditText) add_weight_ll.getChildAt(0);
            EditText e2 = (EditText) add_weight_ll.getChildAt(1);
            String itemsWeight =e1.getText().toString();
            String packageWeight = e2.getText().toString();
            if (TextUtils.isEmpty(itemsWeight)){
                e1.requestFocus();
                e1.setError("Please Fill up");
                isValid =false;
            }
            else{
                itemsDetails.setItemsWeight(Float.parseFloat(itemsWeight));
            }
            if (TextUtils.isEmpty(packageWeight)){
                e2.requestFocus();
                e2.setError("Please fill up");
                isValid=false;
            }
            else {
                itemsDetails.setPackageWeight(Float.parseFloat(packageWeight));
            }
        }
        if (isValid){
            arrayList.add(itemsDetails);
            startOutputActivity(arrayList);
        }
        else{
            Toast.makeText(MainActivity.this,"Not vaild",Toast.LENGTH_SHORT);
            return;
        }
    }
    private void startOutputActivity(ArrayList<ItemsDetails> arrayList) {
        Intent intent = new Intent(  this, OutputActivity.class);
        intent.putExtra("data", arrayList);
        startActivity(intent);
    }


    private void addWeightView(){
        final View weightView =getLayoutInflater().inflate(R.layout.add_weight_layout,null,false);
        weightRegionLinearLayout =(LinearLayout) findViewById(R.id.weightRegion);
        weightRegionLinearLayout.addView(weightView);
        ImageView deleteIcon = (ImageView) weightView.findViewById(R.id.del);
        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightRegionLinearLayout.removeView(weightView);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}