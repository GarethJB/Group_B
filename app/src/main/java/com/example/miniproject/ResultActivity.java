package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {

    int money;
    HashMap<Integer, Integer> orderMap;
    HashMap<Integer, ItemDTO> map;
    TextView txt_money_result, txt_order_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ItemDAO dao = new ItemDAO();
        map = dao.getItem();

        Intent intent = getIntent();
        money = intent.getIntExtra("money", 0);
        orderMap = (HashMap<Integer, Integer>) intent.getSerializableExtra("orderMap");

        txt_money_result = findViewById(R.id.txt_money_result);
        txt_order_result = findViewById(R.id.txt_order_result);

        txt_money_result.setText("잔액 : " + money);

        for (int i = 1; i < 5; i++) {
            if (orderMap.get(i) != null) {
                txt_order_result.append(map.get(i).getName() + " " + orderMap.get(i) + "개\n");
            }
        }



    }
}