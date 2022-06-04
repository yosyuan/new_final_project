package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class bet extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet);

        Button big=findViewById(R.id.big2);
        Button single=findViewById(R.id.single);
        big.setOnClickListener(this);
        single.setOnClickListener(this);

        TextView rule=findViewById(R.id.rule);
        rule.setText("遊戲說明:\n\n您擁有本金500元，遊玩以下2關遊戲，使您的本金皆達到2000元，即為過關");  //顯示遊戲規則
    }
    public void gofinish(View v){     //結束遊戲
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.single) {
            Intent it3 =new Intent(this,bet3.class);
            startActivity(it3);
        }else if (v.getId()==R.id.big2) {
            Intent it = new Intent(this,bet4.class);
            startActivity(it);
        }
    }
}