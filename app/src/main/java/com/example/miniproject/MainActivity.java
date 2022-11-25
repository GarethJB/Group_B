
package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button item1_btn, item2_btn, item3_btn, item4_btn;
    int qty, money, price;

    HashMap<>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemDAO dao = new ItemDAO();

        item1_btn = findViewById(R.id.item1_btn);
        item2_btn = findViewById(R.id.item2_btn);
        item3_btn = findViewById(R.id.item3_btn);
        item4_btn = findViewById(R.id.item4_btn);

        item1_btn.setOnClickListener(this);
        item2_btn.setOnClickListener(this);
        item3_btn.setOnClickListener(this);
        item4_btn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        ItemDAO dao = new ItemDAO();
        dao.item_order(qty);
        dao.charge(money, price);
    }
}