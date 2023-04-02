package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodActivity extends AppCompatActivity {
Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        CardView breakfast = findViewById(R.id.cardFoodBreakfast);
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FoodActivity.this, FoodDetailsActivity.class);
                it.putExtra("title", "Breakfast");
                startActivity(it);
            }
        });
        CardView food = findViewById(R.id.cardFoodFood);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FoodActivity.this, FoodDetailsActivity.class);
                it.putExtra("title", "Food");
                startActivity(it);
            }
        });
        CardView exit = findViewById(R.id.cardFoodBack);
        exit .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodActivity.this, HotelActivity.class));
            }
        });
    }
}