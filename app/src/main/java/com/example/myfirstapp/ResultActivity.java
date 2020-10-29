package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_result);
        Button button_back=findViewById(R.id.result_buttonBack);
        Button button_explain=findViewById(R.id.result_buttonExplain);
        TextView textView_assess0=findViewById(R.id.result_textTips0);
        TextView textView_assess1=findViewById(R.id.result_textTips1);
        TextView textView_assess2=findViewById(R.id.result_textTips2);
        TextView textView_assess3=findViewById(R.id.result_textTips3);
        TextView textView_assess4=findViewById(R.id.result_textTips4);
        Intent intent_get=getIntent();
        String assess0=intent_get.getStringExtra("assess0");
        textView_assess0.setText(assess0);
        String assess1=intent_get.getStringExtra("assess1");
        textView_assess1.setText(assess1);
        String assess2=intent_get.getStringExtra("assess2");
        textView_assess2.setText(assess2);
        String assess3=intent_get.getStringExtra("assess3");
        textView_assess3.setText(assess3);
        String assess4=intent_get.getStringExtra("assess4");
        textView_assess4.setText(assess4);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog textTips = new AlertDialog.Builder(ResultActivity.this)
                        .setTitle("Thanks:")
                        .setMessage("感谢您使用此应用！\n")
                        .create();
                textTips.show();
            }
        });
    }
}