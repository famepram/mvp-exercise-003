package fmy.latian.mvpexercise003.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import fmy.latian.mvpexercise003.data.models.Menu;

/**
 * Created by Femmy on 8/2/2017.
 */

public class DBFunction {

    private DBHelper mDBHelper;

    public DBFunction(Context ctx){
        mDBHelper = new DBHelper(ctx);
    }

    public void getMenus(@NonNull DBInterface.LoadMenusCallback loadMenusCallback){
        List<Menu> menus = new ArrayList<Menu>();
        SQLiteDatabase db = mDBHelper.getReadableDatabase();

        String[] projection = {
                DBConstant.TABLE_COLNAME_MENU_ID,
                DBConstant.TABLE_COLNAME_MENU_NAME,
                DBConstant.TABLE_COLNAME_MENU_CATEGORY,
                DBConstant.TABLE_COLNAME_MENU_PRICE
        };

        Cursor c = db.query(DBConstant.TABLE_NAME_MENU, projection, null, null, null, null, null);
        if(c != null && c.getCount() > 0){
            while(c.moveToNext()){
                String _id      = c.getString(c.getColumnIndexOrThrow(DBConstant.TABLE_COLNAME_MENU_ID));
                String _name    = c.getString(c.getColumnIndexOrThrow(DBConstant.TABLE_COLNAME_MENU_NAME));
                String _cat     = c.getString(c.getColumnIndexOrThrow(DBConstant.TABLE_COLNAME_MENU_CATEGORY));
                int _price      = c.getInt(c.getColumnIndexOrThrow(DBConstant.TABLE_COLNAME_MENU_PRICE));
                Menu menu       = new Menu();
                menu.setId(_id);
                menu.setName(_name);
                menu.setCategory(_cat);
                menu.setPrice(_price);
                menus.add(menu);

            }
        }

        if (c != null) {
            c.close();
        }

        db.close();

        if(menus.isEmpty()){
            loadMenusCallback.onMenuEmpty();
        } else {
            loadMenusCallback.onMenuLoaded(menus);
        }
    }

}
