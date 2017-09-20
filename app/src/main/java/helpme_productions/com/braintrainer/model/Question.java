package helpme_productions.com.braintrainer.model;



public class Question {
    private String questionAsked;
    private int firstAnswer;
    private int secondAnswer;
    private int thirdAnswer;
    private int forthAnswer;
    private int containsCorrectAnswer;

    public Question(String questionAsked, int firstAnswer, int secondAnswer, int thirdAnswer, int forthAnswer, int containsCorrectAnswer) {
        this.questionAsked = questionAsked;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.forthAnswer = forthAnswer;
        this.containsCorrectAnswer = containsCorrectAnswer;
    }

    public String getQuestionAsked() {
        return questionAsked;
    }

    public int getFirstAnswer() {
        return firstAnswer;
    }

    public int getSecondAnswer() {
        return secondAnswer;
    }

    public int getThirdAnswer() {
        return thirdAnswer;
    }

    public int getForthAnswer() {
        return forthAnswer;
    }

    public int getContainsCorrectAnswer() {
        return containsCorrectAnswer;
    }
}
