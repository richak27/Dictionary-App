package com.example.richakapuskari.mydictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class InsertData extends AppCompatActivity {
    Button insertb;
    EditText w1,m1;
    WordData db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        insertb=findViewById(R.id.txtin);
        w1=findViewById(R.id.txtword);
        m1=findViewById(R.id.txtmeaning);
        db1=new WordData(getApplicationContext(),"wordtable.db",null,1);
    }

    public void InsertC(View v)
    {
        String w=w1.getText().toString();
        String m=m1.getText().toString();

        if(w.isEmpty() && m.isEmpty())
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(InsertData.this);
            alert.setTitle("Alert");
            alert.setMessage("Enter all entries ");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }

            });
            alert.show();
        }
        else if(!w.isEmpty() && !m.isEmpty())
        {        db1.insertData(w,m);

            Toast.makeText(getApplicationContext(),"Added in database",Toast.LENGTH_SHORT).show();
        }
        else {
            AlertDialog.Builder alert=new AlertDialog.Builder(InsertData.this);
            alert.setTitle("Alert");
            alert.setMessage("Enter all entries ");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }

            });
            alert.show();
        }

    }

}
