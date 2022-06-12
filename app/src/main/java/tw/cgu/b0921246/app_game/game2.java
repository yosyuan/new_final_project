package tw.cgu.b0921246.app_game;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class game2 extends AppCompatActivity implements DialogInterface.OnClickListener, ImageView.OnClickListener {

    private GlobalClass gv;
    MediaPlayer player,clickB,clickC;
    TextView txv,point2;
    boolean m=true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        gv = (GlobalClass)getApplicationContext();
        //player = gv.getPlayer();
        //player.start();
        txv = findViewById(R.id.textView3);
        point2=findViewById(R.id.point2);
        int[] image = {R.id.i1, R.id.i2, R.id.i3, R.id.i4, R.id.i5, R.id.i6,
                R.id.i7, R.id.i8, R.id.i9};
        for (int imageview : image) {
            findViewById(imageview).setOnClickListener(this);
        }
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        point2.setText(data);
        if (getIntent().getBooleanExtra("GO2",false)){
            m = false;
            player = MediaPlayer.create(this,R.raw.game);
            player.start();
        }
        if(m == true){
            player = gv.getPlayer();
            player.start();
        }

        new AlertDialog.Builder(this)
                .setMessage("這關可以點擊物件會讓物件消失，接著來找出要找的東西吧!")
                .setCancelable(false)
                .setTitle("歡迎來到第二關！")
                .setIcon(android.R.drawable.btn_star_big_off)
                .setPositiveButton("準備好了", this)

                .setNegativeButton("回到上一個遊戲 ",this)
                .show();

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        if (i == DialogInterface.BUTTON_POSITIVE) {

        } else if(i==DialogInterface.BUTTON_NEGATIVE) {
            player.release();
            Intent it1 = new Intent(this, game1.class);
            startActivity(it1);
        }
    }

    @Override
    public void onClick(View view) {
        int visible;
        if (view.getId() == R.id.i1) {
            visible = View.GONE;
            findViewById(R.id.i1).setVisibility(visible);
        } else if (view.getId() == R.id.i2) {
            visible = View.GONE;
            findViewById(R.id.i2).setVisibility(visible);
        } else if (view.getId() == R.id.i3) {
            visible = View.GONE;
            findViewById(R.id.i3).setVisibility(visible);
        } else if (view.getId() == R.id.i4) {
            visible = View.GONE;
            findViewById(R.id.i4).setVisibility(visible);
        } else if (view.getId() == R.id.i5) {
            visible = View.GONE;
            findViewById(R.id.i5).setVisibility(visible);
        } else if (view.getId() == R.id.i6) {
            visible = View.GONE;
            findViewById(R.id.i6).setVisibility(visible);
        } else if (view.getId() == R.id.i7) {
            visible = View.GONE;
            findViewById(R.id.i7).setVisibility(visible);
        } else if (view.getId() == R.id.i8) {
            visible = View.GONE;
            findViewById(R.id.i8).setVisibility(visible);
        } else if (view.getId() == R.id.i9) {
            clickC = MediaPlayer.create(this,R.raw.correct2);
            clickC.start();
            gv = (GlobalClass)getApplicationContext();
            gv.setPlayer(player);
            Intent it=getIntent();
            String data=it.getStringExtra("分數");
            int data2=Integer.parseInt(data)+20;
            point2.setText(String.valueOf(data2));

            Intent it1 = new Intent(this, game3.class);
            String data3=point2.getText().toString();
            it1.putExtra("分數",data3);
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
        int data2=Integer.parseInt(data);
        point2.setText(String.valueOf(data2));

        Intent it1 = new Intent(this, game3.class);
        String data3=point2.getText().toString();
        it1.putExtra("分數",data3);
        startActivity(it1);
    }
}