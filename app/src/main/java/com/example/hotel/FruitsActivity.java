package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class FruitsActivity extends AppCompatActivity {
    private String[][] Fruit_details1 =
            {
                    {"Fruit name: Apple", "", "", "","25"},
                    {"Fruit name: Grape", "", "", "","40"},
                    {"Fruit name: Mango", "", "", "","30"},
                    {"Fruit name: Drupe", "", "", "","60"},
                    {"Fruit name: Orange", "", "", "","30"},
                    {"Fruit name: Banana", "", "", "","15"},
                    {"Fruit name: Avocado", "", "", "","35"},
                    {"Fruit name: Plum", "", "", "","35"},
                    {"Fruit name: Kiwi", "", "", "","45"},
                    {"Fruit name: Strawberry", "", "", "","60"},
                    {"Fruit name: Pineapple", "", "", "","40"},
                    {"Fruit name: Berry", "", "", "","100"},
                    {"Fruit name: Grapefruit", "", "", "","110"},
                    {"Fruit name: Apricot", "", "", "","90"},
                    {"Fruit name: Peach", "", "", "","80"},
                    {"Fruit name: Pome", "", "", "","70"},
                    {"Fruit name: Watermelon", "", "", "","30"},
                    {"Fruit name: Lemon", "", "", "","10"},
                    {"Fruit name: Papaya", "", "", "","25"},
                    {"Fruit name: Blueberry", "", "", "","55"},
                    {"Fruit name: Aggregate Fruit", "", "", "","60"},
                    {"Fruit name: Tomates", "", "", "","40"},
                    {"Fruit name: Guava", "", "", "","25"},
            };
    TextView tv;
    Button btnBack,btnGoToCart;
    String[][] Fruit_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        tv = findViewById(R.id.textViewTitleFruits);
        btnBack = findViewById(R.id.buttonFruitBack);
        btnGoToCart = findViewById(R.id.buttonFruitGoToCart);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Fruits") == 0)
            Fruit_details = Fruit_details1;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FruitsActivity.this, HotelActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FruitsActivity.this, OrderFruitsActivity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i < Fruit_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", Fruit_details[i][0]);
            item.put("line2", Fruit_details[i][1]);
            item.put("line3", Fruit_details[i][2]);
            item.put("line4", Fruit_details[i][3]);
            item.put("line5", "Price " + " " + Fruit_details[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewFruits);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(FruitsActivity.this, CartFruitDetailsActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2", Fruit_details[i][0]);
                it.putExtra("text5", Fruit_details[i][4]);
                startActivity(it);
            }
        });
    }
}
