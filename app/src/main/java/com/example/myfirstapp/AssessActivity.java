package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AssessActivity extends AppCompatActivity {
    public static String assess(double date){
        String string = "";
        if(date>=90){string="A";}
        else if (date>=86){string="A-";}
        else if (date>=83){string="B+";}
        else if (date>=80){string="B";}
        else if (date>=76){string="B-";}
        else if (date>=73){string="C+";}
        else if (date>=70){string="C";}
        else if (date>=66){string="C-";}
        else if (date>=63){string="D+";}
        else if (date>=60){string="D-";}
        else if (date >= 0){string="F";}
        return (string);
    }
    public static String stability(double date){
        String string="";
        if (date<=0.99){string="优秀";}
        else if (date<=3.99){string="良好";}
        else if (date<=9.99){string="较差";}
        else if (date>=10){string="差";}
        return (string);
    }
    public static String result1(String str,int score){
        String resultString="*您的"+str+"成绩";
        String assess;
        if (score>=90){assess="十分优秀，希望您可以继续保持该科成绩。";}
        else if (score>=85){assess="较为良好，您可以在努力一下，争取获得更好的成绩。";}
        else if (score>=75){assess="一般，建议多花一些时间用于该科的学习。";}
        else if (score>=60){assess="较差，强烈建议您注意基础知识的巩固，遇到相似学科时多加重视。";}
        else {assess="不合格，建议您认真听讲，做好规划，复习基础知识，多向其他同学请教。";}
        return (resultString+assess);
    }
    public static String result2(String str,int score){
        String resultString="*您的"+str+"成绩";
        String assess;
        if (score>=90){assess="十分优秀，你可以在学好其他学科的基础上拓展学习领域。";}
        else if (score>=85){assess="较为良好，建议您充分利用资源，让自己更上一层楼。";}
        else if (score>=75){assess="一般，建议您梳理好知识框架，抓住重点，注重练习。";}
        else if (score>=60){assess="较差，希望您放平心态，找准原因，查漏补缺，。";}
        else {assess="不合格,强烈建议您端正态度，认真听讲，做好笔记，合理安排时间。";}
        return (resultString+assess);
    }
    public static String result0(double averagesco,double variance){
        String assess1="*您的总体成绩";
        String assess2;
        String assess3;
        if (averagesco>=90){assess2="十分优秀，";}
        else if (averagesco>=85){assess2="较为良好，";}
        else if (averagesco>=75){assess2="一般，建议您找准原因，多加努力，";}
        else if (averagesco>=60){assess2="较差，需要加强学习，";}
        else {assess2="不合格，强烈建议您认真考虑一下原因，";}
        if (variance<1){assess3="各科成绩平均。";}
        else if (variance<4){assess3="各科成绩较为平均。";}
        else if (variance<10){assess3="存在偏科趋势，要重视起来了。";}
        else {assess3="各科存在严重偏科。";}
        return (assess1+assess2+assess3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_assess);
        Button buttonNext=findViewById(R.id.assess_buttonNext);
        Button button_back=findViewById(R.id.assess_buttonBack);
        Button button_explain=findViewById(R.id.assess_buttonExplain);
        TextView textView_allScore=findViewById(R.id.assess_textAllScore);
        TextView textView_subject1=findViewById(R.id.assess_TextSubject1);
        TextView textView_subject2=findViewById(R.id.assess_TextSubject2);
        TextView textView_subject3=findViewById(R.id.assess_TextSubject3);
        TextView textView_subject4=findViewById(R.id.assess_TextSubject4);
        TextView textView_score1=findViewById(R.id.assess_textScore1);
        TextView textView_score2=findViewById(R.id.assess_textScore2);
        TextView textView_score3=findViewById(R.id.assess_textScore3);
        TextView textView_score4=findViewById(R.id.assess_textScore4);
        TextView textView_level1=findViewById(R.id.assess_level1);
        TextView textView_level2=findViewById(R.id.assess_level2);
        TextView textView_level3=findViewById(R.id.assess_level3);
        TextView textView_level4=findViewById(R.id.assess_level4);
        TextView textView_grade0=findViewById(R.id.assess_textFraction0);
        TextView textView_grade1=findViewById(R.id.assess_textFraction1);
        TextView textView_grade2=findViewById(R.id.assess_textFraction2);
        TextView textView_grade3=findViewById(R.id.assess_textFraction3);
        TextView textView_grade4=findViewById(R.id.assess_textFraction4);
        TextView textView_Score=findViewById(R.id.assess_Score);
        TextView textView_ltvel0=findViewById(R.id.assess_level0);
        TextView textView_stability=findViewById(R.id.assess_stability);

        final Intent intent_get = getIntent();
        String subject1=intent_get.getStringExtra("subject1");
        String subject2=intent_get.getStringExtra("subject2");
        String subject3=intent_get.getStringExtra("subject3");
        String subject4=intent_get.getStringExtra("subject4");
        textView_subject1.setText(subject1);
        textView_subject2.setText(subject2);
        textView_subject3.setText(subject3);
        textView_subject4.setText(subject4);
        double score0=intent_get.getDoubleExtra("allscore",0);
        int score1 = intent_get.getIntExtra("score1",0);
        int score2=intent_get.getIntExtra("score2",0);
        int score3=intent_get.getIntExtra("score3",0);
        int score4=intent_get.getIntExtra("score4",0);
        double gradePoint1=intent_get.getDoubleExtra("gradePoint1",0);
        double gradePoint2=intent_get.getDoubleExtra("gradePoint2",0);
        double gradePoint3=intent_get.getDoubleExtra("gradePoint3",0);
        double gradePoint4=intent_get.getDoubleExtra("gradePoint4",0);
        double gradePoint0=intent_get.getDoubleExtra("gradePoint0",0);
        double averagescore=intent_get.getDoubleExtra("averagescore",0);
        String level0=assess(averagescore);
        String level1=assess(score1);
        String level2=assess(score2);
        String level3=assess(score3);
        String level4=assess(score4);

        double variance=(((averagescore-score1)*(averagescore-score1))+
                ((averagescore-score1)*(averagescore-score1))+((averagescore-score1)*(averagescore-score1))
                +((averagescore-score1)*(averagescore-score1)))/4;
        String stability= stability(variance);
        textView_stability.setText(stability);

        java.text.DecimalFormat df=new java.text.DecimalFormat("##.##");
        textView_score1.setText(String.valueOf(score1));
        textView_score2.setText(String.valueOf(score2));
        textView_score3.setText(String.valueOf(score3));
        textView_score4.setText(String.valueOf(score4));
        textView_Score.setText(df.format(averagescore));
        textView_grade0.setText(df.format(gradePoint0));
        textView_allScore.setText(df.format(score0));
        textView_ltvel0.setText(level0);
        textView_level1.setText(level1);
        textView_level2.setText(level2);
        textView_level3.setText(level3);
        textView_level4.setText(level4);
        textView_grade1.setText(String.valueOf(gradePoint1));
        textView_grade2.setText(String.valueOf(gradePoint2));
        textView_grade3.setText(String.valueOf(gradePoint3));
        textView_grade4.setText(String.valueOf(gradePoint4));


        final String assess0=result0(averagescore, variance);
        final String assess1=result1(subject1,score1);
        final String assess2=result2(subject2,score2);
        final String assess3=result1(subject3,score3);
        final String assess4=result2(subject4,score4);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent_next=new Intent(AssessActivity.this,ResultActivity.class);

                intent_next.putExtra("assess0",assess0);
                intent_next.putExtra("assess1",assess1);
                intent_next.putExtra("assess2",assess2);
                intent_next.putExtra("assess3",assess3);
                intent_next.putExtra("assess4",assess4);
                startActivity(intent_next);

            }
        });
button_back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
button_explain.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog textTips = new AlertDialog.Builder(AssessActivity.this)
                .setTitle("Tips:")
                .setMessage("1.顶部圆框内数据为您的加权平均分。\n" +
                        "2.综合评级由您的加权平均分转换获得。\n" +
                        "3.以上数据均由您输入的数据计算转化获得，如有疑问请联系开发人员。\n")
                .create();
        textTips.show();

    }
});
    }
}
