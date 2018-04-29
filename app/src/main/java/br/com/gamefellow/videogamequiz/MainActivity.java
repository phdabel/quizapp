package br.com.gamefellow.videogamequiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // maximum score of the quiz
    private final double TOTAL_SCORE = 6.0;

    /**
     *  variable used for validation
     *  checkboxes are always true because they can stay empty
     */
    private boolean questionValidation[] = {false, true, true, false, false, true};

    /**
     *  template of the checkbox questions
     */
    private final boolean ANSWER2[] = {false, true, true, true};
    private final boolean ANSWER3[] = {false, true, false, false};
    private final boolean ANSWER6[] = {true, false, true, true};

    /**
     * variables used to store the answers provided by the users
     */
    double question1 = 0.0;
    boolean question2[] = new boolean[4];
    boolean question3[] = new boolean[4];
    double question4 = 0.0;
    double question5 = 0.0;
    boolean question6[] = new boolean[4];

    /**
     *  text and image views for final messages
     */
    @BindView(R.id.scoreTextView) TextView scoreTextView;
    @BindView(R.id.seeCorrectAnswers) TextView seeCorrectAnswers;
    @BindView(R.id.giantbomblogo) ImageView gbLogo;

    @OnClick(R.id.giantbomblogo)
    void setOnClickListener(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.giantbomb.com/"));
        startActivity(intent);
    };

    /**
     * Binds the text views for the feedbacks of the questions.
     */
    @BindViews({R.id.q1_answer, R.id.q2_answer, R.id.q3_answer, R.id.q4_answer, R.id.q5_answer, R.id.q6_answer}) TextView[] answers;

    /**
     *  Binds every radioButton of the form
     */
    @BindViews({R.id.q1_alt_a, R.id.q1_alt_b, R.id.q1_alt_c, R.id.q1_alt_d}) RadioButton[] radioButtons1;
    @BindViews({R.id.q4_alt_a, R.id.q4_alt_b, R.id.q4_alt_c, R.id.q4_alt_d}) RadioButton[] radioButtons4;
    @BindViews({R.id.q5_alt_a, R.id.q5_alt_b, R.id.q5_alt_c, R.id.q5_alt_d}) RadioButton[] radioButtons5;

    /**
     * Binds the optional question 7 and the submit button
     */
    @BindView(R.id.q7_answer) EditText q7;
    @BindView(R.id.submitButton) Button submit;

    /**
     * Check answer for question 1
     * @param radioButton
     */
    @OnCheckedChanged({R.id.q1_alt_a, R.id.q1_alt_b, R.id.q1_alt_c, R.id.q1_alt_d})
    void onQuestion1(CompoundButton radioButton, boolean checked){
        if(checked){
            questionValidation[0] = true;
            if(radioButton.getId() == R.id.q1_alt_b){
                question1 = 1.0;
            }else{
                question1 = 0.0;
            }
        }
    }

    /**
     * Binding question 2 checkboxes
     */
    @BindViews({R.id.q2_alt_a,R.id.q2_alt_b,R.id.q2_alt_c,R.id.q2_alt_d}) CheckBox[] checkBoxes2;
    void question2Listener(){
        for(CheckBox checkBox : checkBoxes2){
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton aCheckBox, boolean checked) {
                    switch(aCheckBox.getId()){
                        case R.id.q2_alt_a:
                            if(aCheckBox.isChecked()) question2[0] = true; else question2[0] = false;
                            break;
                        case R.id.q2_alt_b:
                            if(aCheckBox.isChecked()) question2[1] = true; else question2[1] = false;
                            break;
                        case R.id.q2_alt_c:
                            if(aCheckBox.isChecked()) question2[2] = true; else question2[2] = false;
                            break;
                        case R.id.q2_alt_d:
                            if(aCheckBox.isChecked()) question2[3] = true; else question2[3] = false;
                            break;
                    }
                }
            });
        }
    }

    /**
     * Binding question 3 checkboxes
     */
    @BindViews({R.id.q3_alt_a,R.id.q3_alt_b,R.id.q3_alt_c,R.id.q3_alt_d}) CheckBox[] checkBoxes3;
    void question3Listener(){
        for(CheckBox checkBox : checkBoxes3){
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton aCheckBox, boolean checked) {
                    switch(aCheckBox.getId()){
                        case R.id.q3_alt_a:
                            if(aCheckBox.isChecked()) question3[0] = true; else question3[0] = false;
                            break;
                        case R.id.q3_alt_b:
                            if(aCheckBox.isChecked()) question3[1] = true; else question3[1] = false;
                            break;
                        case R.id.q3_alt_c:
                            if(aCheckBox.isChecked()) question3[2] = true; else question3[2] = false;
                            break;
                        case R.id.q3_alt_d:
                            if(aCheckBox.isChecked()) question3[3] = true; else question3[3] = false;
                            break;
                    }
                }
            });
        }
    }

    /**
     * Check answer for question 4
     * @param radioButton
     */
    @OnCheckedChanged({R.id.q4_alt_a, R.id.q4_alt_b, R.id.q4_alt_c, R.id.q4_alt_d})
    void onQuestion4(CompoundButton radioButton, boolean checked){
        if(checked){
            questionValidation[3] = true;
            if(radioButton.getId() == R.id.q4_alt_d){
                question4 = 1.0;
            }else{
                question4 = 0.0;
            }
        }
    }

    /**
     * Check answer for question 5
     * @param radioButton
     */
    @OnCheckedChanged({R.id.q5_alt_a, R.id.q5_alt_b, R.id.q5_alt_c, R.id.q5_alt_d})
    void onQuestion5(CompoundButton radioButton, boolean checked){
        if(checked){
            questionValidation[4] = true;
            if(radioButton.getId() == R.id.q5_alt_b){
                question5 = 1.0;
            }else{
                question5 = 0.0;
            }
        }
    }

    /**
     * Binding question 6 checkboxes
     */
    @BindViews({R.id.q6_alt_a,R.id.q6_alt_b,R.id.q6_alt_c,R.id.q6_alt_d}) CheckBox[] checkBoxes6;
    void question6Listener(){
        for(CheckBox checkBox : checkBoxes6){
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton aCheckBox, boolean checked) {
                    switch(aCheckBox.getId()){
                        case R.id.q6_alt_a:
                            if(aCheckBox.isChecked()) question6[0] = true; else question6[0] = false;
                            break;
                        case R.id.q6_alt_b:
                            if(aCheckBox.isChecked()) question6[1] = true; else question6[1] = false;
                            break;
                        case R.id.q6_alt_c:
                            if(aCheckBox.isChecked()) question6[2] = true; else question6[2] = false;
                            break;
                        case R.id.q6_alt_d:
                            if(aCheckBox.isChecked()) question6[3] = true; else question6[3] = false;
                            break;
                    }
                }
            });
        }
    }

    /**
     *  Submit Button Action.
     *  Check if the radio buttons questions were marked and then computes the score to finalize the quiz.
     */
    @OnClick(R.id.submitButton) void submit(){
        Context context = getApplicationContext();

        boolean isValid = false;
        for(int i = 0; i < questionValidation.length; i++){
            if(!questionValidation[i]){
                Toast.makeText(this, R.string.validationForm, Toast.LENGTH_LONG).show();
                break;
            } else isValid = true;
        }
        if(isValid){
            provideFeedback();
            disableInputs();
            scoreTextView.setText(String.format(getString(R.string.finalScoreMessage).toString(), computeScore(), TOTAL_SCORE));
            seeCorrectAnswers.setText(R.string.viewAnswersMessage);
            gbLogo.setBackgroundResource(R.drawable.giantbomblogo);
            submit.setVisibility(View.INVISIBLE);
            if(q7.length() != 0) sendEMail();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        question2Listener();
        question3Listener();
        question6Listener();
    }

    /**
     *  Method to disable the inputs after submit the form.
     */
    private void disableInputs(){
        for(RadioButton radio : radioButtons1){
            radio.setEnabled(false);
        }
        for(CheckBox checkbox : checkBoxes2){
            checkbox.setEnabled(false);
        }
        for(CheckBox checkbox : checkBoxes3){
            checkbox.setEnabled(false);
        }
        for(RadioButton radio : radioButtons4){
            radio.setEnabled(false);
        }
        for(RadioButton radio : radioButtons5){
            radio.setEnabled(false);
        }
        for(CheckBox checkbox : checkBoxes6){
            checkbox.setEnabled(false);
        }
    }

    /**
     *  Action to send an email
     */
    private void sendEMail(){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        String[] sendTo = new String[1];
        sendTo[0] = "email@email.com";
        intent.putExtra(Intent.EXTRA_EMAIL, sendTo);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Next Quiz");
        intent.putExtra(Intent.EXTRA_TEXT, q7.getText());
        startActivity(Intent.createChooser(intent,"Send questions for next quiz"));

    }

    /**
     *  Method to provide the feedback of the questions
     */
    private void provideFeedback(){
        answers[0].setText(R.string.q1_answer);
        radioButtons1[1].setBackgroundResource(R.color.colorPrimary);
        answers[1].setText(R.string.q2_answer);
        checkBoxes2[1].setBackgroundResource(R.color.colorPrimary);
        checkBoxes2[2].setBackgroundResource(R.color.colorPrimary);
        checkBoxes2[3].setBackgroundResource(R.color.colorPrimary);
        answers[2].setText(R.string.q3_answer);
        checkBoxes3[1].setBackgroundResource(R.color.colorPrimary);
        answers[3].setText(R.string.q4_answer);
        radioButtons4[3].setBackgroundResource(R.color.colorPrimary);
        answers[4].setText(R.string.q5_answer);
        radioButtons5[1].setBackgroundResource(R.color.colorPrimary);
        answers[5].setText(R.string.q6_answer);
        checkBoxes6[0].setBackgroundResource(R.color.colorPrimary);
        checkBoxes6[2].setBackgroundResource(R.color.colorPrimary);
        checkBoxes6[3].setBackgroundResource(R.color.colorPrimary);
    }

    /**
     * Calculates the final score
     * @return the score
     */
    private double computeScore(){
        double score = 0.0;
        score = question1 + question4 + question5;
        score += computeCheckBoxScore(question2, ANSWER2);
        score += computeCheckBoxScore(question3, ANSWER3);
        score += computeCheckBoxScore(question6, ANSWER6);
        return score;
    }

    /**
     * Calculates the score of the answers provided for checkbox question based on a template array.
     *
     * @param answer answers provided by user
     * @param correctAnswer the template array
     * @return score
     */
    private double computeCheckBoxScore(boolean[] answer, boolean[] correctAnswer){
        double questionScore = 0.0;
        for(int i = 0; i < answer.length; i++){
            if(answer[i] == correctAnswer[i]) questionScore += 0.25; else questionScore -= 0.25;
        }
        return questionScore;
    }

}
