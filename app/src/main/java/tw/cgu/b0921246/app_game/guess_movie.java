package tw.cgu.b0921246.app_game;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class guess_movie extends AppCompatActivity implements DialogInterface.OnClickListener {

    private GlobalClass gv;
    MediaPlayer player,clickB,C;
    EditText input;
    Button help,confirm,next,goback,tryagain,go,giveup;
    TextView clue,score,title,answer,end;
    String[] correct={"小美人魚","美女與野獸","花木蘭","海洋奇緣","冰雪奇緣"};
    String[] wordclue={"小","美","花","海","冰"};
    String[] sentence={"四個字","五個字","三個字","四個字","四個字"};

    int counter=1;
    int point=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_movie);
        gv = (GlobalClass)getApplicationContext();
        player = gv.getPlayer();
        player.start();
        go=findViewById(R.id.go2);
        input=(EditText)findViewById(R.id.input);
        help=(Button)findViewById(R.id.help);
        confirm=(Button)findViewById(R.id.confirm);
        next=(Button)findViewById(R.id.next);
        goback=(Button)findViewById(R.id.goback);
        tryagain=(Button)findViewById(R.id.tryagain);
        clue=(TextView)findViewById(R.id.clue);
        score=(TextView)findViewById(R.id.score);
        title=(TextView)findViewById(R.id.title);
        answer=(TextView)findViewById(R.id.answer);
        end=(TextView)findViewById(R.id.end);
        giveup=findViewById(R.id.tryagain2);

        title.setText("迪士尼電影題:"+counter+"/5");

        score.setText("目前得分:"+point+"分");
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        if (i == DialogInterface.BUTTON_POSITIVE){   //sentence clue
            clue.setText("提示:"+sentence[counter-1]);
            point=point-10;
            score.setText("目前得分:"+point+"分");
        }else if (i == DialogInterface.BUTTON_NEUTRAL){    //no need clue
            clue.setText("");
        }else if (i == DialogInterface.BUTTON_NEGATIVE){    //word clue
            clue.setText("提示:"+wordclue[counter-1]);
            point=point-5;
            score.setText("目前得分:"+point+"分");
        }
    }
    public void clue(View view ){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        new AlertDialog.Builder(this)
                .setMessage("選擇提示第一個字分數將扣5分\n選擇字數提示將扣10分")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_menu_edit)
                .setTitle("需要提示嗎?")
                .setPositiveButton("字數提示",this)
                .setNeutralButton("不需要",this)
                .setNegativeButton("給第一個字提示",this)
                .show();
    }
    public void next(View view){
        counter++;
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        title.setText("迪士尼電影題:"+counter+"/5");
        next.setVisibility(View.GONE);
        help.setVisibility(View.VISIBLE);
        input.setText("");
        answer.setText("");
        if(counter==2){
            findViewById(R.id.picmovie1).setVisibility(View.GONE);
            findViewById(R.id.picmovie2).setVisibility(View.VISIBLE);
        }
        else if(counter==3){
            findViewById(R.id.picmovie2).setVisibility(View.GONE);
            findViewById(R.id.picmovie3).setVisibility(View.VISIBLE);
        }else if(counter==4){
            findViewById(R.id.picmovie3).setVisibility(View.GONE);
            findViewById(R.id.picmovie4).setVisibility(View.VISIBLE);
        }else if(counter==5){
            findViewById(R.id.picmovie4).setVisibility(View.GONE);
            findViewById(R.id.picmovie5).setVisibility(View.VISIBLE);
            next.setText("分數總結");

        }else {
            end.setVisibility(View.VISIBLE);
            findViewById(R.id.picmovie5).setVisibility(View.GONE);
            next.setVisibility(View.GONE);
            input.setVisibility(View.GONE);
            confirm.setVisibility(View.GONE);
            clue.setVisibility(View.GONE);
            title.setVisibility(View.GONE);
            help.setVisibility(View.GONE);
            goback.setVisibility(View.GONE);
            giveup.setVisibility(View.GONE);
            if (point < 80) {
                C = MediaPlayer.create(this,R.raw.incorrect);
                C.start();
                end.setText("闖關失敗");
                go.setVisibility(View.VISIBLE);
                tryagain.setVisibility(View.VISIBLE);
            } else {
                C = MediaPlayer.create(this,R.raw.correct);
                C.start();
                end.setText("恭喜過關");
                go.setVisibility(View.VISIBLE);

            }
        }
    }

    public void goback(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        player.release();
        Intent it=new Intent(this,guess.class);
        startActivity(it);

    }
    public void confirm(View view){
        String input1 = input.getText().toString().trim();
        if (input1.length()==0){                              //未輸入
            answer.setText("請於上方輸入答案");
        }else{
            if(input1.equals(correct[counter-1])){     //答案正確
                C = MediaPlayer.create(this,R.raw.correct2);
                C.start();
                answer.setText("答案正確!!");
                next.setVisibility(View.VISIBLE);
                help.setVisibility(View.GONE);
                clue.setText("");

                point=point+20;
                score.setText("目前得分:"+point+"分");
//                goback.setVisibility(View.GONE);
            }else{
                C = MediaPlayer.create(this,R.raw.incorrect2);
                C.start();
                answer.setText("答案錯誤!!");     //答案錯誤
            }
        }

    }
    public void tryagain(View view){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        player.release();
        Intent it= new Intent(this,guess.class);
        startActivity(it);
    }
    public void go (View v){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        player.release();
        gv = (GlobalClass)getApplicationContext();
        gv.setIdiomPoints(point);
        int k=gv.getTotalPoints();
        k+=point;
        gv.setTotalPoints(k);
        Intent it1=new Intent(this,Main4Activity.class);
        startActivity(it1);
    }

}
