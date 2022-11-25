
package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txt_input;
    TextView txt_money, item1_price, item1_text, item2_price, item2_text, item3_price,
            item3_text, item4_price, item4_text;
    Button btn_input, item1_btn, item2_btn, item3_btn, item4_btn, btn_change;
    HashMap<Integer, ItemDTO> map;
    HashMap<Integer, Integer> orderMap;


    //클래스 내부 전역변수로 지정해야 다른 메소드에서도 사용 가능
    int money = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_input = findViewById(R.id.btn_input);
        txt_input = findViewById(R.id.txt_input);
        txt_money = findViewById(R.id.txt_money);
        item1_price = findViewById(R.id.item1_price);
        item1_text = findViewById(R.id.item1_text);
        item1_btn = findViewById(R.id.item1_btn);
        item2_price = findViewById(R.id.item2_price);
        item2_text = findViewById(R.id.item2_text);
        item2_btn = findViewById(R.id.item2_btn);
        item3_price = findViewById(R.id.item3_price);
        item3_text = findViewById(R.id.item3_text);
        item3_btn = findViewById(R.id.item3_btn);
        item4_price = findViewById(R.id.item4_price);
        item4_text = findViewById(R.id.item4_text);
        item4_btn = findViewById(R.id.item4_btn);
        btn_change = findViewById(R.id.btn_change);

        ItemDAO dao = new ItemDAO();
        map = dao.getItem();
        orderMap = new HashMap<>();
        item1_price.setText(map.get(1).getName() + " " + map.get(1).getPrice() + "원");
        item1_text.setText(map.get(1).getQty() + "개 남음");
        item2_price.setText(map.get(2).getName() + " " + map.get(2).getPrice() + "원");
        item2_text.setText(map.get(2).getQty() + "개 남음");
        item3_price.setText(map.get(3).getName() + " " + map.get(3).getPrice() + "원");
        item3_text.setText(map.get(3).getQty() + "개 남음");
        item4_price.setText(map.get(4).getName() + " " + map.get(4).getPrice() + "원");
        item4_text.setText(map.get(4).getQty() + "개 남음");

        txt_money.setText("잔액 : " + money + "원");

//        View.OnClickListener inputClick = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                money = Integer.parseInt(txt_input.getText().toString());
//                txt_money.setText("잔액 : " + money);
//            }
//        };

        View.OnClickListener orderClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = 0;
                if (v.getId() == R.id.item1_btn) {
                    id = 1;
                } else if (v.getId() == R.id.item2_btn) {
                    id = 2;
                } else if (v.getId() == R.id.item3_btn) {
                    id = 3;
                } else if (v.getId() == R.id.item4_btn) {
                    id = 4;
                }
                if (money < map.get(id).getPrice()) {
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                } else if (map.get(id).getQty() == 0) {
                    Toast.makeText(MainActivity.this, "해당 상품의 잔고가 부족합니다.", Toast.LENGTH_SHORT).show();
                } else {
                    dao.orderItem(id);
                    if (!orderMap.containsKey(id)) {
                        orderMap.put(id, 1);
                    } else {
                        orderMap.put(id, orderMap.get(id) + 1);
                    }
                    money -= map.get(id).getPrice();
                    txt_money.setText("잔액 : " + money);
                    refreshQty(id);
                }
            }
        };

        View.OnClickListener changeClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("money", money);
                intent.putExtra("orderMap" , orderMap);
                startActivity(intent);
            }
        };

        item1_btn.setOnClickListener(orderClick);
        item2_btn.setOnClickListener(orderClick);
        item3_btn.setOnClickListener(orderClick);
        item4_btn.setOnClickListener(orderClick);
        //btn_input.setOnClickListener(inputClick);
        btn_change.setOnClickListener(changeClick);
        btn_input.setOnClickListener(this);

    }

    public void refreshQty(int id) {
        switch(id) {
            case 1:
                item1_text.setText(map.get(1).getQty() + "개 남음");
                break;
            case 2:
                item2_text.setText(map.get(2).getQty() + "개 남음");
                break;
            case 3:
                item3_text.setText(map.get(3).getQty() + "개 남음");
                break;
            case 4:
                item4_text.setText(map.get(4).getQty() + "개 남음");
                break;
        }
    }



    /*----- 1.금액입력부 : 숫자값만 입력 ------- */
    @Override
    public void onClick(View v) {

        try {
            money = Integer.parseInt(txt_input.getText().toString());
            txt_money.setText("잔액 : " + money + "원");

        } catch(Exception e){
            Toast.makeText(this, "숫자만 입력하실 수 있습니다", Toast.LENGTH_SHORT).show();
        }




        //버튼이 클릭된다

       // Log.d("버튼", "onClick:클릭 ");

        // 버튼이 클릭되면 입력받은 값을 담는다: getText()

        //Log.d("버튼", "onClick:클릭 " + txt_input.getText() );

        // 입력받은 값을 잔액표시란에 보여준다 : setText()

        //txt_money.setText("금액이 입력되었습니다");

        //버튼 클릭되면 입력받은 값을 잔액표시란에 출력한다
        //txt_money.setText("잔액 : " + txt_input.getText());


    }

 



}