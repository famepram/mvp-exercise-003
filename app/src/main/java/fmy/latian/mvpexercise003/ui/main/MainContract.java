package fmy.latian.mvpexercise003.ui.main;

import java.util.List;

import fmy.latian.mvpexercise003.data.models.Menu;

/**
 * Created by Femmy on 8/3/2017.
 */

public interface MainContract {

    interface View {
        void onMenusLoad(List<Menu> menus);

        void onNoMenuAvailable();

    }

    interface Presenter {
        void loadMenu();

        void addMenu(String name, String category, int price);
    }
}
