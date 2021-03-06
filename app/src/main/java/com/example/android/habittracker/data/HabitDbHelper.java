package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.data.HabitContract.HabitEntry;

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final String COMMA_SEP = ", ";


    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
            + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HabitEntry.COLUMN_HABIT_DATE + " TEXT NOT NULL" + COMMA_SEP
            + HabitEntry.COLUMN_HABIT_YOGA + " INTEGER NOT NULL DEFAULT 0" + COMMA_SEP
            + HabitEntry.COLUMN_HABIT_MEDICATION + " INTEGER NOT NULL DEFAULT 0" + COMMA_SEP
            + HabitEntry.COLUMN_HABIT_WALK + " INTEGER NOT NULL DEFAULT 0" + ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME;

    public static final int DATABSE_VERSION = 1;

    public static final String DATABASE_NAME = "Habit.db";

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        System.out.println("Create table " + SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
    }

    public void insertHabit(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
            db.insert(HabitEntry.TABLE_NAME, null, values);
        db.close();

    }

    public Cursor readHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_DATE,
                HabitEntry.COLUMN_HABIT_YOGA,
                HabitEntry.COLUMN_HABIT_MEDICATION,

        };

        Cursor cursor = db.query(HabitEntry.TABLE_NAME, null,
                null, null,
                null, null, null);

        return cursor;
    }


}
