package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LastPage extends AppCompatActivity {

    private GlobalClass gv;
    MediaPlayer player,vic,click;
    boolean a = false;
    int[] prisePoints = {5,15,10,20};
    ImageView da,da5,da6,da7;
    String[] priseName = {"巨無霸甜筒","神奇真空魔法吸盤","甜蜜的小窩附贈家庭成員","鵝鵝水中游"};
    int[] mood ={20,60,80,100};
    int m;
    TextView points,describe;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);
        points=(TextView)findViewById(R.id.total);
        describe=(TextView)findViewById(R.id.txv19);
        da=findViewById(R.id.da);
        da5=findViewById(R.id.da5);
        da6=findViewById(R.id.da6);
        da7=findViewById(R.id.da7);
        gv = (GlobalClass)getApplicationContext();
        int n = gv.getPrise();
        int p = gv.getTotalPoints();
        points.setText("總分："+String.valueOf(p)+"分");
        btn = (Button) findViewById(R.id.btnf);
        if (n==0){
            da6.setVisibility(View.VISIBLE);
        }else if (n==1){
            da.setVisibility(View.VISIBLE);
        }else if (n==2){
            da5.setVisibility(View.VISIBLE);
        }else {
            da7.setVisibility(View.VISIBLE);
        }
        if(p<=200){
            player = MediaPlayer.create(this,R.raw.defeat);
            player.start();
            describe.setText("「該回家洗洗睡了，好像也沒做什麼特別的事，白白浪費一天了，唉~」達達沮喪的說道。今日的達達愁眉不展，他帶著"+priseName[n]+"，拖著沉重的步伐，緩緩地走回家，月亮看了相當不捨，他安慰達達：「達達休憂，勝敗乃兵家常事，何必掛心？擇日再戰，屢敗屢戰，總有一天會成為遊戲天王的！」");
            m=0;
        }
        else if(p>200&&p<=350){
            player = MediaPlayer.create(this,R.raw.bad);
            player.start();
            describe.setText("「鐵板燒真的好好吃，期末考完再來吃！」達達說道。達達嫌棄地戴上他的"+priseName[n]+"，和月亮去便利商店買健達出奇蛋，可惜已經賣光了，達達就這樣度過了平凡的一天。月亮說：「好可惜，改天再來買健達出奇蛋吧！」");
            m=1;
        }
        else if(p>350&&p<=480){
            player = MediaPlayer.create(this,R.raw.win);
            player.start();
            describe.setText("「整個身心舒暢啊~如果能吃到健達出奇蛋，今天就圓滿了！」達達開心的說道。達達帶著"+priseName[n]+"，唱著歌，踩著輕快的步伐，今日的達達可以包容所有鳥事，包括奇怪阿姨的爛獎品。月亮笑了笑說：「走吧，我們去把今天圓滿吧！」");
            m=2;
        }
        else if(p>480&&p<=500){
            vic = MediaPlayer.create(this,R.raw.victory);
            player = MediaPlayer.create(this,R.raw.victory_bgm);
            vic.start();
            player.start();
            describe.setText("「今天的我，彷彿征服了全世界！我是遊戲天王！」達達興奮的喊著。今日的達達勢如破竹，他帶著戰利品"+priseName[n]+"揚長而去，在夕陽餘暉下，月亮看著達達瀟灑的背影，不經讚嘆：「偉哉達達！今天彷彿看了一場英雄電影，達達可以加入婦愁者聯盟了！」");
            m=3;
        }
    }

    public void next(View v){

        click= MediaPlayer.create(this,R.raw.click);
        click.start();
        gv = (GlobalClass)getApplicationContext();
        int find = gv.getFindPoints();
        int bet = gv.getBetPoints();
        int idiom = gv.getIdiomPoints();
        int knowledge = gv.getKnowledgePoints();
        int n = gv.getPrise();
        btn.setText("回主畫面");
        double t1 = find/4+bet/5+idiom*3/20+knowledge/4;
        int t2 = gv.getColorPoints();
        double  t3 = bet*2/5+knowledge*2/5+prisePoints[n];
        if(a==false){
            btn.setText("回主畫面");
            describe.setText(String.format("智力：%.0f/100",t1)+"\n反應："+String.valueOf(t2)+String.format("/100\n運氣：%.0f/100",t3)+"\n心情："+String.valueOf(mood[m])+"/100");
            a=true;
        }
        else{
            click= MediaPlayer.create(this,R.raw.click);
            click.start();
            player.release();
            btn.setText("回主畫面");

            //getIntent().setClass(LastPage.this,MainActivity.class);
            Intent it=new Intent(getApplication(),MainActivity.class);
          //  it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           // it.putExtra("EXIT",true);
            startActivity(it);
          //  finish();
           // System.exit(0);
        }
    }
}