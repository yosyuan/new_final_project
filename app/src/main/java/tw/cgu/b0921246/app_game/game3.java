package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class game3 extends AppCompatActivity implements DialogInterface.OnClickListener, ImageView.OnClickListener {

    Button btn3,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        int[] image = {R.id.ii1, R.id.ii2, R.id.ii10, R.id.ii4, R.id.ii5, R.id.ii11,
                R.id.ii7, R.id.ii8, R.id.ii9};
        for (int imageview : image) {
            findViewById(imageview).setOnClickListener(this);
        }
        btn3=findViewById(R.id.btn3);
        btn2=findViewById(R.id.btn2);
        new AlertDialog.Builder(this)
                .setMessage("歡迎來到第三關\n這關跟第二關遊戲方式一樣，快來找出要找的東西吧!")
                .setCancelable(false)
                .setTitle("恭喜你答對！")
                .setIcon(android.R.drawable.btn_star_big_off)
                .setPositiveButton("準備好了",this)
                .setNeutralButton("回到遊戲主頁",this)
                .setNegativeButton("回到上一個遊戲 ",this)
                .show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i==DialogInterface.BUTTON_POSITIVE){
        }else if (i==DialogInterface.BUTTON_NEUTRAL){
            Intent it1=new Intent(this,MainActivity.class);
            startActivity(it1);
        }else if(i==DialogInterface.BUTTON_NEGATIVE){
            Intent it1=new Intent(this,game2.class);
            startActivity(it1);
        }
    }

    @Override
    public void onClick(View view) {
        int visible;
        if (view.getId() == R.id.ii1) {
            visible = View.GONE;
            findViewById(R.id.ii1).setVisibility(visible);
        } else if (view.getId() == R.id.ii2) {
            visible = View.GONE;
            findViewById(R.id.ii2).setVisibility(visible);
        } else if (view.getId() == R.id.ii10) {
            visible = View.GONE;
            findViewById(R.id.ii10).setVisibility(visible);
        } else if (view.getId() == R.id.ii4) {
            visible = View.GONE;
            findViewById(R.id.ii4).setVisibility(visible);
        } else if (view.getId() == R.id.ii5) {
            visible = View.GONE;
            findViewById(R.id.ii5).setVisibility(visible);
        } else if (view.getId() == R.id.ii7) {
            visible = View.GONE;
            findViewById(R.id.ii7).setVisibility(visible);
        } else if (view.getId() == R.id.ii8) {
            visible = View.GONE;
            findViewById(R.id.ii8).setVisibility(visible);
        } else if (view.getId() == R.id.ii9) {
            visible = View.GONE;
            findViewById(R.id.ii9).setVisibility(visible);
        } else if (view.getId() == R.id.ii11) {
            //Intent it1 = new Intent(this, game2.class);
            //startActivity(it1);
            //return;            new AlertDialog.Builder(this)
            //                    .setMessage("獲得分數100分")
            //                    .setCancelable(false)
            //                    .setTitle("恭喜你完成這些關卡！")
            //                    .setIcon(android.R.drawable.btn_star_big_off)
            //                    .setPositiveButton("準備好了", this)
            //                    .setNeutralButton("回到遊戲主頁", this)
            //                    .setNegativeButton("回到上一個遊戲 ",this)
            //                    .show();
            Intent it1 = new Intent(this, game4.class);
            startActivity(it1);

        }
    }
    public void goback(View v){
        Intent it1 = new Intent(this, MainActivity.class);
        startActivity(it1);
    }

}
            /*new AlertDialog.Builder(this)
                    .setMessage("獲得分數100分")
                    .setCancelable(true)
                    .setTitle("恭喜你完成這些關卡！\n請按返回鍵並按回到主頁面")
                    .setIcon(android.R.drawable.btn_star_big_off)
                    .show();
                    visible = View.VISIBLE;
                    findViewById(R.id.btn3).setVisibility(visible);*/
