package com.example.aplicaciones_moviles1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

public class Stores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        TableRow clicStore = (TableRow )findViewById(R.id.clicStore);
        Button btnProducts = (Button) findViewById(R.id.btnProducts);
        Button btnCar = (Button) findViewById(R.id.btnCar);

        clicStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStore();
            }
        });
        btnProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opeProducts();
            }
        });
        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opeCar();
            }
        });
    }
    public void openStore(){
        Intent intent = new Intent(this, Store.class);
        startActivity(intent);
    }
    public void opeProducts(){
        Intent intent = new Intent(this, Products.class);
        startActivity(intent);
    }
    public void opeCar(){
        Intent intent = new Intent(this, Car.class);
        startActivity(intent);
    }
}
