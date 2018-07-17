package com.example.x.ultrapskafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Anasayfa extends AppCompatActivity {

    Button toMasalar;
    Button toKayıtlar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        toMasalar  = (Button) findViewById(R.id.toMain);
        toKayıtlar = (Button) findViewById(R.id.toKayitlar);

        toMasalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMasalar = new Intent(Anasayfa.this,MainActivity.class);
                startActivity(toMasalar);
            }
        });


    }
}
