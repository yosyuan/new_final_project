package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class color_one2 extends AppCompatActivity {
    private GlobalClass gv;
    MediaPlayer player,clickB;
    int sum;
    TextView question2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_one2);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        question2=(TextView) findViewById(R.id.question2);

        Intent it2=getIntent();
        int end=it2.getIntExtra("分數1",0);
        sum=end;
        question2.setText("向左傾、手遮住螢幕、手打開遮住的螢幕、向右傾"+"\n目前得分"+end);
    }
    public void begin2(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it3=new Intent(this,color_second2.class);


        it3.putExtra("分數1",sum);
        startActivity(it3);
    }
}