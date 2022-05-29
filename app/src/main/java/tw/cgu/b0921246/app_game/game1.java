package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1 extends AppCompatActivity implements DialogInterface.OnClickListener {

    TextView txv,point;
    Button btn1,btn2,btn4;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        txv=findViewById(R.id.textView);
        point=findViewById(R.id.point);
        btn1=findViewById(R.id.btn1);
        btn4=findViewById(R.id.btn4);
        new AlertDialog.Builder(this)
                .setMessage("找出該關想要找出的物件，總共有5小關，每關可獲得20分\n準備好了嗎!")
                .setCancelable(false)
                .setTitle("歡迎來到威力在哪裡")
                .setPositiveButton("準備好了",this)
                .setNeutralButton("還沒好",this)
                .setNegativeButton(" ",null)
                .show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        if (i==DialogInterface.BUTTON_POSITIVE){
            txv.getText().toString();
        }else if (i==DialogInterface.BUTTON_NEUTRAL){
            finish();
        }
    }

    public void ture(View view) {
            Intent it1=new Intent(this,game2.class);
            startActivity(it1);
            point.setText("得分："+String.valueOf(count+=20));
            return;
    }
    public void giveup(View view){
        Intent it1=new Intent(this,game2.class);
        startActivity(it1);
        point.setText("得分：0");
    }
    public void goback(View view){
        Intent it1=new Intent(this,MainActivity.class);
        startActivity(it1);
    }
          /*  if (count==0){
        AlertDialog.Builder bdr=new AlertDialog.Builder(this);
        bdr.setMessage("找出唯一長角的人物\n按返回鍵繼續遊戲").setTitle("提示剩餘2次")
                .setCancelable(true).show();
        count++;
    }

        if (count==1){
        AlertDialog.Builder bdr2=new AlertDialog.Builder(this);
        bdr2.setMessage("位於第一列\n按返回鍵繼續遊戲").setTitle("提示剩餘1次")
                .setCancelable(true).show();
        count=count+2;
    }*/

}
