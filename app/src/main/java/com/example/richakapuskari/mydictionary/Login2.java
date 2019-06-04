package com.example.richakapuskari.mydictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login2 extends AppCompatActivity {

    Mydb db1;
    TextView tv1, tv2;
    EditText lblname2, lblpassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        db1 = new Mydb(getApplicationContext(), "user.db", null, 1);
        lblname2 = findViewById(R.id.txtname2);
        lblpassword2 = findViewById(R.id.txtpass2);
        tv1 = findViewById(R.id.txtforgot);
        tv2 = findViewById(R.id.txtregistergo);

    }

    public void goregister1(View v) {
        //Toast.makeText(getApplicationContext(),"hiiiiiii",Toast.LENGTH_LONG).show();
        Intent i = new Intent(Login2.this, Register.class);
        startActivity(i);
    }

    public void checklogin3(View v) {
        String username2 = lblname2.getText().toString();
        String password2 = lblpassword2.getText().toString();


        if (!username2.isEmpty() && !password2.isEmpty()) {
            int m = db1.checklogin(username2, password2);
            if (m == 1) {
                Toast.makeText(getApplicationContext(), "Loged in Succesfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login2.this, MainScreen.class);
                startActivity(i);
            } else {

                AlertDialog.Builder alert = new AlertDialog.Builder(Login2.this);
                alert.setTitle("Alert");
                alert.setMessage("Enter valid passward");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
            }

        } else if (!username2.isEmpty() && password2.isEmpty()) {
            AlertDialog.Builder alert = new AlertDialog.Builder(Login2.this);
            alert.setTitle("Alert");
            alert.setMessage("enter your passward");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        } else if (password2.isEmpty() && username2.isEmpty()) {
            AlertDialog.Builder alert = new AlertDialog.Builder(Login2.this);
            alert.setTitle("Alert");
            alert.setMessage("enter username and passward");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        } else if (username2.isEmpty()) {
            AlertDialog.Builder alert = new AlertDialog.Builder(Login2.this);
            alert.setTitle("Alert");
            alert.setMessage("enter username");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(Login2.this);
            alert.setTitle("Alert");
            alert.setMessage("enetr valid information");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                }
            });
            alert.show();
        }
    }

    public void forgotpass(View v) {

        String username1 = lblname2.getText().toString();
        if (!username1.isEmpty()) {

            Intent i2 = new Intent(Login2.this, forgotpassward1.class);
            i2.putExtra("txtname", username1);
            System.out.print("myyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy "+username1);
            startActivity(i2);

        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(Login2.this);
            alert.setTitle("Alert");
            alert.setMessage("enetr username");
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                }
            });
            alert.show();
        }
    }
}
