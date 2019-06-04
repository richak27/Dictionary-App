package com.example.richakapuskari.mydictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class DisplayActivity extends AppCompatActivity {
    ListView lv;
    WordData db2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        lv = findViewById(R.id.txtlv);
        db2 = new WordData(getApplicationContext(), "wordtable.db", null, 1);
        Disp();
    }


    public void Disp(){
        ArrayList al = db2.showData();

        ArrayAdapter aa = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, al);

        lv.setAdapter(aa);



    }


}

