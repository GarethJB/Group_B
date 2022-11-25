
package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txt_input;
    TextView txt_money, item1_price, item1_text, item2_price, item2_text, item3_price,
            item3_text, item4_price, item4_text;
    Button btn_input, item1_btn, item2_btn, item3_btn, item4_btn, btn_change;

    //클래스 내부 전역변수로 지정해야 다른 메소드에서도 사용 가능
    int money;

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
        HashMap<Integer, ItemDTO> map = dao.getItem();
        item1_price.setText(map.get(1).getName() + " " + map.get(1).getPrice() + "원");
        item1_text.setText(map.get(1).getQty() + "개 남음");
        item2_price.setText(map.get(2).getName() + " " + map.get(2).getPrice() + "원");
        item2_text.setText(map.get(2).getQty() + "개 남음");
        item3_price.setText(map.get(3).getName() + " " + map.get(3).getPrice() + "원");
        item3_text.setText(map.get(3).getQty() + "개 남음");
        item4_price.setText(map.get(4).getName() + " " + map.get(4).getPrice() + "원");
        item4_text.setText(map.get(4).getQty() + "개 남음");



        btn_input.setOnClickListener(this);


    }

    /*-----1.금액입력부------- */
    @Override
    public void onClick(View v) {

        money = Integer.parseInt(txt_input.getText().toString());


        //버튼이 클릭된다

        Log.d("버튼", "onClick:클릭 ");

        // 버튼이 클릭되면 입력받은 값을 담는다: getText()

        //Log.d("버튼", "onClick:클릭 " + txt_input.getText() );

        // 입력받은 값을 잔액표시란에 보여준다 : setText()

        //txt_money.setText("금액이 입력되었습니다");

        //버튼 클릭되면 입력받은 값을 잔액표시란에 출력한다
        //txt_money.setText("잔액 : " + txt_input.getText());


    }

    //정수값만 받아야 한다 --> 문자는 안된다
    //정수값만 받는 메소드 생성




}