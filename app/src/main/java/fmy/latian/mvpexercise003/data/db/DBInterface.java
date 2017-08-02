package fmy.latian.mvpexercise003.data.db;

import java.util.List;

import fmy.latian.mvpexercise003.data.models.Menu;

/**
 * Created by Femmy on 8/2/2017.
 */

public interface DBInterface {

    interface LoadMenusCallback {

        void onMenuLoaded(List<Menu> menus);

        void onMenuEmpty();
    }
}
