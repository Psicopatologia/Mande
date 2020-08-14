package com.example.aplicaciones_moviles1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;

public class Store extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        LinearLayout clicProduct = (LinearLayout )findViewById(R.id.clicProduct);
        Button btnClose = (Button) findViewById(R.id.btnClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        clicProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProduct();
            }
        });
    }
    public void openProduct(){
        Intent intent = new Intent(this, Product.class);
        startActivity(intent);
    }
}
