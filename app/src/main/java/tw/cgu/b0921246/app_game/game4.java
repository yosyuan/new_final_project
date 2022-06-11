package tw.cgu.b0921246.app_game;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class game4 extends AppCompatActivity implements DialogInterface.OnClickListener, ImageView.OnTouchListener{

    private GlobalClass gv;
    MediaPlayer player,clickB,clickC;
    Button btn6,btn7;
    TextView point4;
    private float x,y;
    private int mx,my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        int[] image = {R.id.iii1, R.id.iii2, R.id.iii3, R.id.iii4, R.id.iii5};
        for (int imageview : image) {
            findViewById(imageview).setOnTouchListener(this);
        }

        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        point4=findViewById(R.id.point4);

        new AlertDialog.Builder(this)
                .setMessage("這關需要移開沒有關聯的物件，快來找出要找的東西吧!")
                .setCancelable(false)
                .setTitle("歡迎來到第四關！")
                .setIcon(android.R.drawable.btn_star_big_off)
                .setPositiveButton("準備好了",this)
                .setNeutralButton("回到遊戲主頁",this)
                .setNegativeButton("回到上一個遊戲 ",this)
                .show();
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        point4.setText(data);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i==DialogInterface.BUTTON_POSITIVE){
        }else if (i==DialogInterface.BUTTON_NEUTRAL){
            player.release();
            Intent it1=new Intent(this,MainActivity.class);
            startActivity(it1);
        }else if(i==DialogInterface.BUTTON_NEGATIVE){
            player.release();
            Intent it1=new Intent(this,game3.class);
            startActivity(it1);
        }
    }

    public void goback(View v){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        player.release();
        Intent it1 = new Intent(this, MainActivity.class);
        startActivity(it1);
    }
    public void giveup(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        int data4=Integer.parseInt(data);
        point4.setText(String.valueOf(data4));

        Intent it1 = new Intent(this, game5.class);
        String data5=point4.getText().toString();
        it1.putExtra("分數",data5);
        startActivity(it1);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x=motionEvent.getX();
                y=motionEvent.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                mx=(int)(motionEvent.getRawX()-x);
                my=(int)(motionEvent.getRawY()-y);
                view.layout(mx,my,mx+view.getWidth(),my+view.getHeight());
                break;
        }
        Log.e("address",String.valueOf(mx)+"~~"+String.valueOf(my));

        return true;
    }
    public void ture(View view) {
        clickC = MediaPlayer.create(this,R.raw.correct2);
        clickC.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        int data4=Integer.parseInt(data)+20;
        point4.setText(String.valueOf(data4));

        Intent it1 = new Intent(this, game5.class);
        String data5=point4.getText().toString();
        //String data2=point2.getText().toString();
        it1.putExtra("分數",data5);
        startActivity(it1);
    }
}
