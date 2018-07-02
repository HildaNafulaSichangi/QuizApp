package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int studentScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SubmitOrder(View view) {
        EditText editText = (EditText) findViewById(R.id.name_of_student);
        String textToInput = editText.getText().toString();

        int checkBoxes = calculateScore(displayCheckBoxDetails(),displayCheckBoxDetails2(),displayCheckBoxDetails3());

        int radioGroupOne = radioGroupOne(displayRadioButton1(),displayRadioButton2());

        int radioGroupTwo = radioGroupTwo(displayRadioButton3(),displayRadioButton4());

        int radioGroupThree = radioGroupThree(displayRadioButton5(),displayRadioButton6());

        int totalScore = checkBoxes + radioGroupOne + radioGroupTwo + radioGroupThree;

        String studentScore = textToInput + " Your score is: "+totalScore+"/5";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Results for "+ textToInput);
        intent.putExtra(Intent.EXTRA_TEXT, studentScore);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        displayMessage(studentScore);
        }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculateScore(boolean checkBoxOne1, boolean checkBoxTwo2,boolean checkBoxThree3){
        int theScore = 0;
        if(checkBoxOne1){
            theScore = 1;
        }
        if(checkBoxTwo2){
            theScore = 1;
        }
        if(checkBoxThree3){
            theScore=0;
        }
        if(checkBoxOne1 && checkBoxTwo2){
            theScore = 2;
        }
        if(checkBoxOne1 && checkBoxThree3){
            theScore=1;
        }
        if(checkBoxTwo2 && checkBoxThree3){
            theScore=1;
        }
        if(checkBoxOne1 && checkBoxTwo2 &&checkBoxThree3){
            theScore = 2;

        }
        return theScore;
    }
    private int radioGroupOne(boolean radioButtonOne1,boolean radioButtonTwo2){
        int theScore = 0;
        if(radioButtonOne1){
            theScore=1;
        }
        if(radioButtonTwo2){
            theScore=0;
        }
        return theScore;
    }
    private int radioGroupTwo(boolean radioButtonThree3,boolean radioButtonfour4){
        int theScore = 0;
        if(radioButtonThree3){
            theScore=0;
        }
        if(radioButtonfour4){
            theScore=1;
        }
        return theScore;
    }
    private int radioGroupThree(boolean radioButtonFive5,boolean radioButtonSix6){
        int theScore = 0;
        if(radioButtonFive5){
            theScore=1;
        }
        if(radioButtonSix6){
            theScore=0;
        }
        return theScore;
    }
    private boolean displayCheckBoxDetails(){
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_one);
        boolean checkBoxIs = checkBox.isChecked();
        return checkBoxIs;
    }

    private boolean displayCheckBoxDetails2(){
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_two);
        boolean checkBoxIs2 = checkBox.isChecked();
        return checkBoxIs2;
    }

    private boolean displayCheckBoxDetails3(){
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_three);
        boolean checkBoxIs3 = checkBox.isChecked();
        return checkBoxIs3;
    }

    private boolean displayRadioButton1(){
        RadioButton radioButton=(RadioButton) findViewById(R.id.radio_button_one);
        boolean radioButton1 = radioButton.isChecked();
        return radioButton1;
    }
    private boolean displayRadioButton2(){
        RadioButton radioButton=(RadioButton) findViewById(R.id.radio_button_two);
        boolean radioButton2 = radioButton.isChecked();
        return radioButton2;
    }
    private boolean displayRadioButton3(){
        RadioButton radioButton=(RadioButton) findViewById(R.id.radio_button_three);
        boolean radioButton3 = radioButton.isChecked();
        return radioButton3;
    }
    private boolean displayRadioButton4(){
        RadioButton radioButton=(RadioButton) findViewById(R.id.radio_button_four);
        boolean radioButton4 = radioButton.isChecked();
        return radioButton4;
    }
    private boolean displayRadioButton5(){
        RadioButton radioButton=(RadioButton) findViewById(R.id.radio_button_five);
        boolean radioButton5 = radioButton.isChecked();
        return radioButton5;
    }
    private boolean displayRadioButton6(){
        RadioButton radioButton=(RadioButton) findViewById(R.id.radio_button_six);
        boolean radioButton6 = radioButton.isChecked();
        return radioButton6;
    }



    /**
     *
     * reset score back to zero
     * */

    public void resetScoreToZero(View view){
        studentScore = 0;
        displayResetStudentResults(studentScore);
    }
    public void displayResetStudentResults(int score){
        TextView scoreView = (TextView) findViewById(R.id.order_summary_text_view);
        scoreView.setText(String.valueOf(score));
    }

}
