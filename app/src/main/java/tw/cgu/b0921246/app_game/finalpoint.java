package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class finalpoint extends AppCompatActivity {

    private GlobalClass gv;
    MediaPlayer player,clickS;
    TextView points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpoint);
        player = MediaPlayer.create(this,R.raw.story);
        player.start();
        points=findViewById(R.id.p1);
        gv = (GlobalClass)getApplicationContext();
        int p=gv.getTotalPoints();
        points.setText("points："+String.valueOf(p));

       /* Intent it=getIntent();
        String data=it.getStringExtra("分數");
        point6.setText("總分："+data);*/
    }
    public void sure(View v){
        clickS = MediaPlayer.create(this,R.raw.click_story);
        clickS.start();
        player.release();
        Intent it1 = new Intent(this, bet.class);
        startActivity(it1);
    }
}
