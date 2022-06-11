package tw.cgu.b0921246.app_game;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class bet4 extends AppCompatActivity implements TextWatcher, RadioGroup.OnCheckedChangeListener,
View.OnClickListener, AdapterView.OnItemSelectedListener {

    RadioGroup multt;
    Spinner bigor;
    TextView money500;
    String[] place={"比大","比小"};
    Toast tos;
    Button poi;
    EditText edtmonyy;
    double mon;
    double count=500;
    int pos=0;
    TextView winnig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet4);

        AlertDialog.Builder bdr = new AlertDialog.Builder(this);
        bdr.setMessage("請先選擇賭金倍率，並輸入您要押下的金額，再點下正下方的骰盅搖骰子 \n" +
                "按任意處關閉此交談窗");
        bdr.setTitle("WELCOME!!");
        bdr.setIcon(android.R.drawable.star_on);
        bdr.setCancelable(true);
        bdr.show();

        tos=Toast.makeText(this,"",Toast.LENGTH_SHORT);
        money500 = findViewById(R.id.textView);
        bigor=findViewById(R.id.spinner2);
        bigor.setOnItemSelectedListener(this);
        poi=findViewById(R.id.poi);
        poi.setOnClickListener(this);
        edtmonyy= findViewById(R.id.edtmoney);
        edtmonyy.addTextChangedListener(this);
        multt=findViewById(R.id.mil);
        multt.setOnCheckedChangeListener(this);

        winnig=findViewById(R.id.textView13);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {
        if (edtmonyy.length() == 0) {
            Toast tos = Toast.makeText(this, "請輸入押金", Toast.LENGTH_SHORT);
        } else {
            Random x = new Random();
            int me = x.nextInt(6);
            Random z = new Random();
            int you = z.nextInt(6);
            switch (me) {
                case 0:
                    findViewById(R.id.imageView).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView2).setVisibility(View.GONE);
                    findViewById(R.id.imageView3).setVisibility(View.GONE);
                    findViewById(R.id.imageView5).setVisibility(View.GONE);
                    findViewById(R.id.imageView6).setVisibility(View.GONE);
                    findViewById(R.id.imageView12).setVisibility(View.GONE);
                    break;
                case 1:
                    findViewById(R.id.imageView).setVisibility(View.GONE);
                    findViewById(R.id.imageView2).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView3).setVisibility(View.GONE);
                    findViewById(R.id.imageView5).setVisibility(View.GONE);
                    findViewById(R.id.imageView6).setVisibility(View.GONE);
                    findViewById(R.id.imageView12).setVisibility(View.GONE);
                    break;
                case 2:
                    findViewById(R.id.imageView).setVisibility(View.GONE);
                    findViewById(R.id.imageView2).setVisibility(View.GONE);
                    findViewById(R.id.imageView3).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView5).setVisibility(View.GONE);
                    findViewById(R.id.imageView6).setVisibility(View.GONE);
                    findViewById(R.id.imageView12).setVisibility(View.GONE);
                    break;
                case 3:
                    findViewById(R.id.imageView).setVisibility(View.GONE);
                    findViewById(R.id.imageView2).setVisibility(View.GONE);
                    findViewById(R.id.imageView3).setVisibility(View.GONE);
                    findViewById(R.id.imageView5).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView6).setVisibility(View.GONE);
                    findViewById(R.id.imageView12).setVisibility(View.GONE);
                    break;
                case 4:
                    findViewById(R.id.imageView).setVisibility(View.GONE);
                    findViewById(R.id.imageView2).setVisibility(View.GONE);
                    findViewById(R.id.imageView3).setVisibility(View.GONE);
                    findViewById(R.id.imageView5).setVisibility(View.GONE);
                    findViewById(R.id.imageView6).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView12).setVisibility(View.GONE);
                    break;
                case 5:
                    findViewById(R.id.imageView).setVisibility(View.GONE);
                    findViewById(R.id.imageView2).setVisibility(View.GONE);
                    findViewById(R.id.imageView3).setVisibility(View.GONE);
                    findViewById(R.id.imageView5).setVisibility(View.GONE);
                    findViewById(R.id.imageView6).setVisibility(View.GONE);
                    findViewById(R.id.imageView12).setVisibility(View.VISIBLE);
                    break;
            }
            switch (you) {
                case 0:
                    findViewById(R.id.imageView14).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView17).setVisibility(View.GONE);
                    findViewById(R.id.imageView18).setVisibility(View.GONE);
                    findViewById(R.id.imageView16).setVisibility(View.GONE);
                    findViewById(R.id.imageView15).setVisibility(View.GONE);
                    findViewById(R.id.imageView13).setVisibility(View.GONE);
                    break;
                case 1:
                    findViewById(R.id.imageView14).setVisibility(View.GONE);
                    findViewById(R.id.imageView17).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView18).setVisibility(View.GONE);
                    findViewById(R.id.imageView16).setVisibility(View.GONE);
                    findViewById(R.id.imageView15).setVisibility(View.GONE);
                    findViewById(R.id.imageView13).setVisibility(View.GONE);
                    break;
                case 2:
                    findViewById(R.id.imageView14).setVisibility(View.GONE);
                    findViewById(R.id.imageView17).setVisibility(View.GONE);
                    findViewById(R.id.imageView18).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView16).setVisibility(View.GONE);
                    findViewById(R.id.imageView15).setVisibility(View.GONE);
                    findViewById(R.id.imageView13).setVisibility(View.GONE);
                    break;
                case 3:
                    findViewById(R.id.imageView14).setVisibility(View.GONE);
                    findViewById(R.id.imageView17).setVisibility(View.GONE);
                    findViewById(R.id.imageView18).setVisibility(View.GONE);
                    findViewById(R.id.imageView16).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView15).setVisibility(View.GONE);
                    findViewById(R.id.imageView13).setVisibility(View.GONE);
                    break;
                case 4:
                    findViewById(R.id.imageView14).setVisibility(View.GONE);
                    findViewById(R.id.imageView17).setVisibility(View.GONE);
                    findViewById(R.id.imageView18).setVisibility(View.GONE);
                    findViewById(R.id.imageView16).setVisibility(View.GONE);
                    findViewById(R.id.imageView15).setVisibility(View.VISIBLE);
                    findViewById(R.id.imageView13).setVisibility(View.GONE);
                    break;
                case 5:
                    findViewById(R.id.imageView14).setVisibility(View.GONE);
                    findViewById(R.id.imageView17).setVisibility(View.GONE);
                    findViewById(R.id.imageView18).setVisibility(View.GONE);
                    findViewById(R.id.imageView16).setVisibility(View.GONE);
                    findViewById(R.id.imageView15).setVisibility(View.GONE);
                    findViewById(R.id.imageView13).setVisibility(View.VISIBLE);
                    break;
            }

            switch (pos){
                case 0:
                    if (me >= you) {
                        count = count+mon;
                    }
                    else {
                        count =count-mon;
                    }
                case 1:
                    if (me <= you) {
                        count = count+mon;
                    }
                    else {
                        count =count-mon;
                    }
            }

            money500.setText("目前金額:" + count+"元");
            if(count>=2000){
                winnig.setVisibility(View.VISIBLE);
                winnig.setText("您已過關!");
                winnig.setTextColor(Color.parseColor("#E91E63"));
                winnig.setBackgroundColor(Color.parseColor("#FAF493"));
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        i=bigor.getSelectedItemPosition();
        tos.setText("你選擇 "+place[i]);
        tos.show();
        if(i==0) {

        }
        else if(i==1){
            pos = 1;
        }
        onClick(view);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String str=edtmonyy.getText().toString();
        try{
            mon=Double.parseDouble(str);
        }catch (Exception e){
            mon=0;
        }

        Random x = new Random();
        int me = x.nextInt(6);
        Random z = new Random();
        int you = z.nextInt(6);
        switch (multt.getCheckedRadioButtonId()){
            case R.id.x3:
                mon*=3;
                break;
            case R.id.x5:
                mon*=5;
                break;
            case R.id.x10:
                mon*=10;
                break;
        }
    }
}
