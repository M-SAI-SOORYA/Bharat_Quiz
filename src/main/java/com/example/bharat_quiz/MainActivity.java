package com.example.bharat_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private TextView textView2;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button prev;

    public static final String scorer="com.example.bharat_quiz.Name";
    public static final String status="com.example.bharat_quiz.Name";
    public static final String numofQuestions="com.example.bharat_quiz.Name";


    private Button submit;
    int score=0;
    int QuestionLength=QuestionandAnswer.questions.length;
    int i=0;
    String selected_answer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView=findViewById(R.id.textView);

//        Toast.makeText(this, "Opening Second Activity", Toast.LENGTH_SHORT).show();
//
//        String x=String.valueOf(score);
//        Intent inten=new Intent(this,MainActivity2.class);
//        inten.putExtra(Extra_name,x);
//        startActivity(inten);

        //textView2=findViewById(R.id.textVieww);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        prev=findViewById(R.id.button6);
        submit=findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        submit.setOnClickListener(this);
        prev.setOnClickListener(this);

        loadQue();

//        prev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                --i;
//                loadQue();
//            }
//        });


    }
    @Override
    public void onClick(View view){
        button1.setBackgroundColor(Color.WHITE);
        button2.setBackgroundColor(Color.WHITE);
        button3.setBackgroundColor(Color.WHITE);
        button4.setBackgroundColor(Color.WHITE);

        Button clicked=(Button) view;
        if(clicked.getId()== R.id.button5){
            if(selected_answer.equals(QuestionandAnswer.Answers[i])){
                score++;
            }

            i++;
            loadQue();




        }
        else if(clicked.getId()==R.id.button6){
                    --i;
                    loadQue();

        }
        else{
            selected_answer=clicked.getText().toString();
            clicked.setBackgroundColor(Color.MAGENTA);

        }
    }
    void scorecard(){
        Toast.makeText(this, "Opening Score-Card", Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        String x=String.valueOf(score);
        String y="";
        if(score>2){
             y= "Passed";
        }
        else{
             y="Failed";
        }

        String z=String.valueOf(QuestionLength-1) ;
        bundle.putString("score",x);
        bundle.putString("status",y);
        bundle.putString("numofQuestions",z);
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }
//    void finishQuiz(){
//        String passStatus="";
//        if(score>Question*0.60){
//            passStatus="Passed";
//        }else{
//            passStatus="Failed";
//        }
//        new AlertDialog.Builder(this)
//                .setTitle(passStatus);
//
//    }
    void loadQue(){
        if(i==QuestionLength-1){
            scorecard();
            return;
        }
        textView.setText(QuestionandAnswer.questions[i]);
        button1.setText(QuestionandAnswer.choices[i][0]);
        button2.setText(QuestionandAnswer.choices[i][1]);
        button3.setText(QuestionandAnswer.choices[i][2]);
        button4.setText(QuestionandAnswer.choices[i][3]);
    }
}