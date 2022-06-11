package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class color_one1 extends AppCompatActivity {

    private GlobalClass gv;
    MediaPlayer player,clickB;
    TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_one1);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        question=(TextView) findViewById(R.id.question);
        question.setText("手遮住螢幕、手打開遮住的螢幕、向左傾、向右傾、向左傾");
    }
    public void begin(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it1=new Intent(this,color_second1.class);
        startActivity(it1);
    }
}