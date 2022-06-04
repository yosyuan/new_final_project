package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
    public void go(View v){

        Intent it1=new Intent(this,knowledge.class);
        startActivity(it1);
    }
}
