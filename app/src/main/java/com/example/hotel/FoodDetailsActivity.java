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

public class FoodDetailsActivity extends AppCompatActivity {
    private String[][] Food_details1 =
            {
                    {"Breakfast Type: Mandazi","","","","30"},
                    {"Food Type: Chapati","","","","30"},
                    {"Food Type: Brown Chapati","","","","50"},
                    {"Breakfast Type: Omelette","","","","300"},
                    {"Breakfast Type: Egg","","","","200"},
                    {"Breakfast Type: Pancake","","","","230"},
                    {"Breakfast Type: French Toast","","","","330"},
                    {"Breakfast Type: English Breakfast","","","","350"},
                    {"Breakfast Type: Porridge","","","","200"},
                    {"Breakfast Type: Waffles","","","","230"},
                    {"Breakfast Type: Breakfast Burrito","","","","250"},
                    {"Breakfast Type: Scrambled Eggs","","","","300"},
                    {"Breakfast Type: Egg Benedict","","","","310"},
                    {"Breakfast Type: Granola","","","","250"},
                    {"Breakfast Type: Muffins","","","","280"},
                    {"Breakfast Type: Yogurt","","","","200"},
                    {"Breakfast Type: Breakfast Sandwich","","","","205"},
                    {"Breakfast Type: Bagels","","","","190"},
                    {"Breakfast Type: Continental Breakfast","","","","420"},
                    {"Breakfast Type: Cereal","","","","190"},
                    {"Breakfast Type: Frittata","","","","150"},
                    {"Breakfast Type: Muesli","","","","430"},
                    {"Breakfast Type: Hash Brown","","","","450"},
                    {"Breakfast Type: Upma","","","","300"},
                    {"Breakfast Type: Avocado Toast","","","","350"},
                    {"Breakfast Type: Croissant","","","","310"},
                    {"Breakfast Type: Oatmeal","","","","280"},
            };
    private String[][] Food_details2 =
            {
                    {"Food Type: Chapati","","","","30"},
                    {"Food Type: Brown Chapati","","","","50"},
                    {"Food Type: Chips","","","","250"},
                    {"Food Type: Chips Kuku","","","","600"},
                    {"Food Type: Ugali Kuku","","","","250"},
                    {"Food Type: Nyoma Choma","","","","450"},
                    {"Food Type: Managu","","","","180"},
                    {"Food Type: Wet Fry","","","","340"},
                    {"Food Type: Fish","","","","250"},
                    {"Food Type: Mboga","","","","40"},
                    {"Food Type: Ugali Plain","","","","60"},
                    {"Food Type: Githeri","","","","110"},
                    {"Food Type: Rice Plain","","","","100"},
                    {"Food Type: Beans","","","","80"},
                    {"Food Type: Pilau or Biryani","","","","200"},
                    {"Food Type: Mukimo","","","","250"},
                    {"Food Type: Street Food( Mutura, Boiled/Rosted Maize)","","","","20"},
                    {"Food Type: Matoke","","","","100"},
                    {"Food Type: Somali Anjera","","","","100"},
                    {"Food Type: Ethopian Anjera","","","","120"},
                    {"Food Type: Indian Cuisine","","","","650"},
                    {"Food Type: French Cuisine","","","","600"},
                    {"Food Type: Chinese Cuisine","","","","550"},
                    {"Food Type: Japanese Cuisine","","","","700"},
                    {"Food Type: Italian Cuisine","","","","700"},
                    {"Food Type: Greek Cuisine","","","","690"},
                    {"Food Type: Spanish Cuisine","","","","670"},
                    {"Food Type: Labanese Cuisine","","","","710"},
                    {"Food Type: Thai Cuisine","","","","800"},
                    {"Food Type: Turkish Cuisine","","","","850"},
                    {"Food Type: Moroccan Cuisine","","","","810"},
            };
    TextView tv;
    Button btnBack,btnGoToCart;
    String[][] Food_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        tv = findViewById(R.id.textViewFDTitle);
        btnBack = findViewById(R.id.buttonFDBack);
        btnGoToCart = findViewById(R.id.buttonFDGoToCart);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Breakfast")==0)
            Food_details =  Food_details1;
        else
            Food_details =  Food_details2;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodDetailsActivity.this, FoodActivity.class));
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodDetailsActivity.this, CartFoodActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<Food_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", Food_details[i][0]);
            item.put("line2", Food_details[i][1]);
            item.put("line3", Food_details[i][2]);
            item.put("line4", Food_details[i][3]);
            item.put("line5", "Price "+" "+Food_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewFD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(FoodDetailsActivity.this, CartFoodActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2", Food_details[i][0]);
                it.putExtra("text3", Food_details[i][1]);
                it.putExtra("text4", Food_details[i][3]);
                it.putExtra("text5", Food_details[i][4]);
                startActivity(it);
            }
        });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(FoodDetailsActivity.this, ViewFoodDetails.class);
                it.putExtra("text1",title);
                it.putExtra("text2", Food_details[i][0]);
                it.putExtra("text5", Food_details[i][4]);
                startActivity(it);
            }
        });
    }
}