package id.co.rezkiananda.learn.programminglanguage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizQuestionActivity extends AppCompatActivity {
    //Question1
    RadioButton question1_choice1, question1_choice2;
    //Question2
    EditText question2_answer;
    //Question3
    CheckBox question3_choice1, question3_choice2, question3_choice3, question3_choice4;
    //Question4
    EditText question4_answer;
    //Question5
    RadioButton question5_choice1, question5_choice2, question5_choice3, question5_choice4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_quiz_question);

        Button submit = findViewById(R.id.submit_answers);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAnswer();
            }
        });
    }

    private void goAnswer() {
        CharSequence resultDisplay;
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int finalScore;

        //Question 1 - Correct Answer is #TIDAK

        boolean answer1;
        question1_choice2 = this.findViewById(R.id.question1_choice2);
        answer1 = question1_choice2.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }

        //Question 2 - Correct Answer is #RUBY

        String answer2;
        question2_answer = this.findViewById(R.id.question2_answer);
        answer2 = question2_answer.getText().toString().toUpperCase();
        if (answer2.equals("RUBY")) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }

        //Question 3 - Correct Answer is #C-JAVA-SQL

        boolean answer3_choice1, answer3_choice2, answer3_choice3, answer3_choice4;
        question3_choice1 = this.findViewById(R.id.question3_choice1);
        question3_choice2 = this.findViewById(R.id.question3_choice2);
        question3_choice3 = this.findViewById(R.id.question3_choice3);
        question3_choice4 = this.findViewById(R.id.question3_choice4);
        answer3_choice1 = question3_choice1.isChecked();
        answer3_choice2 = question3_choice2.isChecked();
        answer3_choice3 = question3_choice3.isChecked();
        answer3_choice4 = question3_choice4.isChecked();
        if (answer3_choice1 && answer3_choice2 && !answer3_choice3 && answer3_choice4) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }

        //Question 4 - Correct Answer is #JAVASCRIPT

        String answer4;
        question4_answer = this.findViewById(R.id.question4_answer);
        answer4 = question4_answer.getText().toString().toUpperCase();
        if (answer4.equals("JAVASCRIPT")) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        //Question 5 - Correct Answer is #C
        boolean answer5;
        question5_choice4 = this.findViewById(R.id.question5_choice4);
        answer5 = question5_choice4.isChecked();
        if (answer5) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }

        //FINAL SCORE
        finalScore = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;

        if (finalScore == 5) {
            resultDisplay = "Perfect!";
            Intent intent = new Intent(this, CongratulationActivity.class);
            startActivity(intent);
        } else {
            resultDisplay = "Try again. You scored " + finalScore + " out of 5";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
