package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class InputActivity extends AppCompatActivity {

    public static double scorelevel(int date){
        double score =0;
        if(date>=90){score=4.0;}
        else if (date>=86){score=3.7;}
        else if (date>=83){score=3.3;}
        else if (date>=80){score=3.0;}
        else if (date>=76){score=2.7;}
        else if (date>=73){score=2.3;}
        else if (date>=70){score=2.0;}
        else if (date>=66){score=1.7;}
        else if (date>=63){score=1.3;}
        else if (date>=60){score=1.0;}
        else if (date >= 0){score=0;}
        return (score);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_input);

         final EditText et_subject1 = findViewById(R.id.input_subject_one);
         final EditText et_subject2 = findViewById(R.id.input_subject_two);
         final EditText et_subject3 = findViewById(R.id.input_subject_three);
         final EditText et_subject4 = findViewById(R.id.input_subject_four);
         final EditText et_myScore1=findViewById(R.id.input_sco_one);
         final EditText et_myScore2=findViewById(R.id.input_sco_two);
         final EditText et_myScore3=findViewById(R.id.input_sco_three);
         final EditText et_myScore4=findViewById(R.id.input_sco_four);
         final EditText et_Score1=findViewById(R.id.input_score_one);
         final EditText et_Score2=findViewById(R.id.input_score_two);
         final EditText et_Score3=findViewById(R.id.input_score_three);
         final EditText et_Score4=findViewById(R.id.input_score_four);
         Button button_back=findViewById(R.id.input_buttonBack);
         Button button_next=findViewById(R.id.input_buttonExplain);
        Button button = findViewById(R.id.input_buttonEnter);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog textTips = new AlertDialog.Builder(InputActivity.this)
                        .setTitle("Tips:")
                        .setMessage("1.学科限定输入格式为2—9个汉字+0或1个数字1-4，请用户自觉输入。\n" +
                                "2.学分输入限定为小于等于10，允许输入两位小数。\n" +
                                "3.成绩限定输入100及以内非负整数。")
                        .create();
                textTips.show();
            }
        });

        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (et_subject1.getText().toString().equals("") || et_subject2.getText().toString().equals("")
                        || et_subject3.getText().toString().equals("") || et_subject4.getText().toString().equals("")
                        || et_myScore1.getText().toString().equals("") || et_myScore2.getText().toString().equals("")
                        || et_myScore3.getText().toString().equals("") || et_myScore4.getText().toString().equals("")
                        || et_Score1.getText().toString().equals("") || et_Score2.getText().toString().equals("")
                        || et_myScore3.getText().toString().equals("") || et_Score4.getText().toString().equals("")) {
                    Toast.makeText(InputActivity.this, "有空输入！\n 请重新输入！", Toast.LENGTH_LONG).show(); }
                else {
                    double sco1 = Double.parseDouble(et_Score1.getText().toString());
                    double sco2 = Double.parseDouble(et_Score2.getText().toString());
                    double sco3 = Double.parseDouble(et_Score3.getText().toString());
                    double sco4 = Double.parseDouble(et_Score4.getText().toString());
                    int score1 = Integer.parseInt(et_myScore1.getText().toString());
                    int score2 = Integer.parseInt(et_myScore2.getText().toString());
                    int score3 = Integer.parseInt(et_myScore3.getText().toString());
                    int score4 = Integer.parseInt(et_myScore4.getText().toString());

                    if( sco1>10||sco2>10||sco3>10||sco4>10) {
                          Toast.makeText(InputActivity.this, "学分输入有误！\n请重新输入！", Toast.LENGTH_LONG).show();}
                    else {
                            double allscore = sco1 + sco2 + sco3 + sco4;
                        if (score1 > 100 || score2 > 100 || score3 > 100 || score4 > 100) {
                            Toast.makeText(InputActivity.this, "成绩输入有误！\n请重新输入！", Toast.LENGTH_LONG).show(); }
                        else {
                            String subject1 = et_subject1.getText().toString();
                            String subject2 = et_subject2.getText().toString();
                            String subject3 = et_subject3.getText().toString();
                            String subject4 = et_subject4.getText().toString();

                            String regex_subject = "[\\u4e00-\\u9fa5]{2,9}[1234]?";
                            boolean isMached1 = Pattern.matches(regex_subject, subject1);
                            boolean isMached2 = Pattern.matches(regex_subject, subject2);
                            boolean isMached3 = Pattern.matches(regex_subject, subject3);
                            boolean isMached4 = Pattern.matches(regex_subject, subject4);
                            if ((isMached1) && (isMached2) && (isMached3) && (isMached4)) {
                                double gradePoint1 = scorelevel(score1);
                                double gradePoint2 = scorelevel(score2);
                                double gradePoint3 = scorelevel(score3);
                                double gradePoint4 = scorelevel(score4);
                                double gradePoint0 = ((gradePoint1 * sco1) + (gradePoint2 * sco2) + (gradePoint3 * sco3) + (gradePoint4 * sco4)) / allscore;
                                double averagescore = ((score1 * sco1) + (score2 * sco2) + (score3 * sco3) + (score4 * sco4)) / allscore;

                                Intent intent = new Intent(InputActivity.this, AssessActivity.class);

                                intent.putExtra("allscore", allscore);
                                intent.putExtra("subject1", subject1);
                                intent.putExtra("subject2", subject2);
                                intent.putExtra("subject3", subject3);
                                intent.putExtra("subject4", subject4);
                                intent.putExtra("score1", score1);
                                intent.putExtra("score2", score2);
                                intent.putExtra("score3", score3);
                                intent.putExtra("score4", score4);
                                intent.putExtra("gradePoint0", gradePoint0);
                                intent.putExtra("averagescore", averagescore);
                                intent.putExtra("gradePoint1", gradePoint1);
                                intent.putExtra("gradePoint2", gradePoint2);
                                intent.putExtra("gradePoint3", gradePoint3);
                                intent.putExtra("gradePoint4", gradePoint4);


                                startActivity(intent); }
                            else {
                                Toast.makeText(InputActivity.this, "学科输入有误！\n请重新输入！", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
                }
        });
    }
}