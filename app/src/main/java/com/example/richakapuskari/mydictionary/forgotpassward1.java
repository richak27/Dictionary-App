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
import android.widget.ImageView;
import android.widget.Toast;

public class forgotpassward1 extends AppCompatActivity {
    Mydb db;
    EditText lblnewpass,lblconpass;
    Button lblbutton2;
    ImageView i1,i2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassward1);

        button3=findViewById(R.id.button3);
        lblnewpass = findViewById(R.id.editText3);
        lblconpass = findViewById(R.id.editText4);
        i1=findViewById(R.id.imageView6);
        i2=findViewById(R.id.imageView8);
        db=new Mydb(getApplicationContext(),"user.db",null,1);
        lblbutton2=findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "MyData", Toast.LENGTH_SHORT).show();
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String value = extras.getString("txtname");
                    System.out.print("Valueeee "+value);

                }
                //Bundle extrass=getIntent().getExtras();
                String sessionId = getIntent().getStringExtra("txtname");
                System.out.print("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK  "+sessionId);
                if(sessionId!=null){
                    // String kkk=.getString("txtname");
                    System.out.print("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK  "+sessionId );
                }
            }

        });


    }

    public void submit(View v) {
        // Bundle b=new Bundle();
        //  b = this.getIntent().getExtras();
        //  String name = b.getString("txtname");
        String sessionId = getIntent().getStringExtra("txtname");
        Toast.makeText(getApplicationContext(),sessionId,Toast.LENGTH_LONG).show();
        int k=db.existuser(sessionId);

        String newpass = lblnewpass.getText().toString();
        String conpass = lblconpass.getText().toString();
        // SQLiteDatabase user = getWritableDatabase();
        if (conpass.equals(newpass)) {
            int p=db.updatepass(sessionId,conpass);
            if(p==1 && k==1){
                Toast.makeText(getApplicationContext(),"passward updated sucessfully",Toast.LENGTH_LONG).show();
            }
            else if(k==0){
                AlertDialog.Builder alert=new AlertDialog.Builder(getApplicationContext());
                alert.setTitle("Alert");
                alert.setMessage("User not exist!!");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(),"yes button is clicked",Toast.LENGTH_LONG).show();

                    }
                });
                alert.show();
            }
            else{
                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
            }
            //String query = "upadate register set password ='" + conpass + "'";
            // user.execSQL(query);
        }
        else if(!conpass.equals(newpass)){
            AlertDialog.Builder alert=new AlertDialog.Builder(getApplicationContext());
            alert.setTitle("Alert");
            alert.setMessage("Passwords are not matching");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Toast.makeText(getApplicationContext(),"yes button is clicked",Toast.LENGTH_LONG).show();

                }
            });
            alert.show();

        }
        else{
            if (newpass.isEmpty() && conpass.isEmpty()){
                AlertDialog.Builder alert=new AlertDialog.Builder(getApplicationContext());
                alert.setTitle("Alert");
                alert.setMessage("Please enter new password and confirm it");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(),"yes button is clicked",Toast.LENGTH_LONG).show();

                    }
                });
                alert.show();
            }
            else if (newpass.isEmpty()){
                AlertDialog.Builder alert=new AlertDialog.Builder(getApplicationContext());
                alert.setTitle("Alert");
                alert.setMessage("Please enter new password");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(),"yes button is clicked",Toast.LENGTH_LONG).show();

                    }
                });
                alert.show();
            }
            else if(conpass.isEmpty()){
                AlertDialog.Builder alert=new AlertDialog.Builder(getApplicationContext());
                alert.setTitle("Alert");
                alert.setMessage("Please confirm the password");

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(),"yes button is clicked",Toast.LENGTH_LONG).show();

                    }
                });
                alert.show();
            }


        }
    }
}

