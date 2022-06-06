package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main5Activity extends AppCompatActivity {

    private GlobalClass gv;
    TextView dialogue,points;

    boolean text = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        dialogue = (TextView) findViewById(R.id.textView16);
        points=findViewById(R.id.p4);
        gv = (GlobalClass)getApplicationContext();
        int p = gv.getTotalPoints();
        points.setText("points："+String.valueOf(p));
    }
    public void go(View v){
        if(text==true){
            Intent it1=new Intent(this,knowledge.class);
            startActivity(it1);
        }
        else {
            //廚師圖片出現
            dialogue.setText("廚師：我親愛的客人們，我們來玩個小遊戲吧！如果你們得分越高，我就做越高級的甜點給你們吃，不過...題目可不簡單喔！");
            text = true;
        }
    }
}
