package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main5Activity extends AppCompatActivity {

    private GlobalClass gv;
    MediaPlayer player,click;
    TextView dialogue,points;
    Button btn;

    boolean text = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        dialogue = (TextView) findViewById(R.id.textView16);
        btn = (Button)findViewById(R.id.sure5);
        points=findViewById(R.id.p4);
        int p = gv.getTotalPoints();
        points.setText("points："+String.valueOf(p));
    }
    public void go(View v){
        click = MediaPlayer.create(this,R.raw.click_story);
        click.start();
        if(text==true){
            player.release();
            Intent it1=new Intent(this,knowledge.class);
            startActivity(it1);
        }
        else {
            //廚師圖片出現
            dialogue.setText("廚師：我親愛的客人們，我們來玩個小遊戲吧！如果你們得分越高，我就做越高級的甜點給你們吃，不過...題目可不簡單喔！");
            text = true;
            btn.setText("前往下一關");
        }
    }
}
