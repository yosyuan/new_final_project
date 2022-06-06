package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class color extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        TextView txv=findViewById(R.id.line);
        txv.setText("按照螢幕上的手勢順序做出相對應的動作，再將出現的顏色逐一填至空格中");
    }
    public void start(View view){
        Intent it0=new Intent(this,color_one1.class);
        startActivity(it0);}
}