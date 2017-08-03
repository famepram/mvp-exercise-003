package fmy.latian.mvpexercise003.ui.main;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by Femmy on 8/3/2017.
 */

public class MainPresenter implements MainContract.Presenter{

//    private Context ctx;

    private MainContract.View view;

    @Inject
    public MainPresenter( MainContract.View view){
//        this.ctx = ctx;
        this.view = view;
    }

    @Override
    public void loadMenu() {

    }

    @Override
    public void addMenu(String name, String category, int price) {

    }
}
