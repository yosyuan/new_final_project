package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    private GlobalClass gv;
    MediaPlayer player,clickS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
    }
    public void game1(View v){
        clickS = MediaPlayer.create(this,R.raw.click_story);
        clickS.start();
        player.release();
        Intent it1=new Intent(this,game1.class);
        startActivity(it1);
    }
}
