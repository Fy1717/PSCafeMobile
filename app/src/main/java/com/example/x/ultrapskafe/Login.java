package com.example.x.ultrapskafe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    EditText UserName, Password;
    Button Login;


    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        internetKontrol();
        getControlView();
        setClickForView();

    }


    private void getControlView() {

        Login = (Button) findViewById(R.id.loginButton);
        UserName = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);

    }


    private void setClickForView() {
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Giris();
            }
        });
    }

    public void Giris() {

        String UN = UserName.getText().toString();
        String PSW = Password.getText().toString();

        if (UserName == null || Password == null || UserName.getText().toString().isEmpty() || Password.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Lütfen  Boş Alanları Doldurun", Toast.LENGTH_SHORT).show();
        }

        if (UN.equals("sf") && PSW.equals("sf5874")) {

            Intent i = new Intent(Login.this, Anasayfa.class);
            startActivity(i);
        } else {
            Titret();
            Toast.makeText(getApplicationContext(), "Yanlış Bilgi Girdiniz!", Toast.LENGTH_SHORT).show();
        }
    }

    private void internetKontrol() {
        if (internetvarmi()) {
            Toast.makeText(getApplicationContext(), "Bağlantı Sağlandı", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bağlantınızı Kontrol Edin!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Titret() {
        Vibrator kiprasim = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        kiprasim.vibrate(300);
    }

    @SuppressLint("MissingPermission")
    public boolean internetvarmi() {

        ConnectivityManager conManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conManager.getActiveNetworkInfo() != null
                && conManager.getActiveNetworkInfo().isAvailable()
                && conManager.getActiveNetworkInfo().isConnected()) {

            return true;

        } else {
            return false;
        }

    }
}
