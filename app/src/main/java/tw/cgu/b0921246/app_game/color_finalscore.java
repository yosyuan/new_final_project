package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class color_finalscore extends AppCompatActivity {

    private GlobalClass gv;
    int score=0;
    int fin3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_finalscore);
        TextView final_score=(TextView)findViewById(R.id.final_score);

        // Intent fin2=getIntent();
        //int final1=fin2.getIntExtra("分數1",0);

        //Intent fin4=getIntent();
        //int final2=fin4.getIntExtra("分數2",0);

        Intent it6=getIntent();
        fin3=it6.getIntExtra("分數3",0);
//
//       score=final3;

        final_score.setText("總分為 :"+fin3);


    }
    public void go(View v){
        gv = (GlobalClass)getApplicationContext();
        gv.setColorPoints(fin3);
        int k=gv.getTotalPoints();
        k+=fin3;
        gv.setTotalPoints(k);
        Intent it=new Intent(this,Main8Activity.class);
        startActivity(it);

    }
}