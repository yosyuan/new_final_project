package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sure(View v){

        Intent it1=new Intent(this,Main2Activity.class);
        startActivity(it1);
    }
    public  void exit(View v){
        finish();
    }
    public void trybet(View v){

        Intent it1=new Intent(this,bet.class);
        startActivity(it1);
    }
    public void tryguess(View v){

        Intent it1=new Intent(this,guess.class);
        startActivity(it1);
    }
    public void tryknowedge(View v){

        Intent it1=new Intent(this,knowledge.class);
        startActivity(it1);
    }
    public void trycolor(View v){

        Intent it1=new Intent(this,color.class);
        startActivity(it1);
    }

}
