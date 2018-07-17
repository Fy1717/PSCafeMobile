package com.example.x.ultrapskafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText UserName,Password ;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login =(Button) findViewById(R.id.loginButton);
        UserName=(EditText) findViewById(R.id.username);
        Password=(EditText) findViewById(R.id.password);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UserName == null || Password == null || UserName.getText().toString().isEmpty() || Password.getText().toString().isEmpty() ){
                    Toast.makeText(getApplicationContext(),"Lütfen  Boş Alanları Doldurun",Toast.LENGTH_SHORT).show();
                }

                if (UserName.getText().toString().equals("a") || Password.getText().toString().equals("a")){
                    Intent i = new Intent(Login.this,Anasayfa.class);
                    startActivity(i);
                }

                else{
                    Toast.makeText(getApplicationContext(),"Yanlış Bilgi Girdiniz!",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
