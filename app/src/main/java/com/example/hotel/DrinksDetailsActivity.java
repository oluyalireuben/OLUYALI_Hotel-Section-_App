package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DrinksDetailsActivity extends AppCompatActivity {
    private String[][] Drinks_details1 =
            {
                    {"Flavor: Coca-Cola", "", "", "", "100"},
                    {"Flavor: Sprite", "", "", "", "100"},
                    {"Flavor: Fanta", "", "", "", "100"},
                    {"Flavor: Dr Pepper", "", "", "", "100"},
                    {"Flavor: Robot Beer", "", "", "", "100"},
                    {"Flavor: Diet Coke", "", "", "", "100"},
                    {"Flavor: Cream Soda", "", "", "", "100"},
                    {"Flavor: Cola", "", "", "", "100"},
                    {"Flavor: 7UP", "", "", "", "100"},
                    {"Flavor: Ginger Ale", "", "", "", "100"},
                    {"Flavor: Black Current", "", "", "", "100"},
                    {"Flavor: Pineapple", "", "", "", "100"},
                    {"Flavor: Passion", "", "", "", "100"},
                    {"Flavor: Krest", "", "", "", "100"},
                    {"Flavor: Mirinda", "", "", "", "100"},
                    {"Flavor: Pepsi", "", "", "", "100"},
                    {"Flavor: Stoney", "", "", "", "100"},
                    {"Flavor: Pibb Extra", "", "", "", "100"},
                    {"Flavor: Canada Dry", "", "", "", "100"},
                    {"Flavor: RC Cola", "", "", "", "100"},
                    {"Flavor: Crush", "", "", "", "100"},
            };
    private String[][] Drinks_details2 =
            {
                    {"Juice type: Watermelon Juice", "", "", "", "75"},
                    {"Juice type: Mango Juice", "", "", "", "75"},
                    {"Juice type: Pineapple Juice", "", "", "", "75"},
                    {"Juice type: Orange Juice", "", "", "", "75"},
                    {"Juice type: Grape Juice", "", "", "", "75"},
                    {"Juice type: Celery Juice", "", "", "", "75"},
                    {"Juice type: Carrot Orange Juice", "", "", "", "75"},
                    {"Juice type: Passion Juice", "", "", "", "75"},
                    {"Juice type: Mixed Fruit Juice", "", "", "", "75"},
                    {"Juice type: Ginger Juice", "", "", "", "75"},
                    {"Juice type: Grapes Juice", "", "", "", "75"},
                    {"Juice type: Citrus Juice", "", "", "", "75"},
                    {"Juice type: Carrot Pineapple Juice", "", "", "", "75"},
                    {"Juice type: Lemon Juice", "", "", "", "75"},
                    {"Juice type: Simple Green Juice", "", "", "", "75"},
                    {"Juice type: Avocado Juice", "", "", "", "75"},
                    {"Juice type: Banana Juice", "", "", "", "75"},
                    {"Juice type: Grapes Juice", "", "", "", "75"},
            };
    private String[][] Drinks_details3 =
            {
                    {"Milk Type: Soy Milk", "", "", "", "60"},
                    {"Milk Type: Almond Milk", "", "", "", "60"},
                    {"Milk Type: Rice Milk", "", "", "", "60"},
                    {"Milk Type: Coconut Milk", "", "", "", "60"},
                    {"Milk Type: Oat Milk", "", "", "", "60"},
                    {"Milk Type: Goat Milk", "", "", "", "60"},
                    {"Milk Type: Cashew Milk", "", "", "", "60"},
                    {"Milk Type: Whole Milk", "", "", "", "60"},
                    {"Milk Type: Skimmed Milk", "", "", "", "60"},
                    {"Milk Type: Condensed Milk", "", "", "", "60"},
                    {"Milk Type: Hemp Milk", "", "", "", "60"},
                    {"Milk Type: Evaporated Milk", "", "", "", "60"},
                    {"Milk Type: Raw Milk", "", "", "", "60"},
                    {"Milk Type: Cream Milk", "", "", "", "60"},
                    {"Milk Type: Plant Milk", "", "", "", "60"},
                    {"Milk Type: Organic Milk", "", "", "", "60"},
                    {"Milk Type: Flavoured Milk", "", "", "", "60"},
                    {"Milk Type: Pea Milk", "", "", "", "60"},
                    {"Milk Type: Butter Milk", "", "", "", "60"},
                    {"Milk Type: Powered Milk", "", "", "", "60"},
                    {"Milk Type: Sheep Milk", "", "", "", "60"},
                    {"Milk Type: Skim Milk", "", "", "", "60"},
                    {"Milk Type: Hazelnut Milk", "", "", "", "60"},
                    {"Milk Type: Camel Milk", "", "", "", "60"},
            };
    private String[][] Drinks_details4 =
            {
                    {"Energy Drink Type: Red Bull Energy Drink", "", "", "","200"},
                    {"Energy Drink Type: Monster Energy Zero Ultra", "", "", "","200"},
                    {"Energy Drink Type: Rockstar Energy Drink", "", "", "","200"},
                    {"Energy Drink Type: Predator Coffee Flavour", "", "", "","200"},
                    {"Energy Drink Type: Predator Mango Flavour", "", "", "","200"},
                    {"Energy Drink Type: Azam Energy Drink", "", "", "","200"},
                    {"Energy Drink Type: Zipfizz Healthy Energy Drink", "", "", "","200"},
                    {"Energy Drink Type: Mountain Dew Kickstart", "", "", "","200"},
                    {"Energy Drink Type: 3D Energy Drink", "", "", "","200"},
                    {"Energy Drink Type: VPS Redline Xtreme", "", "", "","200"},
                    {"Energy Drink Type: Starbucks Doubleshot Energy Drink", "", "", "","200"},
            };
    private String[][] Drinks_details5 =
            {
                    {"Water Name: Alpine Coolers", "", "", "", "70"},
                    {"Water Name: Highland Drinks", "", "", "", "70"},
                    {"Water Name: Aberdares Water", "", "", "", "70"},
                    {"Water Name: African Oasis Spring Water", "", "", "", "70"},
                    {"Water Name: Dasani", "", "", "", "70"},
                    {"Water Name: Njoro Cool Waters", "", "", "", "70"},
                    {"Water Name:Kabarnet Water", "", "", "", "70"},
                    {"Water Name: Aquamist", "", "", "", "70"},
                    {"Water Name: AquaPure", "", "", "", "70"},
                    {"Water Name: Keringet Pure Waters", "", "", "", "70"},
                    {"Water Name: Glacier Springs", "", "", "", "70"},
                    {"Water Name: Lake Victoria Springs Mineral water", "", "", "", "70"},
            };
    private String[][] Drinks_details6 =
            {
                    {"Liquor Name: Absolut Vodka", "", "", "", "350"},
                    {"Liquor Name: Smirnoff", "", "", "", "350"},
                    {"Liquor Name: Bacardi", "", "", "", "350"},
                    {"Liquor Name: Diageo", "", "", "", "350"},
                    {"Liquor Name: Johnnie Walker", "", "", "", "350"},
                    {"Liquor Name: SKYY Vodka", "", "", "", "350"},
                    {"Liquor Name: Guarana", "", "", "", "350"},
                    {"Liquor Name: Ciroc", "", "", "", "350"},
                    {"Liquor Name: Captain Morgan", "", "", "", "350"},
                    {"Liquor Name: Grey Goose", "", "", "", "350"},
                    {"Liquor Name: Chrome", "", "", "", "350"},
                    {"Liquor Name: Ketel One", "", "", "", "350"},
                    {"Liquor Name: Hennessy", "", "", "", "350"},
                    {"Liquor Name: Smart", "", "", "", "350"},
                    {"Liquor Name: Tusker", "", "", "", "350"},
                    {"Liquor Name: Balozi", "", "", "", "350"},
                    {"Liquor Name: Crown Royal", "", "", "", "350"},
                    {"Liquor Name: Pernod Ricard", "", "", "", "350"},
                    {"Liquor Name: Ballantines", "", "", "", "350"},
                    {"Liquor Name: Baileys", "", "", "", "350"},
                    {"Liquor Name: Patron", "", "", "", "350"},
            };

    TextView tv;
    Button btnBack, btnGoToCart;
    String[][] Drinks_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_details);

        tv = findViewById(R.id.textViewDDTitle);
        btnBack = findViewById(R.id.buttonDDBack);
        btnGoToCart = findViewById(R.id.buttonDDGoToCart);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Soda")==0)
            Drinks_details = Drinks_details1;
        else
        if (title.compareTo("Blended Juice")==0)
            Drinks_details = Drinks_details2;
        else
        if (title.compareTo("Milk")==0)
            Drinks_details = Drinks_details3;
        else
        if (title.compareTo("Energy Drinks")==0)
            Drinks_details = Drinks_details4;
        else
        if (title.compareTo("Mineral Water")==0)
            Drinks_details = Drinks_details5;
        else
            Drinks_details = Drinks_details6;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DrinksDetailsActivity.this, DrinksActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DrinksDetailsActivity.this, CartDrinksActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<Drinks_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", Drinks_details[i][0]);
            item.put("line2", Drinks_details[i][1]);
            item.put("line3", Drinks_details[i][2]);
            item.put("line4", Drinks_details[i][3]);
            item.put("line5", "Price "+" "+Drinks_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DrinksDetailsActivity.this,ViewDrinksDetails.class);
                it.putExtra("text1",title);
                it.putExtra("text2", Drinks_details[i][0]);
                it.putExtra("text3", Drinks_details[i][1]);
                it.putExtra("text4", Drinks_details[i][3]);
                it.putExtra("text5", Drinks_details[i][4]);
                startActivity(it);
            }
        });
    }
}