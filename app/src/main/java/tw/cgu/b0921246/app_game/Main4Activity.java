package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void go(View v){

        Intent it1=new Intent(this,Main5Activity.class);
        startActivity(it1);
    }
}
