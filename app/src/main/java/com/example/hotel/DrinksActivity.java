package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        CardView DSoda = findViewById(R.id.cardDSoda);
        DSoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DrinksActivity.this, DrinksDetailsActivity.class);
                it.putExtra("title", "Soda");
                startActivity(it);
            }
        });
        CardView DBlendedJuice = findViewById(R.id.cardDBlendedJuice);
        DBlendedJuice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DrinksActivity.this, DrinksDetailsActivity.class);
                it.putExtra("title", "Blended Juice");
                startActivity(it);
            }
        });
        CardView DMilk = findViewById(R.id.cardDMilk);
        DMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DrinksActivity.this, DrinksDetailsActivity.class);
                it.putExtra("title", "Milk");
                startActivity(it);
            }
        });
        CardView DEnergyDrinks = findViewById(R.id.cardDEnergyDrink);
        DEnergyDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DrinksActivity.this, DrinksDetailsActivity.class);
                it.putExtra("title", "Energy Drinks");
                startActivity(it);
            }
        });
        CardView DMineralWater = findViewById(R.id.cardDMineralWater);
        DMineralWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DrinksActivity.this, DrinksDetailsActivity.class);
                it.putExtra("title", "Mineral Water");
                startActivity(it);
            }
        });
        CardView DLiquors = findViewById(R.id.cardDLiquors);
        DLiquors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DrinksActivity.this, DrinksDetailsActivity.class);
                it.putExtra("title", "Liquors");
                startActivity(it);
            }
        });
        CardView Dexit = findViewById(R.id.cardDBack);
        Dexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DrinksActivity.this, HotelActivity.class));
            }
        });
    }
}