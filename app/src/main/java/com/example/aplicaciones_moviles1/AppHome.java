package com.example.aplicaciones_moviles1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class AppHome extends AppCompatActivity {
    Button btnLogin, btnSignUp, btnCredits, btnInstructions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnCredits = (Button) findViewById(R.id.btnCredits);
        btnInstructions = (Button) findViewById(R.id.btnInstructions);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });
        btnCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCredits();
            }
        });
        btnInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstructions();
            }
        });

    }

    public void openLogin(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
    public void openSignUp(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
    public void openCredits(){
        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
    }
    public void openInstructions(){
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
    }
}
