package com.example.richakapuskari.mydictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity {

    EditText lblname,lblphone,lblusername,lblpassward,lblconpassward;
    Mydb db;
    ImageView i1,i2,i3,i4,i5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        lblname=findViewById(R.id.txtname);
        lblphone=findViewById(R.id.txtphone);
        lblusername=findViewById(R.id.txtusername);
        lblpassward=findViewById(R.id.txtpassward);
        lblconpassward=findViewById(R.id.txtconpassward);
        i1=findViewById(R.id.imageView7);
        i2=findViewById(R.id.imageView23);
        i3=findViewById(R.id.imageView9);
        i4=findViewById(R.id.imageView13);
        i5=findViewById(R.id.imageView5);

        // lv=findViewById(R.id.T);
        db=new Mydb(getApplicationContext(),"user.db",null,1);
    }

    public void registerclick1(View v){
        String name=lblname.getText().toString();
        String phone=lblphone.getText().toString();
        String username=lblusername.getText().toString();
        String passward=lblpassward.getText().toString();
        String conpassward=lblconpassward.getText().toString();


        int ch=db.existuser(username);

        if(!name.isEmpty() && !username.isEmpty() && !phone.isEmpty() && !passward.isEmpty() ){
            if(ch==0){


                if(passward.equals(conpassward)) {
                    db.insertdata(name, phone, username, passward, conpassward);
                    Intent i = new Intent(Register.this,MainScreen.class);
                    startActivity(i);

                    //sToast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_LONG).show();

                }
                else {
                    AlertDialog.Builder alert=new AlertDialog.Builder(Register.this);
                    alert.setTitle("Alert");
                    alert.setMessage("passward is not matching");
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Toast.makeText(getApplicationContext(),"yes button is clicked",Toast.LENGTH_LONG).show();

                        }
                    });
                    alert.show();
                }}
            else if(ch==1){

                AlertDialog.Builder alert=new AlertDialog.Builder(Register.this);
                alert.setTitle("Alert");
                alert.setMessage("Username already exist");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Toast.makeText(getApplicationContext(),"yes button is clicked",Toast.LENGTH_LONG).show();

                    }
                });
                alert.show();
            }
        }
        else {
            if(name.isEmpty() || phone.isEmpty() || username.isEmpty()|| passward.isEmpty() || conpassward.isEmpty()){
                AlertDialog.Builder alert=new AlertDialog.Builder(Register.this);
                alert.setTitle("Alert");
                alert.setMessage("Please enter All required information");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Toast.makeText(getApplicationContext(),"yes button is clicked",Toast.LENGTH_LONG).show();

                    }
                });
                alert.show();
            }

        }

    }
}
