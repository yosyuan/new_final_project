package tw.cgu.b0921246.app_game;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class game3 extends AppCompatActivity implements DialogInterface.OnClickListener, ImageView.OnClickListener {
    private GlobalClass gv;
    MediaPlayer player,clickB,clickC;
    Button btn3,btn2;
    TextView point3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        int[] image = {R.id.ii1, R.id.ii2, R.id.ii10, R.id.ii4, R.id.ii5, R.id.ii11,
                R.id.ii7, R.id.ii8, R.id.ii9};
        for (int imageview : image) {
            findViewById(imageview).setOnClickListener(this);
        }
        //btn3=findViewById(R.id.btn3);
        btn2=findViewById(R.id.btn2);
        point3=findViewById(R.id.point3);
        new AlertDialog.Builder(this)
                .setMessage("這關跟第二關遊戲方式一樣，快來找出要找的東西吧!")
                .setCancelable(false)
                .setTitle("歡迎來到第三關！")
                .setIcon(android.R.drawable.btn_star_big_off)
                .setPositiveButton("準備好了",this)
                .setNegativeButton("回到上一個遊戲 ",this)
                .show();
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        point3.setText(data);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i==DialogInterface.BUTTON_POSITIVE){
        }else if(i==DialogInterface.BUTTON_NEGATIVE){
            player.release();
            //Intent it1=new Intent(this,game2.class);
            //startActivity(it1);
            getIntent().setClass(game3.this,game2.class);
            Intent it=new Intent(getApplication(),game2.class);
            //it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
             it.putExtra("GO2",true);
            startActivity(it);
        }
    }

    @Override
    public void onClick(View view) {
        int visible;
        if (view.getId() == R.id.ii1) {
            visible = View.GONE;
            findViewById(R.id.ii1).setVisibility(visible);
        } else if (view.getId() == R.id.ii2) {
            visible = View.GONE;
            findViewById(R.id.ii2).setVisibility(visible);
        } else if (view.getId() == R.id.ii10) {
            visible = View.GONE;
            findViewById(R.id.ii10).setVisibility(visible);
        } else if (view.getId() == R.id.ii4) {
            visible = View.GONE;
            findViewById(R.id.ii4).setVisibility(visible);
        } else if (view.getId() == R.id.ii5) {
            visible = View.GONE;
            findViewById(R.id.ii5).setVisibility(visible);
        } else if (view.getId() == R.id.ii7) {
            visible = View.GONE;
            findViewById(R.id.ii7).setVisibility(visible);
        } else if (view.getId() == R.id.ii8) {
            visible = View.GONE;
            findViewById(R.id.ii8).setVisibility(visible);
        } else if (view.getId() == R.id.ii9) {
            visible = View.GONE;
            findViewById(R.id.ii9).setVisibility(visible);
        } else if (view.getId() == R.id.ii11) {

            clickC = MediaPlayer.create(this,R.raw.correct2);
            clickC.start();
            gv = (GlobalClass)getApplicationContext();
            gv.setPlayer(player);
            Intent it=getIntent();
            String data=it.getStringExtra("分數");
            int data3=Integer.parseInt(data)+20;
            point3.setText(String.valueOf(data3));

            Intent it1 = new Intent(this, game4.class);
            String data4=point3.getText().toString();
            //String data2=point2.getText().toString();
            it1.putExtra("分數",data4);
            startActivity(it1);
        }
    }
    public void giveup(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        int data3=Integer.parseInt(data);
        point3.setText(String.valueOf(data3));

        Intent it1 = new Intent(this, game4.class);
        String data4=point3.getText().toString();
        it1.putExtra("分數",data4);
        startActivity(it1);
    }

}
            /*new AlertDialog.Builder(this)
                    .setMessage("獲得分數100分")
                    .setCancelable(true)
                    .setTitle("恭喜你完成這些關卡！\n請按返回鍵並按回到主頁面")
                    .setIcon(android.R.drawable.btn_star_big_off)
                    .show();
                    visible = View.VISIBLE;
                    findViewById(R.id.btn3).setVisibility(visible);*/
