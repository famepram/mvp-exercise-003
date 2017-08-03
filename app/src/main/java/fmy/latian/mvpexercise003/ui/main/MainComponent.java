package fmy.latian.mvpexercise003.ui.main;

/**
 * Created by Femmy on 8/3/2017.
 */

import dagger.Component;

@Component(modules = MainPresenterModule.class)
public interface MainComponent{
    void inject(MainActivity mainActivity);
}
