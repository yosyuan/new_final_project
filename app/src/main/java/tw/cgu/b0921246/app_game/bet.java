package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bet extends AppCompatActivity implements View.OnClickListener {
    private GlobalClass gv;
    MediaPlayer player,clickB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet);
        player = MediaPlayer.create(this,R.raw.game);
        player.start();
        Button big=findViewById(R.id.big2);
        Button single=findViewById(R.id.single);
        big.setOnClickListener(this);
        single.setOnClickListener(this);

        TextView rule=findViewById(R.id.rule);
        rule.setText("遊戲說明:\n\n您擁有本金500元，請先遊玩比大小，使本金達到2000元\n再玩猜密碼，在限定次數內成功猜出密碼\n即為過關");  //顯示遊戲規則
    }
    public void gofinish(View v){     //結束遊戲
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        player.release();
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.single) {
            clickB = MediaPlayer.create(this,R.raw.click);
            clickB.start();
            gv = (GlobalClass)getApplicationContext();
            gv.setPlayer(player);
            Intent it3 =new Intent(this,bet3.class);
            startActivity(it3);
        }else if (v.getId()==R.id.big2) {
            clickB = MediaPlayer.create(this,R.raw.click);
            clickB.start();
            gv = (GlobalClass)getApplicationContext();
            gv.setPlayer(player);
            Intent it = new Intent(this,bet4.class);
            startActivity(it);
        }
    }
}