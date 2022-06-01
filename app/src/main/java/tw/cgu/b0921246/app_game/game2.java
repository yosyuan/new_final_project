package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class game2 extends AppCompatActivity implements DialogInterface.OnClickListener, ImageView.OnClickListener {

    //int[]count={0,20,40,60,80,100};
    TextView txv,point2;
    //private int count[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        txv = findViewById(R.id.textView3);
        point2=findViewById(R.id.point2);
        //count=game1.count;
        int[] image = {R.id.i1, R.id.i2, R.id.i3, R.id.i4, R.id.i5, R.id.i6,
                R.id.i7, R.id.i8, R.id.i9};
        for (int imageview : image) {
            findViewById(imageview).setOnClickListener(this);
        }
        //String point1=getIntent().getStringExtra("分數");
        //point2.setText(point1);
        //Intent it=new Intent(this,game1.class);
        //it.putExtra("分數",count);
        //startActivityForResult(it);
        Intent it=getIntent();
        int num=it.getIntExtra("分數",0);
        point2.setText(num);
        new AlertDialog.Builder(this)
                .setMessage("這關可以點擊物件會讓物件消失，接著來找出要找的東西吧!")
                .setCancelable(false)
                .setTitle("歡迎來到第二關！")
                .setIcon(android.R.drawable.btn_star_big_off)
                .setPositiveButton("準備好了", this)
                .setNeutralButton("回到遊戲主頁", this)
                .setNegativeButton("回到上一個遊戲 ",this)
                .show();

        /*count= Integer.parseInt(String.valueOf(findViewById(R.id.point)));
        if (count>=20){
            point2.setText(String.valueOf(count=20));
        }else if (count==0)
            point2.setText(String.valueOf(count));*/
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        if (i == DialogInterface.BUTTON_POSITIVE) {

        } else if (i == DialogInterface.BUTTON_NEUTRAL) {
            Intent it1 = new Intent(this, MainActivity.class);
            startActivity(it1);
        }else if(i==DialogInterface.BUTTON_NEGATIVE) {
            Intent it1 = new Intent(this, game1.class);
            startActivity(it1);
        }
    }

    @Override
    public void onClick(View view) {
        int visible;
        if (view.getId() == R.id.i1) {
            visible = View.GONE;
            findViewById(R.id.i1).setVisibility(visible);
        } else if (view.getId() == R.id.i2) {
            visible = View.GONE;
            findViewById(R.id.i2).setVisibility(visible);
        } else if (view.getId() == R.id.i3) {
            visible = View.GONE;
            findViewById(R.id.i3).setVisibility(visible);
        } else if (view.getId() == R.id.i4) {
            visible = View.GONE;
            findViewById(R.id.i4).setVisibility(visible);
        } else if (view.getId() == R.id.i5) {
            visible = View.GONE;
            findViewById(R.id.i5).setVisibility(visible);
        } else if (view.getId() == R.id.i6) {
            visible = View.GONE;
            findViewById(R.id.i6).setVisibility(visible);
        } else if (view.getId() == R.id.i7) {
            visible = View.GONE;
            findViewById(R.id.i7).setVisibility(visible);
        } else if (view.getId() == R.id.i8) {
            visible = View.GONE;
            findViewById(R.id.i8).setVisibility(visible);
        } else if (view.getId() == R.id.i9) {

            Intent it1 = new Intent(this, game3.class);
            startActivity(it1);
            return;

        }
    }
    public void goback(View view){
        Intent it1=new Intent(this,MainActivity.class);
        startActivity(it1);
    }
    public void giveup(View view){
        Intent it2 = new Intent(this, game3.class);
        //point.setText(count[0]);
        //it2.putExtra("分數",point.getText());
        startActivity(it2);
    }
}