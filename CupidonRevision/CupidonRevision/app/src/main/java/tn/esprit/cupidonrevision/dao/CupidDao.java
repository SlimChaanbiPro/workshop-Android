package tn.esprit.cupidonrevision.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.cupidonrevision.helpers.CupidOpenHelper;
import tn.esprit.cupidonrevision.models.Cupidon;
import tn.esprit.cupidonrevision.utils.GameContract;

/**
 * Created by wael on 09/10/2017.
 */

public class CupidDao {

    CupidOpenHelper mDbHelper;

    public CupidDao(Context context) {
        mDbHelper = new CupidOpenHelper(context);
    }

    public long insertcupid(Cupidon cupid){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(GameContract.CupidEntry.COLUMN_FILLE, cupid.getNom_fille());
        cv.put(GameContract.CupidEntry.COLUMN_GARCON, cupid.getNom_garcon());
        cv.put(GameContract.CupidEntry.COLUMN_SCORE, cupid.getScore());
        return db.insert(GameContract.CupidEntry.TABLE_NAME, null, cv);
    }

    public List<Cupidon> getAllcupids(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        List<Cupidon> cupids = new ArrayList<>();
        Cursor cursor = db.query(GameContract.CupidEntry.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Cupidon cupid = new Cupidon();
            cupid.setNom_fille(cursor.getString(1));
            cupid.setNom_garcon(cursor.getString(2));
            cupid.setScore(cursor.getInt(3));
            cupids.add(cupid);
            cursor.moveToNext();
        }
        cursor.close();
        return cupids;
    }

    public void deleteAll(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.delete(GameContract.CupidEntry.TABLE_NAME, null, null);
    }
}
