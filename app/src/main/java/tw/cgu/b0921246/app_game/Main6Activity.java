package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main6Activity extends AppCompatActivity  {

    private GlobalClass gv;
    TextView dialogue,points;
    ImageView i1,i2,i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        dialogue=findViewById(R.id.textView17);
        points=findViewById(R.id.p5);
        gv = (GlobalClass)getApplicationContext();
        int pp = gv.getTotalPoints();
        points.setText("points："+String.valueOf(pp));
        int p = gv.getKnowledgePoints();
        i1=findViewById(R.id.pudding);
        i2=findViewById(R.id.browine);
        i3=findViewById(R.id.pie);
        if (p==0||p==20){
            dialogue.setText("廚師：今天為你們獻上的甜點是\"低級QQ布丁\"！");
            i1.setVisibility(View.VISIBLE);}
        else if(p==40||p==60){
            dialogue.setText("廚師：今天為你們獻上的甜點是\"頂級榛果脆片布朗尼\"！");
            i2.setVisibility(View.VISIBLE);}
        else if(p==80||p==100){
            dialogue.setText("廚師：今天為你們獻上的甜點是\"究極蜂橙莓果千層派\"！");
            i3.setVisibility(View.VISIBLE);}

        /*Intent it=getIntent();
        String data=it.getStringExtra("分數");
        total.setText("總分："+data);
        String[] point={"0","20","40","60","80","100"};*/
        //int point;
        //point= Integer.parseInt(data);

    }

    public  void go(View v){
        Intent it1=new Intent(this,Main7Activity.class);
        startActivity(it1);
    }
/*
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
      /*  Intent it=getIntent();
        String data=it.getStringExtra("分數");
        total.setText("總分："+data);
        String[] point={"0","20","40","60","80","100"};
        if (point[0]==data||point[1]==data)
            speak.setText("廚師：今天為你們獻上的甜點是\"低級QQ布丁\"！");
        else if(point[2]==data||point[3]==data)
            speak.setText("廚師：今天為你們獻上的甜點是\"頂級榛果脆片布朗尼\"！");
        else if(point[4]==data||point[5]==data)
            speak.setText("廚師：今天為你們獻上的甜點是\"究極蜂橙莓果千層派\"！");
    }
    */
}
