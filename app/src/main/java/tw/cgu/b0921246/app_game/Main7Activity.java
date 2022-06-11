package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main7Activity extends AppCompatActivity {

    private GlobalClass gv;
    TextView dialogue,points;
    boolean text = false;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        dialogue = (TextView) findViewById(R.id.txv7);
        points=findViewById(R.id.p6);
        i1=findViewById(R.id.imageView26);
        gv = (GlobalClass)getApplicationContext();
        int p = gv.getTotalPoints();
        points.setText("points："+String.valueOf(p));

    }

    public void go(View v){
        if(text == false){
            i1.setVisibility(View.GONE);
            dialogue.setText("奇怪阿姨：同學~可以幫我說聲加油嗎？我是馬扁大學的設計系學生，我們來玩個遊戲，如果你得分越高就可以獲得越好的獎品喔~獎品都是我們花很多時間設計出來的作品！玩一次只要付三百塊喔~");
            text = true;
        }
        else{
            //這裡要連到王和涂的遊戲
            Intent it1=new Intent(this,color.class);
            startActivity(it1);
           // Intent it1=new Intent(this,Main8Activity.class);
            //startActivity(it1);
        }
    }
}
