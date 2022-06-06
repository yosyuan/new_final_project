package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class finalpoint extends AppCompatActivity {

    private GlobalClass gv;

    TextView points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpoint);
        points=findViewById(R.id.p1);
        gv = (GlobalClass)getApplicationContext();
        int p=gv.getTotalPoints();
        points.setText("points："+String.valueOf(p));

       /* Intent it=getIntent();
        String data=it.getStringExtra("分數");
        point6.setText("總分："+data);*/
    }
    public void sure(View v){
        Intent it1 = new Intent(this, bet.class);
        startActivity(it1);
    }
}
