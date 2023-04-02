package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_room);

        CardView exit = findViewById(R.id.cardFRBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindRoomActivity.this, HomeActivity.class));
            }
        });
        CardView SingleRoom = findViewById(R.id.cardFRSingleRoom);
        SingleRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindRoomActivity.this, RoomDetailsActivity.class);
                it.putExtra("title", "Single Room");
                startActivity(it);
            }
        });
        CardView DoubleRoom = findViewById(R.id.cardFRDoubleRoom);
        DoubleRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindRoomActivity.this, RoomDetailsActivity.class);
                it.putExtra("title", "Double Room");
                startActivity(it);
            }
        });
        CardView SRWithShower = findViewById(R.id.cardFRSRWithShower);
        SRWithShower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindRoomActivity.this, RoomDetailsActivity.class);
                it.putExtra("title", "Single Room with Shower");
                startActivity(it);
            }
        });
        CardView DRWithShower = findViewById(R.id.cardFRDRWithShower);
        DRWithShower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindRoomActivity.this, RoomDetailsActivity.class);
                it.putExtra("title", "Double Room with Shower");
                startActivity(it);
            }
        });
    }
}