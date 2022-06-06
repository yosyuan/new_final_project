package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class color_one1 extends AppCompatActivity {

    TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_one1);

        question=(TextView) findViewById(R.id.question);
        question.setText("手遮住螢幕、手打開遮住的螢幕、向左傾、向右傾、向左傾");
    }
    public void begin(View view){
        Intent it1=new Intent(this,color_second1.class);
        startActivity(it1);
    }
}