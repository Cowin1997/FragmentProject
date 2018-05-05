package com.example.admin.fragmentproject;


import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Button2  implements View.OnClickListener {
    TextView textView;
    Context context;
    public Button2(Context context,TextView textView) {
        this.context=context;
        this.textView=textView;

    }
    @Override
    public void onClick(View v) {
        textView.setText("通过外部类监听");
        Toast.makeText(context,"通过外部类监听",Toast.LENGTH_LONG).show();
    }
}
