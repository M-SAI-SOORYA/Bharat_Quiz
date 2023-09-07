package com.example.bharat_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView5;
    TextView textView6;
    TextView textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView5=findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        textView7=findViewById(R.id.textView7);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String score = bundle.getString("score");
            String status = bundle.getString("status");
            String numofQuestions = bundle.getString("numofQuestions");
            textView5.setText(score);
            textView6.setText(status);
            textView7.setText(numofQuestions);

        }

    }
}
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        textview=findViewById(R.id.textView);
//        Intent intent=getIntent();
//        String s=intent.getStringExtra(MainActivity.Extra_name);
//        textview.setText("The Name is :"+s+"!");
//    }