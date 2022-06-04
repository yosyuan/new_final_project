package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class bet4 extends AppCompatActivity implements TextWatcher, RadioGroup.OnCheckedChangeListener,
View.OnClickListener, AdapterView.OnItemSelectedListener {

    RadioGroup mul;
    Spinner bigor;
    String[] place={"比大","比小"};
    TextView money;
    ImageView btnn;
    EditText edtmoney;
    double mon;
    double count3=500;
    int pos=0;
    TextView win;
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

        money = findViewById(R.id.textView);
        bigor=findViewById(R.id.spinner2);
        bigor.setOnItemSelectedListener(this);
        btnn=findViewById(R.id.imageView19);
        btnn.setOnClickListener(this);
        edtmoney= findViewById(R.id.edtmoney);
        edtmoney.addTextChangedListener(this);
        mul=findViewById(R.id.mil);
        mul.setOnCheckedChangeListener(this);

        win=findViewById(R.id.textView13);
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
        if (edtmoney.length() == 0) {
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
                        count3 = count3+mon;
                    }
                    else {
                        count3 =count3-mon;
                    }
                case 1:
                    if (me <= you) {
                        count3 = count3+mon;
                    }
                    else {
                        count3 =count3-mon;
                    }
            }

            money.setText("目前金額:" + count3+"元");
            if(count3>=2000){
                win.setVisibility(View.VISIBLE);
                win.setText("您已過關!");
                win.setTextColor(Color.parseColor("#E91E63"));
                win.setBackgroundColor(Color.parseColor("#FAF493"));
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        i=bigor.getSelectedItemPosition();
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
        String str=edtmoney.getText().toString();
        try{
            mon=Double.parseDouble(str);
        }catch (Exception e){
            mon=0;
        }

        Random x = new Random();
        int me = x.nextInt(6);
        Random z = new Random();
        int you = z.nextInt(6);
        switch (mul.getCheckedRadioButtonId()){
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
