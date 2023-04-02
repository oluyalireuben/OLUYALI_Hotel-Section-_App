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

public class RoomDetailsActivity extends AppCompatActivity {
    private String[][] Room_Details1 =
            {
                    {"Room Name :  Turkana A", "Room Address : 101", "Room Number 001: ", "Customer Care No:0721577451", "500"},
                    {"Room Name :  Turkana B", "Room Address : 102", "Room Number 002: ", "Customer Care No:0721577451", "500"},
                    {"Room Name :  Turkana C", "Room Address : 103", "Room Number 003: ", "Customer Care No:0721577451", "500"},
                    {"Room Name :  Turkana D", "Room Address : 104", "Room Number 004: ", "Customer Care No:0721577451", "500"},
                    {"Room Name :  Turkana E", "Room Address : 105", "Room Number 005: ", "Customer Care No:0721577451", "500"},
                    {"Room Name :  Turkana F", "Room Address : 106", "Room Number 006: ", "Customer Care No:0721577451", "500"},
                    {"Room Name :  Turkana G", "Room Address : 107", "Room Number 007: ", "Customer Care No:0721577451", "500"},
                    {"Room Name :  Turkana H", "Room Address : 108", "Room Number 008: ", "Customer Care No:0721577451", "500"},
                    {"Room Name :  Turkana I", "Room Address : 109", "Room Number 009: ", "Customer Care No:0721577451", "500"},
                    {"Room Name :  Turkana J", "Room Address : 110", "Room Number 010: ", "Customer Care No:0721577451", "500"},
            };
    private String[][] Room_Details2 =
            {
                    {"Room Name :  Baringo A", "Room Address : 111", "Room Number 011: ", "Customer Care No:0796289093", "500"},
                    {"Room Name :  Baringo B", "Room Address : 112", "Room Number 012: ", "Customer Care No:0796289093", "500"},
                    {"Room Name :  Baringo C", "Room Address : 113", "Room Number 013: ", "Customer Care No:0796289093", "500"},
                    {"Room Name :  Baringo D", "Room Address : 114", "Room Number 014: ", "Customer Care No:0796289093", "500"},
                    {"Room Name :  Baringo E", "Room Address : 115", "Room Number 015: ", "Customer Care No:0796289093", "500"},
                    {"Room Name :  Baringo F", "Room Address : 116", "Room Number 016: ", "Customer Care No:0796289093", "500"},
                    {"Room Name :  Baringo G", "Room Address : 117", "Room Number 017: ", "Customer Care No:0796289093", "500"},
                    {"Room Name :  Baringo H", "Room Address : 118", "Room Number 018: ", "Customer Care No:0796289093", "500"},
                    {"Room Name :  Baringo I", "Room Address : 119", "Room Number 019: ", "Customer Care No:0796289093", "500"},
                    {"Room Name :  Baringo J", "Room Address : 120", "Room Number 020: ", "Customer Care No:0796289093", "500"},


            };
    private String[][] Room_Details3 =
            {
                    {"Room Name :  Bogoria A", "Room Address : 121", "Room Number 021: ", "Customer Care No:0717086579", "500"},
                    {"Room Name :  Bogoria B", "Room Address : 122", "Room Number 022: ", "Customer Care No:0717086579", "500"},
                    {"Room Name :  Bogoria C", "Room Address : 123", "Room Number 023: ", "Customer Care No:0717086579", "500"},
                    {"Room Name :  Bogoria D", "Room Address : 124", "Room Number 024: ", "Customer Care No:0717086579", "500"},
                    {"Room Name :  Bogoria E", "Room Address : 125", "Room Number 025: ", "Customer Care No:0717086579", "500"},
                    {"Room Name :  Bogoria F", "Room Address : 126", "Room Number 026: ", "Customer Care No:0717086579", "500"},
                    {"Room Name :  Bogoria G", "Room Address : 127", "Room Number 027: ", "Customer Care No:0717086579", "500"},
                    {"Room Name :  Bogoria H", "Room Address : 128", "Room Number 028: ", "Customer Care No:0717086579", "500"},
                    {"Room Name :  Bogoria I", "Room Address : 129", "Room Number 029: ", "Customer Care No:0717086579", "500"},
                    {"Room Name :  Bogoria J", "Room Address : 130", "Room Number 030: ", "Customer Care No:0717086579", "500"},

            };
    private String[][] Room_Details4 =
            {
                    {"Room Name :  Elementaita A", "Room Address : 131", "Room Number 031: ", "Customer Care No:0719548751", "500"},
                    {"Room Name :  Elementaita B", "Room Address : 132", "Room Number 032: ", "Customer Care No:0719548751", "500"},
                    {"Room Name :  Elementaita C", "Room Address : 133", "Room Number 033: ", "Customer Care No:0719548751", "500"},
                    {"Room Name :  Elementaita D", "Room Address : 134", "Room Number 034: ", "Customer Care No:0719548751", "500"},
                    {"Room Name :  Elementaita E", "Room Address : 135", "Room Number 035: ", "Customer Care No:0719548751", "500"},
                    {"Room Name :  Elementaita F", "Room Address : 136", "Room Number 036: ", "Customer Care No:0719548751", "500"},
                    {"Room Name :  Elementaita G", "Room Address : 137", "Room Number 037: ", "Customer Care No:0719548751", "500"},
                    {"Room Name :  Elementaita H", "Room Address : 138", "Room Number 038: ", "Customer Care No:0719548751", "500"},
                    {"Room Name :  Elementaita I", "Room Address : 139", "Room Number 039: ", "Customer Care No:0719548751", "500"},
                    {"Room Name :  Elementaita J", "Room Address : 140", "Room Number 040: ", "Customer Care No:0719548751", "500"},
            };
    TextView tv;
    Button btn;
    String[][] Room_Details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        tv = findViewById(R.id.textViewRDTitle);
        btn = findViewById(R.id.buttonRDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Single Room")==0)
            Room_Details = Room_Details1;
        else
        if (title.compareTo("Double Room")==0)
            Room_Details = Room_Details2;
        else
        if (title.compareTo("Single Room with Shower")==0)
            Room_Details = Room_Details3;
        else
            Room_Details = Room_Details4;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoomDetailsActivity.this, FindRoomActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<Room_Details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", Room_Details[i][0]);
            item.put("line2", Room_Details[i][1]);
            item.put("line3", Room_Details[i][2]);
            item.put("line4", Room_Details[i][3]);
            item.put("line5", "Charges "+" "+Room_Details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewRD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(RoomDetailsActivity.this,BookRoomActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2", Room_Details[i][0]);
                it.putExtra("text3", Room_Details[i][1]);
                it.putExtra("text4", Room_Details[i][3]);
                it.putExtra("text5", Room_Details[i][4]);
                startActivity(it);
            }
        });
    }
}