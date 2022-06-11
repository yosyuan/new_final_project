package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main4Activity extends AppCompatActivity {

    private GlobalClass gv;
    MediaPlayer player,click;
    TextView dialogue,points;

    int p;
    boolean moon = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        player = MediaPlayer.create(this,R.raw.story);
        player.start();
        dialogue = (TextView) findViewById(R.id.textView15);
        points=findViewById(R.id.p3);
        gv = (GlobalClass)getApplicationContext();
        p = gv.getIdiomPoints();
        int pp = gv.getTotalPoints();
        points.setText("points："+String.valueOf(pp));

        if(p>=80)
            dialogue.setText("老闆：竟然能通過我這關，明顯是個狠角色，好吧！我就帶你們去吃西門町的高級鐵板燒！");
        else
            dialogue.setText("老闆：真是可惜啊~我原本想帶你們去吃西門町的高級鐵板燒，等我明年生日再回來挑戰吧，哈哈哈！");
    }
    public void go(View v){
        click = MediaPlayer.create(this,R.raw.click_story);
        click.start();
        if(p>=80||moon==true){
            gv = (GlobalClass)getApplicationContext();
            gv.setPlayer(player);
            Intent it1=new Intent(this,Main5Activity.class);
            startActivity(it1);
        }
        else if(p<80&&moon==false){
            dialogue.setText("月亮：沒關係達達，我們自己去吃吧~就去吃那家高級鐵板燒！嘿嘿~");
            moon = true;
        }
    }
}
