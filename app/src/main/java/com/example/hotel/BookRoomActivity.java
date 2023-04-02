package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class BookRoomActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private Button dateButton1, dateButton2, btnBook, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);

        tv = findViewById(R.id.textViewAppTitle);
        ed1 = findViewById(R.id.editTextRoomRoomName);
        ed2 = findViewById(R.id.editTextRoomAddress);
        ed3 = findViewById(R.id.editTextRoomCustomerCareNumber);
        ed4 = findViewById(R.id.editTextRoomCharges);
        dateButton1 = findViewById(R.id.buttonRoomDateFrom);
        dateButton2 = findViewById(R.id.buttonRoomDateTo);
        btnBook = findViewById(R.id.buttonBookRoom);
        btnBack = findViewById(R.id.buttonRoomBack);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String roomname = it.getStringExtra("text2");
        String roomaddress = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String charges = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(roomname);
        ed2.setText(roomaddress);
        ed3.setText(contact);
        ed4.setText("Charges per day" + " " + charges + "/-");

        //datepicker1
        initDatePicker1();
        dateButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        //datepicker2
        initDatePicker2();
        dateButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

    btnBook.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Database db = new Database(getApplicationContext(),"hotel",null,1);
            SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedpreferences.getString("username","").toString();
            if(db.checkBookingsExists(username,title+" => "+roomname,roomaddress,contact,dateButton1.getText().toString(),dateButton2.getText().toString())==1){
                Toast.makeText(getApplicationContext(), "Room already booked", Toast.LENGTH_SHORT).show();
            }else {
                db.addOrder(username,title+" => "+roomname,roomaddress,contact,0,dateButton1.getText().toString(),dateButton2.getText().toString(),Float.parseFloat(charges),"Room");
                Toast.makeText(getApplicationContext(), "Room Booking is successful", Toast.LENGTH_SHORT).show();
                startActivity( new Intent(BookRoomActivity.this, HomeActivity.class));
            }
        }
    });
}

    private void initDatePicker1() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton1.setText(i2 + "/" + i1 + "/" + i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }


    private void initDatePicker2() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateButton2.setText(i2 + "/" + i1 + "/" + i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000 );

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookRoomActivity.this, FindRoomActivity.class));
            }
        });
    }
}
