package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class game1 extends AppCompatActivity implements DialogInterface.OnClickListener,ImageView.OnTouchListener{

    TextView txv,point;
    ImageView image;
    Button btn1,btn2,btn4;
    public int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        txv=findViewById(R.id.textView);
        point=findViewById(R.id.point);
        image=findViewById(R.id.imageView23);
        int[] image = {R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5,
        R.id.imageView6,R.id.imageView7,R.id.imageView8,R.id.imageView9,R.id.imageView10,R.id.imageView11};
        for (int imageview : image) {
            findViewById(imageview).setOnTouchListener(this);
        }
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
        point.setText(String.valueOf(count+=20));
        Intent it1= new Intent(this, game2.class);
        String data=point.getText().toString();
        it1.putExtra("分數",data);
        startActivity(it1);
    }
    public void giveup(View view){
        Intent it2 = new Intent(this, game2.class);
        point.setText(String.valueOf(count));
        String data="0";
        it2.putExtra("分數",data);
        startActivity(it2);
    }
    public void goback(View view){
        Intent it1 = new Intent(this, MainActivity.class);
        startActivity(it1);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Vibrator vb= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
            vb.vibrate(1000);
        }else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
            vb.cancel();
        }
        return true;
    }
}
