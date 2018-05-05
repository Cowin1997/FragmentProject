package com.example.admin.fragmentproject;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    inButton inButton=new inButton(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twopane);
        textView=(TextView)findViewById(R.id.textview);
        //内部类监听
        Button button1=(Button)findViewById(R.id.bt1);
        button1.setOnClickListener(inButton);
        //外部类监听
        Button button2=(Button)findViewById(R.id.bt2);
        button2.setOnClickListener(new Button2(MainActivity.this,textView));
        //  匿名内部类监听
        Button button3=(Button) findViewById(R.id.bt3);
        button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView.setText("匿名内部类");
            Toast.makeText(MainActivity.this,"匿名内部类监听",Toast.LENGTH_LONG).show();
        }
    });
        //通过Activity监听
        Button button4=(Button)findViewById(R.id.bt4);
        button4.setOnClickListener(this);

}
    @Override
    public void onClick(View v) {
         textView.setText("通过Activity监听");
         Toast.makeText(this,"通过Activity监听",Toast.LENGTH_LONG).show();
    }
    //通过标签
    public void bt5(View source){
        textView.setText("通过标签监听");
        Toast.makeText(this,"通过标签监听",Toast.LENGTH_LONG).show();
    }



  //内部类

    class  inButton implements View.OnClickListener{
        Context context;
        public inButton(Context context){
            this.context=context;
        }

        @Override
        public void onClick(View v) {
            textView.setText("通过内部类监听");
            Toast.makeText(context,"通过内部类监听",Toast.LENGTH_LONG).show();
        }
    }
}
