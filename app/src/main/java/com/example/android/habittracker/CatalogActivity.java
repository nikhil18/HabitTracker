package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.habittracker.data.HabitDbHelper;

import static com.example.android.habittracker.data.HabitContract.HabitEntry;

public class CatalogActivity extends AppCompatActivity {

    private static final String TAG = CatalogActivity.class.getName();

    private HabitDbHelper mDbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HabitDbHelper habitsDBHelper = new HabitDbHelper(this);

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_DATE, "10/2/2017");
        values.put(HabitEntry.COLUMN_HABIT_YOGA, HabitEntry.YOGA_DONE);
        values.put(HabitEntry.COLUMN_HABIT_MEDICATION, HabitEntry.MEDICATION_NOT_DONE);
        values.put(HabitEntry.COLUMN_HABIT_WALK, HabitEntry.WALK_DONE);
        habitsDBHelper.insertHabit(values);

        Cursor habitRecord = habitsDBHelper.readHabits();

        Log.i(TAG, HabitEntry._ID + " - "
                + HabitEntry.COLUMN_HABIT_DATE + "-"
                + HabitEntry.COLUMN_HABIT_YOGA + "-"
                + HabitEntry.COLUMN_HABIT_MEDICATION + "-"
                + HabitEntry.COLUMN_HABIT_WALK);

        while (habitRecord.moveToNext()) {
            Log.i(TAG, habitRecord.getString(habitRecord.getColumnIndex(HabitEntry._ID)) + "\t" +
                    habitRecord.getString(habitRecord.getColumnIndex(HabitEntry.COLUMN_HABIT_DATE)) + "\t" +
                    habitRecord.getString(habitRecord.getColumnIndex(HabitEntry.COLUMN_HABIT_YOGA)) + "\t " +
                    habitRecord.getString(habitRecord.getColumnIndex(HabitEntry.COLUMN_HABIT_MEDICATION)) + "\t" +
                    habitRecord.getString(habitRecord.getColumnIndex(HabitEntry.COLUMN_HABIT_WALK)));

        }
        habitRecord.close();
    }
}
