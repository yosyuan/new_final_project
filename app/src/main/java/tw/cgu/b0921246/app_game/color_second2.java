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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class color_second2 extends AppCompatActivity implements SensorEventListener{

    private GlobalClass gv;
    MediaPlayer player,clickB,C;
    SensorManager sm2;
    EditText answer2;
    Sensor psr2, gsr2;
    View layout2;
    Button confirm2,next2,giveup2;
    TextView txv2,end2,tv7,cule;
    int count2 = 0;
    String correct2="黑黃紅藍";
    int sum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_second2);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        layout2 = findViewById(R.id.layout2);
        txv2 =findViewById(R.id.txv2);
        end2=findViewById(R.id.end2);
        confirm2=findViewById(R.id.confirm2);
        next2=findViewById(R.id.next2);
        answer2=findViewById(R.id.answer2);
        cule=findViewById(R.id.textView19);

        giveup2=findViewById(R.id.giveup2);
        sm2 = (SensorManager) getSystemService(SENSOR_SERVICE);
        psr2 = sm2.getDefaultSensor(Sensor.TYPE_PROXIMITY);  //接近感測器

        gsr2 = sm2.getDefaultSensor(Sensor.TYPE_GYROSCOPE);  //陀螺儀

        Intent it3=getIntent();
        int end22=it3.getIntExtra("分數1",0);
        sum2=end22;
        // tv7=findViewById(R.id.textView7);

        //tv7.setText("分數"+sum2);

        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                txv2.setText("倒數 " + millisUntilFinished / 1000 + "秒");
            }

            public void onFinish() {
                txv2.setText("時間到");
                count2++;
                cule.setVisibility(View.GONE);
                confirm2.setVisibility(View.VISIBLE);
                answer2.setVisibility(View.VISIBLE);
                end2.setVisibility(View.VISIBLE);
                layout2.setBackgroundResource((R.drawable.bgr));

            }
        }.start();
    }
    SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            if (event.values[2] > 0.3f) {
                if (count2 == 0) {
                    layout2.setBackgroundColor(Color.BLACK);   //左

                }
                else if (count2 == 1) {
                    layout2.setBackgroundColor(Color.WHITE);

                }
            } else if (event.values[2] < -0.3f) {
                if (count2 == 0) {
                    layout2.setBackgroundColor(Color.BLUE);   //右

                }
                else if (count2 == 1) {
                    layout2.setBackgroundColor(Color.WHITE);

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
            if (event.values[0] < psr2.getMaximumRange()) {
                if (count2 == 0) {
                    layout2.setBackgroundColor(Color.YELLOW);  //遮

                } else if (count2 == 1) {
                    layout2.setBackgroundColor(Color.WHITE);
                }
            } else {
                if (count2 == 0) {
                    layout2.setBackgroundColor(Color.RED);   //放
                }
                else if (count2 == 1) {
                    layout2.setBackgroundColor(Color.WHITE);

                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    protected void onResume() {
        color_second2.super.onResume();
        sm2.registerListener(gyroscopeSensorListener, gsr2, SensorManager
                .SENSOR_DELAY_NORMAL);
        sm2.registerListener(proximitySensorListener, psr2, 2 * 1000 * 1000);

    }

    protected void onPause() {
        color_second2.super.onPause();
        sm2.unregisterListener((SensorEventListener) this);
    }

    public void giveup2(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        //int score2=0;
        Intent it4=new Intent(this,color_one3.class);
        it4.putExtra("分數2",sum2);
        startActivity(it4);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void confirm2(View view){
        String input=answer2.getText().toString().trim();
        if(input.equals(correct2)){
            C = MediaPlayer.create(this,R.raw.correct);
            C.start();
            end2.setText("答案正確!!!!");
            next2.setVisibility(View.VISIBLE);
            layout2.setBackgroundResource((R.drawable.bgr));

        }else{
            C = MediaPlayer.create(this,R.raw.incorrect);
            C.start();
            giveup2.setVisibility(View.VISIBLE);
            end2.setText("答案錯誤\n返回上一頁再試一次");
            layout2.setBackgroundResource((R.drawable.bgr));
        }
    }
    public void next2(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        int score2=30;
        int fi=sum2+score2;
        Intent it4=new Intent(this,color_one3.class);
        it4.putExtra("分數2",fi);
        startActivity(it4);


    }
}

