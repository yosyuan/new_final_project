package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class color_one3 extends AppCompatActivity {
    private GlobalClass gv;
    MediaPlayer player,clickB;
    TextView question3;
    int sum3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_one3);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        question3=findViewById(R.id.question3);
        question3.setText("向右傾、手遮住螢幕、向左傾、手打開遮住的螢幕、輕觸螢幕");
        Intent it4=getIntent();
        int end33=it4.getIntExtra("分數2",0);
        sum3=end33;

    }
    public void begin3(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it5=new Intent(this,color_second3.class);
        //startActivity(it5);

        it5.putExtra("分數2",sum3);
        startActivity(it5);

    }
}