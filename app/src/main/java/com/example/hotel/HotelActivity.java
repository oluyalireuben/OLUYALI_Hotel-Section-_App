package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);


        CardView FindRoom = findViewById(R.id.cardFindRoom);
        FindRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HotelActivity.this, FindRoomActivity.class);
                it.putExtra("title", "Find Room");
                startActivity(it);
            }
        });
        CardView Food = findViewById(R.id.cardFood);
        Food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HotelActivity.this, FoodActivity.class);
                it.putExtra("title", "Food");
                startActivity(it);
            }
        });

        CardView Fruits = findViewById(R.id.cardFruits);
        Fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HotelActivity.this, FruitsActivity.class);
                it.putExtra("title", "Fruits");
                startActivity(it);
            }
        });

        CardView Drinks = findViewById(R.id.cardDrinks);
        Drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HotelActivity.this, DrinksActivity.class);
                it.putExtra("title", "Drinks");
                startActivity(it);
            }
        });
        CardView orderDetails = findViewById(R.id.cardOrderDetails);
        orderDetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotelActivity.this, OrderDetails.class));
            }
        });
    }
}