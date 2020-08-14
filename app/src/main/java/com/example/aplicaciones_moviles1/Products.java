package com.example.aplicaciones_moviles1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        LinearLayout clicProduct = (LinearLayout )findViewById(R.id.clicProduct);
        Button btnStores = (Button) findViewById(R.id.btnStores);
        Button btnCar = (Button) findViewById(R.id.btnCar);
        clicProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProduct();
            }
        });
        btnStores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStores();
            }
        });
        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opeCar();
            }
        });
    }
    public void openProduct(){
        Intent intent = new Intent(this, Product.class);
        startActivity(intent);
    }
    public void openStores(){
        Intent intent = new Intent(this, Stores.class);
        startActivity(intent);
    }
    public void opeCar(){
        Intent intent = new Intent(this, Car.class);
        startActivity(intent);
    }
}
