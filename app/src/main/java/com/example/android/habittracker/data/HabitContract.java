package com.example.android.habittracker.data;

import android.provider.BaseColumns;

public final class HabitContract {

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_DATE = "date";
        public final static String COLUMN_HABIT_YOGA = "yoga";
        public final static String COLUMN_HABIT_MEDICATION = "medication";
        public final static String COLUMN_HABIT_WALK = "walk";

        public final static int YOGA_NOT_DONE = 0;
        public final static int YOGA_DONE = 1;

        public final static int MEDICATION_NOT_DONE = 0;
        public final static int MEDICATION_DONE = 1;

        public final static int WALK_NOT_DONE = 0;
        public final static int WALK_DONE = 1;

    }


}