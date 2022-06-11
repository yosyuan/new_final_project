package tw.cgu.b0921246.app_game;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class bet3 extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    private GlobalClass gv;
    MediaPlayer player,clickB,C,Boom;
    TextView rest,show;
    Toast tos1;
    Button guess,go;
    EditText edt;

    int time=7,points=100;
    Random y = new Random();
    int pass = y.nextInt(99);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet3);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        AlertDialog.Builder bdr1=new AlertDialog.Builder(this);
        bdr1.setMessage("為了把炸彈引爆，您需要在7次內成功猜出密碼，每輸入一次數字，會有提示協助\n祝您成功!\n" +
                "按任意處關閉此交談窗");
        bdr1.setTitle("WELCOME!!");
        bdr1.setIcon(android.R.drawable.star_on);
        bdr1.setCancelable(true);
        bdr1.show();
        tos1=Toast.makeText(this,"",Toast.LENGTH_SHORT);

        guess=findViewById(R.id.guess);
        go=findViewById(R.id.go);
        edt=findViewById(R.id.edt);
        //vic=findViewById(R.id.vic);
        rest=findViewById(R.id.rest);
        show=findViewById(R.id.show);
        guess.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {

        int input = Integer.parseInt(edt.getText().toString());
        if (input >= 0 && input <= 99) {
            if (time == 1) {
                if (pass != input) {
                    Boom = MediaPlayer.create(this,R.raw.boom);
                    Boom.start();
                    rest.setText("剩餘次數: 0次");
                    show.setText("遊戲結束\n密碼是: " + pass + "\n得分：0分");
                    gv = (GlobalClass)getApplicationContext();
                    int b=gv.getBetPoints();
                    b+=points;
                    gv.setBetPoints(b);
                    findViewById(R.id.bomb).setVisibility(View.GONE);
                    findViewById(R.id.boom).setVisibility(View.VISIBLE);
                    go.setVisibility(View.VISIBLE);
                }
                else if (pass == input) {
                    C = MediaPlayer.create(this,R.raw.correct);
                    C.start();
                    show.setText("密碼是: "+pass+"恭喜!您答對了!\n得分："+points+"分");
                    gv = (GlobalClass)getApplicationContext();
                    int k=gv.getTotalPoints();
                    k+=points;
                    gv.setTotalPoints(k);
                    int b=gv.getBetPoints();
                    b+=points;
                    gv.setBetPoints(b);
                    //  findViewById(R.id.bomb).setVisibility(View.GONE);
                    //  findViewById(R.id.boom).setVisibility(View.VISIBLE);
                    go.setVisibility(View.VISIBLE);

                }
            } else if (time > 1) {
                C = MediaPlayer.create(this,R.raw.incorrect2);
                C.start();
                if (pass != input) {
                    time = time - 1;
                    rest.setText("剩餘次數: "+time+"次");
                    points-=10;
                    if (pass > input) {
                        show.setText(input+" 這個數字太小囉~ \n");
                    }
                    if (pass < input) {
                        show.setText(input+" 這個數字太大囉~ \n");
                    }
                }
                else if (pass == input) {
                    C = MediaPlayer.create(this,R.raw.correct);
                    C.start();
                    show.setText("密碼是: "+pass+"恭喜!您答對了!\n得分："+String.valueOf(points)+"分");
                    gv = (GlobalClass)getApplicationContext();
                    int k=gv.getTotalPoints();
                    k+=points;
                    gv.setTotalPoints(k);
                    int b=gv.getBetPoints();
                    b+=points;
                    gv.setBetPoints(b);
                  //  findViewById(R.id.bomb).setVisibility(View.GONE);
                  //  findViewById(R.id.boom).setVisibility(View.VISIBLE);
                    go.setVisibility(View.VISIBLE);

                }
                else {

                }

            }

        }
        else
            show.setText("請輸入0~99之間的數字!!");
    }
    public void go (View v){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        player.release();
        Intent it1=new Intent(this,Main3Activity.class);
        startActivity(it1);
    }
}
