package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {
    EditText firstnum,secondnum;
    TextView tv;
    Button btn;
    int fn,sn,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
       firstnum=findViewById(R.id.sub_et1);
       secondnum=findViewById(R.id.sub_et2);
       tv=findViewById(R.id.sub_tv1);
       btn=findViewById(R.id.sub_btn1);

       Intent intent=getIntent();

       final String s=intent.getStringExtra("what");

       tv.setText(s);


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               fn=Integer.parseInt(firstnum.getText().toString());
               sn=Integer.parseInt(secondnum.getText().toString());
               switch(s){
                   case "+":
                       result=fn+sn;
                       break;
                   case "-":
                       result=fn-sn;
                       break;
               }
               Intent resultintent=new Intent();
               resultintent.putExtra("result", "연산결과"+result+"입니다.");
               setResult(RESULT_OK,resultintent);
               finish();
           }
       });
    }
}
