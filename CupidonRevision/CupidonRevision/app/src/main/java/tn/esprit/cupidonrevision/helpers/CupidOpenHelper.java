package tn.esprit.cupidonrevision.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tn.esprit.cupidonrevision.utils.GameContract;

/**
 * Created by wael on 09/10/2017.
 */

public class CupidOpenHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "cupid.db";
    public static final String COMMA_SEP = ",";
    public static final String TEXT_TYPE = " TEXT";

    public static final String CREATE_CIGARETTE_ENTRY_SQL =
            "CREATE TABLE "+ GameContract.CupidEntry.TABLE_NAME+" ("
            +GameContract.CupidEntry._ID+" INTEGER PRIMARY KEY"+COMMA_SEP
            +GameContract.CupidEntry.COLUMN_FILLE+TEXT_TYPE+COMMA_SEP
                    +GameContract.CupidEntry.COLUMN_GARCON+TEXT_TYPE+COMMA_SEP
            +GameContract.CupidEntry.COLUMN_SCORE+" INTEGER )";

    public static final String DELETE_CIGARETTE_ENTRY_SQL =
            "DROP TABLE IF EXISTS "+GameContract.CupidEntry.TABLE_NAME;


    public CupidOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CIGARETTE_ENTRY_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_CIGARETTE_ENTRY_SQL);
        onCreate(sqLiteDatabase);
    }

}
