package tw.cgu.b0921246.app_game;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class color_second3 extends AppCompatActivity implements SensorEventListener,View.OnTouchListener {

    private GlobalClass gv;
    MediaPlayer player,clickB,C;
    SensorManager sm3;
    EditText answer3;
    Sensor psr3, gsr3;
    View layout3;
    Button confirm3, next3,giveup3;
    TextView txv3, end3,cule;
    int count3 = 0;
    String correct3 = "黃紅藍綠粉";
    int sum4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_second3);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        layout3 = findViewById(R.id.layout3);
        txv3 = findViewById(R.id.txv3);
        end3 = findViewById(R.id.end3);
        confirm3 = findViewById(R.id.confirm3);
        next3 = findViewById(R.id.next3);
        answer3 = findViewById(R.id.answer3);
        giveup3=findViewById(R.id.giveup3);
        cule=findViewById(R.id.textView20);

        sm3 = (SensorManager) getSystemService(SENSOR_SERVICE);
        psr3 = sm3.getDefaultSensor(Sensor.TYPE_PROXIMITY);  //接近感測器

        gsr3 = sm3.getDefaultSensor(Sensor.TYPE_GYROSCOPE);  //陀螺儀
        layout3.setOnTouchListener(this);

        Intent it5=getIntent();
        int end33=it5.getIntExtra("分數2",0);
        sum4=end33;

        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                txv3.setText("倒數 " + millisUntilFinished / 1000 + "秒");
            }

            public void onFinish() {
                txv3.setText("時間到");
                count3++;
                confirm3.setVisibility(View.VISIBLE);
                answer3.setVisibility(View.VISIBLE);
                end3.setVisibility(View.VISIBLE);
                cule.setVisibility(View.GONE);
                layout3.setBackgroundResource((R.drawable.bgr));

            }
        }.start();
    }
    SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            if (event.values[2] > 0.3f) {
                if (count3 == 0) {
                    layout3.setBackgroundColor(Color.BLUE);   //左
                } else if (count3 == 1) {
                    layout3.setBackgroundColor(Color.WHITE);

                }
            } else if (event.values[2] < -0.3f) {
                if (count3 == 0) {
                    layout3.setBackgroundColor(Color.YELLOW);   //右
                } else if (count3 == 1) {
                    layout3.setBackgroundColor(Color.WHITE);

                }
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


    SensorEventListener proximitySensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.values[0] < psr3.getMaximumRange()) {
                if (count3 == 0) {
                    layout3.setBackgroundColor(Color.RED);  //遮
                } else if (count3 == 1) {
                    layout3.setBackgroundColor(Color.WHITE);
                }
            } else {
                if (count3 == 0) {
                    layout3.setBackgroundColor(Color.GREEN);   //放
                } else if (count3 == 1) {
                    layout3.setBackgroundColor(Color.WHITE);

                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    protected void onResume() {
        color_second3.super.onResume();
        sm3.registerListener(gyroscopeSensorListener, gsr3, SensorManager
                .SENSOR_DELAY_NORMAL);
        sm3.registerListener(proximitySensorListener, psr3, 2 * 1000 * 1000);

    }

    protected void onPause() {
        color_second3.super.onPause();
        sm3.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void confirm3(View view) {
        String input = answer3.getText().toString().trim();
        if (input.equals(correct3)) {
            C = MediaPlayer.create(this,R.raw.correct);
            C.start();
            end3.setText("答案正確!!!!");
            next3.setVisibility(View.VISIBLE);
            layout3.setBackgroundResource((R.drawable.bgr));

        } else {
            C = MediaPlayer.create(this,R.raw.incorrect);
            C.start();
            giveup3.setVisibility(View.VISIBLE);
            end3.setText("答案錯誤\n返回上一頁再試一次");
            layout3.setBackgroundResource((R.drawable.bgr));
        }
    }
    public void giveup3(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        //int score3=0;
        Intent it6=new Intent(this,color_finalscore.class);
        it6.putExtra("分數3",sum4);
        startActivity(it6);

//new一個Bundle物件，並將要傳遞的資料傳入
        //Bundle bundle3 = new Bundle();
        //bundle3.putInt("分數3",score3);//傳遞Double
//將Bundle物件傳給intent
        //it6.putExtras(bundle3);
        //startActivity(it6);

    }

    public void next3(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        int score3=40;
        int fin1=score3+sum4;
        Intent it6=new Intent(this,color_finalscore.class);
        it6.putExtra("分數3",fin1);
        startActivity(it6);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            layout3.setBackgroundColor(Color.parseColor("#FF00FF"));

        }
        else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            layout3.setBackgroundColor(Color.parseColor("#FF00FF"));
        }
        else if (event.getAction() == MotionEvent.ACTION_UP) {
            layout3.setBackgroundColor(Color.WHITE);
        }
        return true;

    }

}