package fmy.latian.mvpexercise003.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Femmy on 8/2/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "peeyowesc.db";

    private static String CREATE_TABLE_MENU =
            "CREATE TABLE " + DBConstant.TABLE_NAME_MENU + "( "+
                    DBConstant.TABLE_COLNAME_MENU_ID + DBConstant.DATATYPE_TEXT + " PRIMARY KEY," +
                    DBConstant.TABLE_COLNAME_MENU_NAME  + DBConstant.DATATYPE_TEXT  + ", " +
                    DBConstant.TABLE_COLNAME_MENU_CATEGORY + DBConstant.DATATYPE_TEXT + ", " +
                    DBConstant.TABLE_COLNAME_MENU_PRICE + DBConstant.DATATYPE_INTEGER +
                    " )";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MENU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
