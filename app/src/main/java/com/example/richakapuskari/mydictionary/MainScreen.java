package com.example.richakapuskari.mydictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import java.util.ArrayList;
import java.util.Locale;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;
public class MainScreen extends AppCompatActivity {

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    EditText voiceInput;
    TextToSpeech t;
    TextView t1, t2, t3, t4;
    ImageView addim, updateim, displayim;
    Button search;
    ImageView mSpeakBtn;
    ImageView mic;
    WordData db;
    AutoCompleteTextView mVoiceInputTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);


        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.tv2);
        search=findViewById(R.id.buttons);
        voiceInput=findViewById(R.id.voiceInput);
        addim = findViewById(R.id.imadd);
        updateim = findViewById(R.id.imupdate);
        displayim = findViewById(R.id.imdisplay);
        mic=findViewById(R.id.btnloud);
        mSpeakBtn=findViewById(R.id.btnspeak);
        mVoiceInputTv = findViewById(R.id.voiceInput);
        db = new WordData(getApplicationContext(), "wordtable.db", null, 1);
        voiceInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wd=mVoiceInputTv.getText().toString();
                String meaningdisp=db.searchMethod(wd);
                t4.setText(meaningdisp);


            }
        });



        mSpeakBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startVoiceInput();
            }
        });

        t=new TextToSpeech(this,new TextToSpeech.OnInitListener() {

            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t.setLanguage(Locale.UK);
                }
            }
        });
    }


    public void btn(View v){
        t.speak(mVoiceInputTv.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }


    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hello, How can I help you?");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mVoiceInputTv.setText(result.get(0));
                    String m2=mVoiceInputTv.getText().toString();
                    db.searchMethod(m2);
                }
                break;
            }

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Log out");
        menu.add("Exit");

        return super.onCreateOptionsMenu(menu);
    }

    public void updateClick(View v){
        Intent i=new Intent(getApplicationContext(),UpdateActivity.class);
        startActivity(i);
    }

    public void adddata(View v){

        Intent j=new Intent(getApplicationContext(),InsertData.class);
        startActivity(j);

    }

    public  void searchData(View v){
        String word1=mVoiceInputTv.getText().toString();
        String m=db.searchMethod(word1);
        t4.setText(m);

    }

    public void displayall(View v)
    {
        Intent i=new Intent(getApplicationContext(),DisplayActivity.class);
        startActivity(i);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getApplicationContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
        if (item.getTitle().toString().equals("Exit"))
        {
            Intent j=new Intent(MainScreen.this,MainActivity.class);
            startActivity(j);
        }

        if (item.getTitle().toString().equals("Log out")) finish();
        {
            Intent i = new Intent(MainScreen.this, Login2.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);

    }

}
