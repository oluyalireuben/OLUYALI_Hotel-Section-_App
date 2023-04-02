package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ViewFoodDetails extends AppCompatActivity {
    EditText ed1, ed2;
    TextView tv;
    private Button btnAddToCart, btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_datails);

        tv = findViewById(R.id.textViewVFDTitle);
        ed1 = findViewById(R.id.editTextVFDFoodName);
        ed2 = findViewById(R.id.editTextVFDFoodPrice);
        btnAddToCart = findViewById(R.id.buttonVFDAddToCart);
        btnBack = findViewById(R.id.buttonVFDBack);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String foodname = it.getStringExtra("text2");
        String price = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(foodname);
        ed2.setText("Price" + " " + price + "/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewFoodDetails.this, FoodDetailsActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {   SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username","").toString();
                String product = ed1.getText().toString();
                //float price = Float.parseFloat(it.getStringExtra("text5").toString());

                Database db = new Database(getApplicationContext(),"hotel",null,1);
                if (db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(), "Product Already added to Cart", Toast.LENGTH_SHORT).show();
                }else{
                    db.addCart(username,product,"Food");
                    Toast.makeText(getApplicationContext(), "Record successfully added to Cart", Toast.LENGTH_SHORT).show();
                    startActivity( new Intent(ViewFoodDetails.this, FoodDetailsActivity.class));
                }
            }
            });
    }
}