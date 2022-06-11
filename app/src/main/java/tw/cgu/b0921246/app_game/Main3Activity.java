package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    private GlobalClass gv;
    MediaPlayer player,click;
    TextView points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        player = MediaPlayer.create(this,R.raw.story);
        player.start();
        points=findViewById(R.id.p2);
        gv = (GlobalClass)getApplicationContext();
        int p=gv.getTotalPoints();
        points.setText("points："+String.valueOf(p));
    }
    public void go(View v){
        click = MediaPlayer.create(this,R.raw.click_story);
        click.start();
        player.release();
        Intent it1=new Intent(this,guess.class);
        startActivity(it1);
    }
}
