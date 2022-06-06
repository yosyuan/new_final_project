package tw.cgu.b0921246.app_game;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main8Activity extends AppCompatActivity {

    private GlobalClass gv;
    TextView dialogue,points;
    String[][] text ={
            {"奇怪阿姨：恭喜你們獲得\"工業風警示立牌\"一枚！希望你們會喜歡我們的作品，掰掰！",
                    "達達：等等，這不就一般的小心地板濕滑標語嗎？爛透了，臭騙子！",
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
        gv = (GlobalClass)getApplicationContext();
        int p = gv.getTotalPoints();
        points.setText("points："+String.valueOf(p));
    }

    public  void go(View v){
        //if(colorPoints<=)
    }
}
