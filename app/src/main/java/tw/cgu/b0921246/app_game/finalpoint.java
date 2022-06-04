package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class finalpoint extends AppCompatActivity {

    TextView point6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpoint);
        point6=findViewById(R.id.point6);

        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        point6.setText("總分："+data);
    }
    public void sure(View v){
        Intent it1 = new Intent(this, bet.class);
        startActivity(it1);
    }
}
