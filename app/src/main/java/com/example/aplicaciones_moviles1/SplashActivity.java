package com.example.aplicaciones_moviles1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import Controller.Owner;
import Controller.Product;
import Controller.Store;
import Controller.User;
import utils.DataBaseMande;

public class SplashActivity extends AppCompatActivity {
    private static int TIME_OUT = 3000; //Time to launch the another activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        DataBaseMande db = new DataBaseMande(this);
        User u = new User();
        u.setEmail("admin");
        u.setName("admin");
        u.setPassword("admin");
        db.addUser(u);
        db.addStore(new Store(0,"tienda",0));
        db.addProduct(new Product(0, 0, 10000, 10, "papitas", "comestible, perfecto para comer"));
        db.addProduct(new Product(1, 0, 20000, 100, "chocolatina", "comestible de chocolate, perfecto para comer"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
}
