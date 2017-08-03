package fmy.latian.mvpexercise003.ui.main;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import fmy.latian.mvpexercise003.data.db.DBFunction;
import fmy.latian.mvpexercise003.data.db.DBInterface;
import fmy.latian.mvpexercise003.data.models.Menu;

/**
 * Created by Femmy on 8/3/2017.
 */

public class MainPresenter implements MainContract.Presenter{

    private Context ctx;

    private MainContract.View view;

    @Inject
    public MainPresenter(Context ctx, MainContract.View view){
        this.ctx = ctx;
        this.view = view;
    }

    @Override
    public void loadMenus() {
        DBFunction dbFunc = new DBFunction(ctx);
        dbFunc.getMenus(new DBInterface.LoadMenusCallback() {
            @Override
            public void onMenuLoaded(List<Menu> menus) {
                view.onMenusLoad(menus);
            }

            @Override
            public void onMenuEmpty() {

            }
        });
    }

    @Override
    public void addMenu(String name, String category, int price) {

    }

    @Override
    public void loadMenuItem(Menu menu) {
        view.onListItemClicked(menu);
    }
}
