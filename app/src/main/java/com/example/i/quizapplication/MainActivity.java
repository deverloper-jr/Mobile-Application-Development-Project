package com.example.i.quizapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    Button simpleQuiz,quizGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        simpleQuiz = findViewById(R.id.simplequiz);
        quizGame = findViewById(R.id.quizgame);
        textView1 = findViewById(R.id.textView1);



        quizGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(first);
            }
        });

        simpleQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(second);
            }
        });

    }
}
