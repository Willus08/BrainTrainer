package helpme_productions.com.braintrainer;


public interface BasePresenter<V extends BaseView> {
    void addView(V view);
    void removeView();
}
