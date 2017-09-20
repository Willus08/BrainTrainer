package helpme_productions.com.braintrainer.view.activites.mainActivity;


import helpme_productions.com.braintrainer.BasePresenter;
import helpme_productions.com.braintrainer.BaseView;
import helpme_productions.com.braintrainer.model.Question;

public interface MainActivityContract {
    interface View extends BaseView{
        void startGame();
        void setupButtons(Question question);
        void checkAnswers(int selected);
    }
    interface Presenter extends BasePresenter<View>{
        void nextQuestion(int score, int answered);
        void additionQuestion();
        void subtractionQuestion();
        void multiplicationQuestion();
        void divisionQuestion();

    }
}
