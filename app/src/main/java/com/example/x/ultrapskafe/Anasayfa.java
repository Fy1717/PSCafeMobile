package com.example.x.ultrapskafe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Anasayfa extends AppCompatActivity {



    Button toMasalar;
    Button toKayıtlar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        getControlView();
        setClickForView();


    }

    private void getControlView() {


        toMasalar  = (Button) findViewById(R.id.toMain);
        toKayıtlar = (Button) findViewById(R.id.toKayitlar);
    }

    private void setClickForView(){


        toMasalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMasalar = new Intent(Anasayfa.this,MainActivity.class);
                startActivity(toMasalar);
            }
        });


        toKayıtlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toKayıtlar = new Intent(Anasayfa.this,Kayitlar.class);
                startActivity(toKayıtlar);
            }
        });
    }


}
