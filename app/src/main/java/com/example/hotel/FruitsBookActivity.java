package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FruitsBookActivity extends AppCompatActivity {
    EditText edname, edaddress, edpincode,  edcontact;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits_book);

        edname = findViewById(R.id.editTextFBFullNames);
        edaddress = findViewById(R.id.editTextFBAddress);
        edpincode = findViewById(R.id.editTextFBPinCode);
        edcontact = findViewById(R.id.editTextFBPhoneNumber);
        btnOrder = findViewById(R.id.buttonFBOrder);

        Intent intent=getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String time  = intent.getStringExtra("time");

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(),"hotel",null,1);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(),Integer.parseInt(edpincode.getText().toString()),time.toString(),time.toString(),Float.parseFloat(price[1].toString()),"Fruit");
                db.removeCart(username,"Fruit");
                Toast.makeText(getApplicationContext(), "You have successfully ordered", Toast.LENGTH_SHORT).show();
                startActivity( new Intent(FruitsBookActivity.this, HotelActivity.class));
            }
        });

    }
}