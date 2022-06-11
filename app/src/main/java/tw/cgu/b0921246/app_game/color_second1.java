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

public class color_second1 extends AppCompatActivity implements SensorEventListener {
    private GlobalClass gv;
    MediaPlayer player,clickB,C;
    SensorManager sm;
    EditText answer;
    Sensor psr, gsr;
    View layout;
    Button confirm,next,giveup1;
    TextView txv,end;
    int count = 0;

    String correct="紅綠藍黃藍";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_second1);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        layout = findViewById(R.id.layout);
        txv =findViewById(R.id.txv);
        end=findViewById(R.id.end);
        confirm=findViewById(R.id.confirm);
        next=findViewById(R.id.next);
        answer=findViewById(R.id.answer);

        giveup1=findViewById(R.id.giveup1);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        psr = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);  //接近感測器

        gsr = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);  //陀螺儀




        new CountDownTimer(5000, 3000) {

            public void onTick(long millisUntilFinished) {
                txv.setText("倒數 " + millisUntilFinished / 3000 + "秒");
            }

            public void onFinish() {
                txv.setText("時間到");
                count++;
                confirm.setVisibility(View.VISIBLE);
                answer.setVisibility(View.VISIBLE);
                end.setVisibility(View.VISIBLE);
                layout.setBackgroundResource((R.drawable.bgr));

            }
        }.start();
    }

    SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.values[2] > 0.5f) {
                if (count == 0) {
                    layout.setBackgroundColor(Color.BLUE);   //左
                } else if (count == 1) {
                    layout.setBackgroundColor(Color.WHITE);

                }
            } else if (event.values[2] < -0.5f) {
                if (count == 0) {
                    layout.setBackgroundColor(Color.YELLOW);   //右
                } else if (count == 1) {
                    layout.setBackgroundColor(Color.WHITE);

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
            if (event.values[0] < psr.getMaximumRange()) {
                if (count == 0) {
                    layout.setBackgroundColor(Color.RED);  //遮
                } else if (count == 1) {
                    layout.setBackgroundColor(Color.WHITE);

                }
            } else {
                if (count == 0) {
                    layout.setBackgroundColor(Color.GREEN);   //放
                }
                else if (count == 1) {
                    layout.setBackgroundColor(Color.WHITE);

                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    protected void onResume() {
        color_second1.super.onResume();
        sm.registerListener(gyroscopeSensorListener, gsr, SensorManager
                .SENSOR_DELAY_NORMAL);
        sm.registerListener(proximitySensorListener, psr, 2 * 1000 * 1000);

    }

    protected void onPause() {
        color_second1.super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void next(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        int score1=30;
        Intent it2 = new Intent(this,color_one2.class);

        it2.putExtra("分數1",score1);


//new一個Bundle物件，並將要傳遞的資料傳入
        //  Bundle bundle1 = new Bundle();
        // bundle1.putInt("分數1",score1 );//傳遞Double
//將Bundle物件傳給intent
        //it2.putExtras(bundle1);


        startActivity(it2);
    }

    public void giveup1(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        gv = (GlobalClass)getApplicationContext();
        gv.setPlayer(player);
        int score1=0;
        Intent it2 = new Intent(this,color_one2.class);

        it2.putExtra("分數1",score1);


        startActivity(it2);

    }

    public void confirm(View view){
        String input=answer.getText().toString().trim();
        if(input.equals(correct)){
            C = MediaPlayer.create(this,R.raw.correct);
            C.start();
            end.setText("答案正確!!!!!");
            next.setVisibility(View.VISIBLE);
            layout.setBackgroundResource((R.drawable.bgr));

        }else{
            C = MediaPlayer.create(this,R.raw.incorrect);
            C.start();
            giveup1.setVisibility(View.VISIBLE);
            end.setText("答案錯誤\n返回上一頁再試一次");
            layout.setBackgroundResource((R.drawable.bgr));
        }
    }

}