package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class guess extends AppCompatActivity {
    private GlobalClass gv;
    MediaPlayer player,clickB;
    TextView explain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        player = MediaPlayer.create(this,R.raw.game);
        player.start();
        explain=(TextView)findViewById(R.id.explain);

        explain.setText("遊戲方法 :\n依題目上的表情符號，猜出答案\n總分超過80分即為過關\n請先選出想挑戰的題目類型");
    }
    public void cartoon(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it=new Intent(this,guess_cartoon.class);
        startActivity(it);
    }
    public void movie(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it=new Intent(this,guess_movie.class);
        startActivity(it);

    }
    public void word(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        Intent it=new Intent(this,guess_word.class);
        startActivity(it);
    }


}
