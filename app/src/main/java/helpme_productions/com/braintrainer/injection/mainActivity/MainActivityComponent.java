package helpme_productions.com.braintrainer.injection.mainActivity;


import dagger.Component;
import helpme_productions.com.braintrainer.view.activites.mainActivity.MainActivity;
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
