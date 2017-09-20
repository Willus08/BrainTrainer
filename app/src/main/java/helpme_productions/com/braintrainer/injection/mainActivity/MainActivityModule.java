package helpme_productions.com.braintrainer.injection.mainActivity;


import dagger.Module;
import dagger.Provides;
import helpme_productions.com.braintrainer.view.activites.mainActivity.MainActivityPresenter;
@Module
public class MainActivityModule {
    @Provides
    MainActivityPresenter mainActivityPresenterProvider(){
        return new MainActivityPresenter();
    }
}
