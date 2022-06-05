package tw.cgu.b0921246.app_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity implements TextWatcher {

    TextView total,speak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        total=findViewById(R.id.point7);
        speak=findViewById(R.id.textView10);

        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        total.setText("總分："+data);
        String[] point={"0","20","40","60","80","100"};
        //int point;
        //point= Integer.parseInt(data);


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        Intent it=getIntent();
        String data=it.getStringExtra("分數");
        total.setText("總分："+data);
        String[] point={"0","20","40","60","80","100"};
        if (point[0]==data||point[1]==data){
            speak.setText("菜色很爛");
        }
    }
}
