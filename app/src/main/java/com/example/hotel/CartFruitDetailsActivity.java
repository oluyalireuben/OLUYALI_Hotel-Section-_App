package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CartFruitDetailsActivity extends AppCompatActivity {
    EditText ed1, ed2;
    TextView tv;
    private Button btnAddToCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_fruit_details);

        tv = findViewById(R.id.textViewCFTitle);
        ed1 = findViewById(R.id.editTextFruitsName);
        ed2 = findViewById(R.id.editTextFruitPrice);
        btnAddToCart = findViewById(R.id.buttonCFAddToCart);
        btnBack = findViewById(R.id.buttonCFBack);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fruitname = it.getStringExtra("text2");
        String price = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fruitname);
        ed2.setText("Price" + " " + price + "/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartFruitDetailsActivity.this, FruitsActivity.class));
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
                    db.addCart(username,product,"Fruit");
                    Toast.makeText(getApplicationContext(), "Record successfully added to Cart", Toast.LENGTH_SHORT).show();
                    startActivity( new Intent(CartFruitDetailsActivity.this, FruitsActivity.class));
                }
            }
        });
    }
}