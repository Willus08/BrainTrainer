package helpme_productions.com.braintrainer.view.activites.mainActivity;


import java.util.Random;

import helpme_productions.com.braintrainer.model.Question;

public class MainActivityPresenter implements MainActivityContract.Presenter{
    private MainActivityContract.View view;
    private Random random = new Random();
    //private float aveargeDifficulty;
    private int corectAnswerContainer;
   // int questionType;
    @Override
    public void addView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void nextQuestion(int score, int answered) {
        corectAnswerContainer= random.nextInt(4)+1;
//        if (answered >0) {
//         //  aveargeDifficulty = score / answered;
//        }
        additionQuestion();
    }

    @Override
    public void additionQuestion() {
        int first = random.nextInt(10)+1;
        int second = random.nextInt(10)+1;
        int sum = first + second;
        String questionAsked = first +" + "+ second +" = ?";
        int firstAnswer  = sum + random.nextInt(5)+1;
        int secondAnswer = sum - random.nextInt(5)-1;
        int thirdAnswer = sum + random.nextInt(5)+2;
        int forthAnswer = sum - random.nextInt(5)-2;
        switch (corectAnswerContainer){
            case 1:
                firstAnswer = sum;
                break;
            case 2:
                secondAnswer = sum;
                break;
            case 3:
                thirdAnswer = sum;
                break;
            case 4:
                forthAnswer = sum;
                break;
        }
        Question question = new Question(questionAsked,firstAnswer,secondAnswer,thirdAnswer,forthAnswer,corectAnswerContainer);
        view.setupButtons(question);
    }

    @Override
    public void subtractionQuestion() {

    }

    @Override
    public void multiplicationQuestion() {

    }

    @Override
    public void divisionQuestion() {

    }
}
