package com.example.i.quizapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Main3Activity extends AppCompatActivity {

    TextView questionLabel, questionCountLabel, scoreLabel;
    EditText answerEdt;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<QuestionModel> questionModelArraylist;



    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent= getIntent();

        questionCountLabel = findViewById(R.id.noQuestion);
        questionLabel = findViewById(R.id.question);
        scoreLabel = findViewById(R.id.score);

        answerEdt = findViewById(R.id.answer);
        submitButton = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progress);



        questionModelArraylist = new ArrayList<>();


        setUpQuestion();

        setData();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer();
            }
        });

        answerEdt.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                Log.e("event.getAction()",event.getAction()+"");
                Log.e("event.keyCode()",keyCode+"");
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    checkAnswer();
                    return true;
                }
                return false;
            }
        });

    }
    public void checkAnswer(){
        String answerString  = answerEdt.getText().toString().trim();




        if(answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswer())){
            numberOfCorrectAnswer ++;



            new SweetAlertDialog(Main3Activity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("Right Asswer")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            currentPosition ++;

                            setData();
                            answerEdt.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();


        }else {

            new SweetAlertDialog(Main3Activity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Wrong Answer")
                    .setContentText("The right answer is : "+questionModelArraylist.get(currentPosition).getAnswer())
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismiss();

                            currentPosition ++;

                            setData();
                            answerEdt.setText("");
                        }
                    })
                    .show();
        }





        int x = ((currentPosition+1) * 100) / questionModelArraylist.size();

        progressBar.setProgress(x);



    }




    public void setUpQuestion(){


        questionModelArraylist.add(new QuestionModel("1. IC chips used in computers are usually made of: \n" +
                "\n a. Lead \n b. Silicon \n c. Chromium \n d. Gold","a"));
        questionModelArraylist.add(new QuestionModel("2. One kilobyte is equal to: \n" +
                "\n a. 1000 bytes \n b. 100 bytes \n c. 1024 bytes \n d. 1023 bytes","c"));
        questionModelArraylist.add(new QuestionModel("3. Which of the following is not an example of Operating System? \n" +
                "\n a. Windows 10 \n b. Microsoft Office  \n c. BSD Unix \n d. Red Hat Linux","b"));
        questionModelArraylist.add(new QuestionModel("4. Linus Torvalds develop which operating system? \n" +
                "\n a. Windows \n b. Mac OS \n c. UNIX \n d. Linux","d"));
        questionModelArraylist.add(new QuestionModel("5. Who created the C programming Language? \n" +
                "\n a. Ken Thompson \n b. Dennis Ritchie \n c. Robin Milner \n d. Frieder Nake","b"));
        questionModelArraylist.add(new QuestionModel("6. Which one is the first high level programming language? \n" +
                "\n a. C \n b. C++ \n c. COBOL \n d. FORTRAN","d"));
        questionModelArraylist.add(new QuestionModel("7. What kind of errors can be pointed out by the compiler? \n" +
                "\n a. Syntax error \n b. Symantic error \n c. Logical error \n d. Internal error","a"));
        questionModelArraylist.add(new QuestionModel("8. Which one is volatile memory in a computer system? \n" +
                "\n a. HardDisk \n b. RAM \n c. ROM \n d. Optical Drive","b"));
        questionModelArraylist.add(new QuestionModel("9. What do you use to create a chart? \n" +
                "\n a. Pie Wizard \n b. Excel Wizard \n c. Data Wizard \n d. Chart Wizard","d"));
        questionModelArraylist.add(new QuestionModel("10. Who is the father of computer? \n" +
                "\n a. James Gosling \n b. Charles Babbage \n c. Douglas Engelbart \n d. James D. Foley","b"));


    }

    public void setData(){


        if(questionModelArraylist.size()>currentPosition) {

            questionLabel.setText( questionModelArraylist.get(currentPosition).getQuestionString());

            scoreLabel.setText("Score :" + numberOfCorrectAnswer + "/" + questionModelArraylist.size());
            questionCountLabel.setText("Question No : " + (currentPosition + 1));


        }else{


            new SweetAlertDialog(Main3Activity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("You have successfully completed the quiz")
                    .setContentText("Your score is : "+ numberOfCorrectAnswer + "/" + questionModelArraylist.size())
                    .setConfirmText("Restart")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                            currentPosition = 0;
                            numberOfCorrectAnswer = 0;
                            progressBar.setProgress(0);
                            setData();
                        }
                    })
                    .setCancelText("Close")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                            finish();
                        }
                    })
                    .show();

        }

    }



}