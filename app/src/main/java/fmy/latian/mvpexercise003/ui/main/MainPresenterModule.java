package fmy.latian.mvpexercise003.ui.main;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by WebDev on 03/08/2017.
 */

@Module public class MainPresenterModule {

    private final Context ctx;

    private final MainContract.View view;

    public MainPresenterModule( Context ctx, MainContract.View view) {
        this.ctx = ctx;
        this.view = view;

    }

    @Provides
    Context provideContext(){
        return ctx;
    }

    @Provides
    MainContract.View provideMainContractView(){
        return view;
    }
}
