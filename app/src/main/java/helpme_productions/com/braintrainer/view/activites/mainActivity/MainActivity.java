package helpme_productions.com.braintrainer.view.activites.mainActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import helpme_productions.com.braintrainer.R;
import helpme_productions.com.braintrainer.injection.mainActivity.DaggerMainActivityComponent;
import helpme_productions.com.braintrainer.model.Question;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    @Inject MainActivityPresenter presenter;
    @BindView(R.id.btnAnswer1)
    Button answer1;
    @BindView(R.id.btnAnswer2)
    Button answer2;
    @BindView(R.id.btnAnswer3)
    Button answer3;
    @BindView(R.id.btnAnswer4)
    Button answer4;
    @BindView(R.id.btnRestart)
    Button restart;
    @BindView(R.id.llStart)
    LinearLayout startLayout;
    @BindView(R.id.llGameContainer)
    LinearLayout gameLayout;
    @BindView(R.id.tvScore)
    TextView score;
    @BindView(R.id.tvTimer)
    TextView timerBox;
    @BindView(R.id.tvQuestion)
    TextView questionAsked;

    private int currentCorect = 0;
    private int currentAnswered = 0;
    private Question currentQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupDagger();
        presenter.addView(this);
    }

    @Override
    public void showError(Error error) {

    }

    @Override
    public void setupDagger() {
        DaggerMainActivityComponent.create().inject(this);
    }

    public void beginGame(View view) {
        startGame();
    }

    public void clickedAnswer(View view) {
        switch (view.getId()){
            case R.id.btnAnswer1:
                checkAnswers(1);
                break;
            case R.id.btnAnswer2:
                checkAnswers(2);
                break;
            case R.id.btnAnswer3:
                checkAnswers(3);
                break;
            case R.id.btnAnswer4:
                checkAnswers(4);
                break;
        }
    }

    @Override
    public void startGame() {
        startLayout.setVisibility(View.GONE);
        gameLayout.setVisibility(View.VISIBLE);
        answer4.setEnabled(true);
        answer3.setEnabled(true);
        answer2.setEnabled(true);
        answer1.setEnabled(true);
        currentCorect = 0;
        currentAnswered = 0;
        String scoreText = "Score: " + currentCorect+"/"+currentAnswered;
        score.setText(scoreText);
        restart.setVisibility(View.GONE);
        startTimer();
        presenter.nextQuestion(currentCorect,currentAnswered);
    }

    @Override
    public void setupButtons(Question question) {
        this.currentQuestion = question;
        String firstAnswer = "" + question.getFirstAnswer();
        String secondAnswer = "" + question.getSecondAnswer();
        String thirdAnswer = "" + question.getThirdAnswer();
        String forthAswer = "" + question.getForthAnswer();
        answer1.setText(firstAnswer);
        answer2.setText(secondAnswer);
        answer3.setText(thirdAnswer);
        answer4.setText(forthAswer);
        questionAsked.setText(question.getQuestionAsked());

    }

    @Override
    public void checkAnswers(int selected) {
        currentAnswered++;
        if (selected == currentQuestion.getContainsCorrectAnswer()){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            currentCorect++;
        }else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        }
        String scoreText = "Score: " + currentCorect+"/"+currentAnswered;
        score.setText(scoreText);
        presenter.nextQuestion(currentCorect,currentAnswered);
    }
    public void startTimer(){
        new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long l) {
                String timerText = "Time: "+ l/1000;
                timerBox.setText(timerText);
            }

            @Override
            public void onFinish() {
                String timerText = "Time: 0";
                timerBox.setText(timerText);
                endGame();
            }
        }.start();
    }

    private void endGame() {
        answer4.setEnabled(false);
        answer3.setEnabled(false);
        answer2.setEnabled(false);
        answer1.setEnabled(false);
        restart.setVisibility(View.VISIBLE);
        String finalScore = "Congradulations your final score was: "+ currentCorect +"/"+ currentAnswered;
        Toast.makeText(this, finalScore, Toast.LENGTH_LONG).show();

    }

    public void restartGame(View view) {
        startGame();
    }
}
