
package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_input;
    EditText txt_input;
    TextView txt_money;


    //클래스 내부 전역변수로 지정해야 다른 메소드에서도 사용 가능
    int money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_input = findViewById(R.id.btn_input);
        txt_input = findViewById(R.id.txt_input);
        txt_money = findViewById(R.id.txt_money);

        btn_input.setOnClickListener(this);

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