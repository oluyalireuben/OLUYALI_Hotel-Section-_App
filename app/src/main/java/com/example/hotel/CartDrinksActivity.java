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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CartDrinksActivity extends AppCompatActivity {
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView tvTotal;
    ListView lst;
    private TimePickerDialog timePickerDialog;
    private Button timeButton, btnCheckout, btnBack;
    private String[][] Drinks_details= {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_drinks);

        timeButton = findViewById(R.id.buttonCartDrinkTimePicker);
        btnCheckout = findViewById(R.id.buttonCartDrinkCheckout);
        btnBack = findViewById(R.id.buttonCartDrinkBack);
        tvTotal = findViewById(R.id.textViewCartDrinkTotalCost);
        lst = findViewById(R.id.listViewCartDrink);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username", "").toString();

        Database db = new Database(getApplicationContext(), "hotel", null, 1);

        float totalAmount = 0;
        ArrayList dbData = db.getCartData(username, "Drink");
        //Toast.makeText(getApplicationContext(), ""+dbData,Toast.LENGTH_LONG).show();

        Drinks_details = new String[dbData.size()][];
        for (int i = 0; i < Drinks_details.length; i++) {
            Drinks_details[i] = new String[5];
        }
        for (int i = 0; i < dbData.size(); i++) {
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            Drinks_details[i][0] = strData[0];
            Drinks_details[i][4] = "Cost : " + strData[1] + "/-";
            totalAmount = totalAmount + Float.parseFloat(strData[1]);
        }
        tvTotal.setText("Total Cost : " + totalAmount);

        list = new ArrayList();
        for (int i = 0; i < Drinks_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", Drinks_details[i][0]);
            item.put("line2", Drinks_details[i][1]);
            item.put("line3", Drinks_details[i][2]);
            item.put("line4", Drinks_details[i][3]);
            item.put("line5", Drinks_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartDrinksActivity.this, DrinksDetailsActivity.class));
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CartDrinksActivity.this, OrderDrinks.class);
                it.putExtra("price", tvTotal.getText());
                it.putExtra("time", timeButton.getText());
                startActivity(it);
            }
        });

        //timePicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i+":"+i1);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);
        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this,style,timeSetListener,hrs,mins, true);
    }
}