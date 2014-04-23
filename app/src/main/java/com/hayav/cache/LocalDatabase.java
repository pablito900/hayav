package com.hayav.cache;

import android.content.Context;
import android.database.sqlite.*;
import android.provider.BaseColumns;

/**
 * Created by pablito on 4/23/14.
 */
public class LocalDatabase {

    private LocalDatabaseHelper dbHelper;

    public LocalDatabase(Context context){
        dbHelper = new LocalDatabaseHelper(context);
    }

    //inner classes
    public static abstract class UserColumns implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_FACEBOOK_ID = "facebookid";

    }

    public static abstract class LoanColumns implements BaseColumns {
        public static final String TABLE_NAME = "loan";
        public static final String COLUMN_NAME_LOAN_DATE = "loan_date";
        public static final String COLUMN_NAME_DUE_DATE = "due_date";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_AMMOUNT = "ammount";
        public static final String COLUMN_NAME_USER_ID = "userid";
    }


    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_LOANS =
            "CREATE TABLE " + LoanColumns.TABLE_NAME + " (" +
                    LoanColumns._ID + " INTEGER PRIMARY KEY," +
                    LoanColumns.COLUMN_NAME_LOAN_DATE + TEXT_TYPE + COMMA_SEP +
                    LoanColumns.COLUMN_NAME_DUE_DATE + TEXT_TYPE + COMMA_SEP +
                    LoanColumns.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    LoanColumns.COLUMN_NAME_AMMOUNT + TEXT_TYPE + COMMA_SEP +
                    LoanColumns.COLUMN_NAME_USER_ID + TEXT_TYPE + COMMA_SEP +
                    " )";

    private static final String SQL_CREATE_USERS =
            "CREATE TABLE " + UserColumns.TABLE_NAME + " (" +
                    UserColumns._ID + " INTEGER PRIMARY KEY," +
                    UserColumns.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    UserColumns.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                    UserColumns.COLUMN_NAME_FACEBOOK_ID + TEXT_TYPE + COMMA_SEP +
                    " )";

    private static final String SQL_DELETE_LOANS =
            "DROP TABLE IF EXISTS " + LoanColumns.TABLE_NAME;

    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + UserColumns.TABLE_NAME;

    private class LocalDatabaseHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "hayav.db";

        public LocalDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_LOANS);
            db.execSQL(SQL_CREATE_USERS);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_LOANS);
            db.execSQL(SQL_DELETE_USERS);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }
}
