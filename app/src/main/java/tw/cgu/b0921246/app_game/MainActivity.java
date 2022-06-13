package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GlobalClass gv;
    MediaPlayer player,clickB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this,R.raw.story);
        player.start();
    }
    public void sure(View v){
        clickB= MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it1=new Intent(this,Main2Activity.class);
        startActivity(it1);
    }
    public  void exit(View v){
        clickB= MediaPlayer.create(this,R.raw.click);
        clickB.start();
        /*
        if (getIntent().getBooleanExtra("EXIT",false)){
            finish();}
            */
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

        //finish();
        //System.exit(0);//退出遊戲
    }
    public void trybet(View v){

        Intent it1=new Intent(this,bet.class);
        startActivity(it1);
    }
    public void tryguess(View v){

        Intent it1=new Intent(this,guess.class);
        startActivity(it1);
    }
    public void tryknowedge(View v){

        Intent it1=new Intent(this,knowledge.class);
        startActivity(it1);
    }
    public void trycolor(View v){

        Intent it1=new Intent(this,color.class);
        startActivity(it1);
    }

}
