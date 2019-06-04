package com.example.richakapuskari.mydictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateActivity extends AppCompatActivity {
    EditText w3,m3;
    Button up1;
    WordData db3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        w3=findViewById(R.id.tw);
        m3=findViewById(R.id.tm);
        up1=findViewById(R.id.updatebt);
        db3=new WordData(getApplicationContext(),"wordtable.db",null,1);
    }

    public void onUpdateClick(View v){
        String w=w3.getText().toString();
        String m=m3.getText().toString();

        if(w.isEmpty() && m.isEmpty())
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(UpdateActivity.this);
            alert.setTitle("Alert");
            alert.setMessage("Enter all entries ");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }

            });
            alert.show();
        }
        else if(!w.isEmpty() && !m.isEmpty()){

            db3.update1(w,m);
            Toast.makeText(getApplicationContext(),"Updated successfully in database",Toast.LENGTH_SHORT).show();

        }
        else {

            AlertDialog.Builder alert=new AlertDialog.Builder(UpdateActivity.this);
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




    public void searchclick(View v){
        //String w=w3.getText().toString();
        //db3.sear

    }
}
