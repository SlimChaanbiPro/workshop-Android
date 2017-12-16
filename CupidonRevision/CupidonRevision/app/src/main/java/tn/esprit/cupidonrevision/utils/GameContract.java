package tn.esprit.cupidonrevision.utils;

import android.provider.BaseColumns;

/**
 * Created by wael on 09/10/2017.
 */

public final class GameContract {

    public GameContract() {
    }

    public static class CupidEntry implements BaseColumns{
        public static final String TABLE_NAME = "cupid";
        public static final String COLUMN_FILLE = "fille";
        public static final String COLUMN_GARCON = "garcon";
        public static final String COLUMN_SCORE = "score";
    }
}
