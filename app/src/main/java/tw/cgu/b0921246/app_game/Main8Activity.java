package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class Main8Activity extends AppCompatActivity {

    Random x = new Random();
    int n =x.nextInt(4);
    int a=0;

    ImageView da1,da2,da3,da4;
    //int[] da={R.id.da3,R.id.da1,R.id.da2,R.id.da4};

    private GlobalClass gv;
    TextView dialogue,points;
    String[][] text ={
            {"奇怪阿姨：恭喜你們獲得\"巨無霸甜筒\"一枚！希望你們會喜歡我們的作品，掰掰！",
                    "達達：等等，這不就一般的三角錐嗎？爛透了，臭騙子！",
                    "月亮：等聖誕節再當交換禮物送出去就好了。",
                    "達達：確實。走吧，該回家囉！"},
            {"奇怪阿姨：恭喜你們獲得\"神奇真空魔法吸盤\"一枚！希望你們會喜歡我們的作品，掰掰！",
                    "達達：等等，這不就一般的馬桶吸盤嗎？爛透了，臭騙子！",
                    "月亮：等聖誕節再當交換禮物送出去就好了。",
                    "達達：確實。走吧，該回家囉！"},
            {"奇怪阿姨：恭喜你們獲得\"甜蜜的小窩附贈家庭成員\"！希望你們會喜歡我們的作品，掰掰！",
                    "達達：等等，這是真的鳥巢和鳥蛋吧？爛透了，臭騙子！",
                    "月亮：蠻實用的啊，可養可吃，看你要幾杯。",
                    "達達：我先把你三杯再說。"},
            {"奇怪阿姨：恭喜你們獲得\"鵝鵝水中游\"一枚！希望你們會喜歡我們的作品，掰掰！",
                    "達達：等等，這不就一般的游泳圈嗎？爛透了，臭騙子！",
                    "月亮：可以帶去海邊拍照當網美啊，哈哈哈！",
                    "達達：亡鎂還差不多..."}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        dialogue = (TextView)findViewById(R.id.txv8);
        points=findViewById(R.id.p7);

        da1=findViewById(R.id.da1);
        da2=findViewById(R.id.da2);
        da3=findViewById(R.id.da3);
        da4=findViewById(R.id.da4);

        gv = (GlobalClass)getApplicationContext();
        int p = gv.getTotalPoints();
        points.setText("points："+String.valueOf(p));
        dialogue.setText(text[n][a]);
        gv.setPrise(n);
        if (n==0){
            da3.setVisibility(View.VISIBLE);
        }else if (n==1){
            da1.setVisibility(View.VISIBLE);
        }else if (n==2){
            da2.setVisibility(View.VISIBLE);
        }else {
            da4.setVisibility(View.VISIBLE);
        }



    }

    public  void go(View v){
        if(a<=2) {
            a += 1;

            dialogue.setText(text[n][a]);
        }
        else{
            Intent it1=new Intent(this,LastPage.class);
            startActivity(it1);
        }
    }
}
