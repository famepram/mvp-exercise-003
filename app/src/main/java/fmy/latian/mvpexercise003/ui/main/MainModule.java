package fmy.latian.mvpexercise003.ui.main;

import dagger.Module;
import dagger.Provides;

/**
 * Created by WebDev on 03/08/2017.
 */

@Module
public class  MainModule {

    private final MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    MainContract.View provideMainContractView(){
        return view;
    }
}
