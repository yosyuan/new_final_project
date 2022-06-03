package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class game5 extends AppCompatActivity implements DialogInterface.OnClickListener, ImageView.OnTouchListener {

    Button btn8,btn9;
    TextView point5;
    private float x,y;
    private int mx,my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5);

        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        point5=findViewById(R.id.point5);

        int[] image = {R.id.e1, R.id.e2, R.id.e3, R.id.e4, R.id.e5,R.id.e6,R.id.e7,R.id.e8,R.id.e9,
        R.id.e10,R.id.e11};
        for (int imageview : image) {
            findViewById(imageview).setOnTouchListener(this);
        }

        new AlertDialog.Builder(this)
                .setMessage("這關跟第四關遊戲方式一樣，快來找出要找的東西吧!")
                .setCancelable(false)
                .setTitle("歡迎來到最後一關！")
                .setIcon(android.R.drawable.btn_star_big_off)
                .setPositiveButton("準備好了",this)
                .setNeutralButton("回到遊戲主頁",this)
                .setNegativeButton("回到上一個遊戲 ",this)
                .show();
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        point5.setText(data);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i==DialogInterface.BUTTON_POSITIVE){
        }else if (i==DialogInterface.BUTTON_NEUTRAL){
            Intent it1=new Intent(this,MainActivity.class);
            startActivity(it1);
        }else if(i==DialogInterface.BUTTON_NEGATIVE){
            Intent it1=new Intent(this,game4.class);
            startActivity(it1);
        }
    }
    public void goback(View v){
        Intent it1 = new Intent(this, MainActivity.class);
        startActivity(it1);
    }
    public void giveup(View view){
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        int data5=Integer.parseInt(data);
        point5.setText(String.valueOf(data5));

        Intent it1 = new Intent(this, finalpoint.class);
        //String data6=point5.getText().toString();
        //it1.putExtra("分數",data6);
        startActivity(it1);
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x=motionEvent.getX();
                y=motionEvent.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                mx=(int)(motionEvent.getRawX()-x);
                my=(int)(motionEvent.getRawY()-y);
                view.layout(mx,my,mx+view.getWidth(),my+view.getHeight());
                break;
        }
        Log.e("address",String.valueOf(mx)+"~~"+String.valueOf(my));



        return true;
    }
    public void ture(View view) {
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        int data5=Integer.parseInt(data)+20;
        point5.setText(String.valueOf(data5));

        Intent it1 = new Intent(this, finalpoint.class);
        String data6=point5.getText().toString();
        //String data2=point2.getText().toString();
        it1.putExtra("分數",data6);
        startActivity(it1);
    }
}
