package tw.cgu.b0921246.app_game;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class knowledge extends AppCompatActivity implements DialogInterface.OnClickListener,AdapterView.OnItemClickListener {

    private GlobalClass gv;
    MediaPlayer player,clickB,C;
    String[] subjects = {"地理","語文","科學","魔法","藝術"};
    String[][] questions = {
            {"世界上最大的平原是？",
                    "越南的首都是？",
                    "賽德克族在2008年以前被歸類在哪一族?",
                    "歐洲第二大河多瑙河，最終注入哪片海？",
                    "下列哪個國家/地區有最高的人口密度？"},

            {"下列何者非唐宋八大家？",
                    "哪個詩社強調抒情，種個人創作自由？",
                    "下列哪個選項有\"明白\"之意？",
                    "I ___ my alarm before going to bed.",
                    "片語\"high and dry\"是指"},

            {"誰首先提出能量是不連續的？",
                    "食醋的主要成分是？",
                    "太陽系中體積最大的行星是？",
                    "世界上體型最大的動物是？",
                    "下列何者是脂溶性維生素？"},

            {"小花的魔法咒語是？",
                    "神仙教母的咒語是？",
                    "當你躺在床上，想要拿桌上的零食但懶得起身，可以使用以下哪個咒語？",
                    "下列哪把掃帚飛得最快？",
                    "下列哪一個不是黑魔法？"},
            {"下列哪位音樂家被譽為\"圓舞曲之王\"?",
                    "名畫《最後的晚餐》是哪位畫家的作品？",
                    "下列何者並非英國莎士比亞的四大悲劇作品？",
                    "下列何者並非查理卓別林的作品？",
                    "下列哪位歌手沒有得過金曲獎？"
            }
    };

    String[][][] answers = {
            {{"西西伯利亞平原","東歐平原","亞馬遜平原"},//2
                    {"河內","峴港","胡志明市"},//0
                    {"太魯閣族", "泰雅族", "阿美族"},//1
                    {"地中海","愛琴海","黑海"},//2
                    {"澳門","香港","新加坡"}}, //0

            {{"曾鞏","王維","柳宗元"}, //1
                    {"藍星詩社","創世紀詩社","笠詩社"}, //0
                    {"I crush on...","I bump into...","It dawn on me..."}, //2
                    {"set out","set off","set up"}, //2
                    {"無權無勢","處於困境","風雨無阻"}},//1

            {{"普朗克","馬克士威","愛因斯坦"}, //0
                    {"乙酸","乙酸乙酯","甲醇"}, //0
                    {"土星","木星","海王星"}, //1
                    {"鯨鯊","藍鯨","南極大王魷"}, //1
                    {"維生素B","維生素C","維生素D"}}, //2

            {{"霹靂卡霹靂拉拉 波波力那貝貝魯多","波囉林 噗哇林 哈那哈那披","佩魯坦佩登 啪拉力拉碰"}, //1
                    {"Bibbidi Bibbidi Boo","Bibbidi Bibbodi Boo","Bibbidi Bobbidi Boo"}, //2
                    {"Expelliarmus","Accio","Lumos"}, //1
                    {"光輪2000","火閃電","狂風十一號"}, //0
                    {"酷刑咒","撕淌三步殺","吼吼燒"}}, //2

            {{"約翰·塞巴斯蒂安·巴哈","彼得·柴可夫斯基","小約翰·史特勞斯"}, //2
                    {"李奧納多·達文西","米開朗基羅·博那羅蒂","巴勃羅·畢卡索"}, //0
                    {"馬克白","第十二夜","哈姆雷特"}, //1
                    {"淘金記","摩登時代","紅樓金粉"}, //2
                    {"吳卓源","徐佳瑩","艾怡良"}} //0
    };
    TextView s, q, txvp;
    Button next;
    Random x = new Random();
    //int n =x.nextInt(5); //0~4
    int a=0,points=0,c;
    boolean b=false;
    int[] used;
    //  String p= Integer.toString(points);
    Toast sbar;
    ListView lv;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);
        player = MediaPlayer.create(this,R.raw.game);
        player.start();
        next=(Button) findViewById(R.id.nextpage);
        s=(TextView) findViewById(R.id.subject);
        q=(TextView) findViewById(R.id.question);
        txvp=(TextView) findViewById(R.id.txvp);
        s.setTextColor(Color.rgb(166,106,177));
        txvp.setTextColor(Color.rgb(0,127,172));
        int m =x.nextInt(5);
        s.setText(subjects[a]);
        q.setText(questions[a][m]);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,answers[a][m]);
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        c=m;
        used = new int[5];
        used[0]=m;
        sbar=Toast.makeText(this,"",Toast.LENGTH_SHORT);
       /* new AlertDialog.Builder(this)
                .setMessage("在這個關卡裡面會有十題選擇題，五種題型，答對一題就能獲得10分，加油！")
                .setCancelable(false)
                .setTitle("歡迎來到智慧王關卡")
                .setPositiveButton("開始挑戰!",this)
                .setNeutralButton("",null)
                .setNegativeButton(" ",null)
                .show();*/
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.bulb3)
                .setTitle("歡迎來到智慧王關卡")
                .setMessage("在這個關卡裡面會有十題選擇題，五種題型，答對一題就能獲得10分，加油！")
                .setPositiveButton("開始挑戰!", (DialogInterface.OnClickListener) this)
                .show();



        //sbar = Snackbar.make (findViewById(R.id.root),"",Snackbar.LENGTH_SHORT);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if ((a==0&&((c == 0 && i == 2) || (c == 1 && i == 0) || (c == 2 && i == 1) || (c == 3 && i == 2) || (c == 4 && i == 0)))||
                (a==1&&((c == 0 && i == 1) || (c == 1 && i == 0) || (c == 2 && i == 2) || (c == 3 && i == 2) || (c == 4 && i == 1)))||
                (a==2&&((c == 0 && i == 0) || (c == 1 && i == 0) || (c == 2 && i == 1) || (c == 3 && i == 1) || (c == 4 && i == 2)))||
                (a==3&&((c == 0 && i == 1) || (c == 1 && i == 2) || (c == 2 && i == 1) || (c == 3 && i == 0) || (c == 4 && i == 2)))||
                (a==4&&((c == 0 && i == 2) || (c == 1 && i == 0) || (c == 2 && i == 1) || (c == 3 && i == 2) || (c == 4 && i == 0)))){
            C = MediaPlayer.create(this,R.raw.correct);
            C.start(); sbar.setText("答對了！");
            sbar.show();
            points+=10;
            String p= Integer.toString(points);
            txvp.setText("分數："+p);

        }
        else {
            C = MediaPlayer.create(this,R.raw.incorrect);
            C.start();
            sbar.setText("答錯了！");
            sbar.show();
        }
        a+=1;
        if(a<=4){
            int m =x.nextInt(5);
            if(b==false){
                used[a]=m;
            }else{
                do{
                    m =x.nextInt(5);}
                while (m==used[a]);
            }
            s.setText(subjects[a]);
            q.setText(questions[a][m]);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,answers[a][m]);
            lv.setAdapter(adapter);
            c=m;
        }
        else if(b==false&&a==5){
            a=0;
            b=true;
            s.setText(subjects[a]);
            int m =x.nextInt(5);
            q.setText(questions[a][m]);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,answers[a][m]);
            lv.setAdapter(adapter);
            c=m;
        }
        else if(b==true&&a==5)
            next.setVisibility(View.VISIBLE);
        /*
        if(a<=4){
            s.setText(subjects[a]);
            int m =x.nextInt(5);
            q.setText(questions[a][m]);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,answers[a][m]);
            lv.setAdapter(adapter);
            c=m;
        }
        else
            next.setVisibility(View.VISIBLE);*/
    }

    public void nextpage(View v){
        clickB = MediaPlayer.create(this,R.raw.click);
        clickB.start();
        player.release();
        gv = (GlobalClass)getApplicationContext();
        gv.setKnowledgePoints(points);
        int k=gv.getTotalPoints();
        k+=points;
        gv.setTotalPoints(k);
        points =0;
        Intent it1=new Intent(this,Main6Activity.class);
        startActivity(it1);
        /*String data6=Integer.toString(points);
        it1.putExtra("分數",data6);*/
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
