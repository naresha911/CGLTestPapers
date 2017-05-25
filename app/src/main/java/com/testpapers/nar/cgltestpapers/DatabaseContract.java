package com.testpapers.nar.cgltestpapers;

import android.provider.BaseColumns;

/**
 * Created by nar on 5/10/2017.
 */

public final class DatabaseContract {
    public static abstract class DatabaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "Questions";
        public static final String QUESTION = "_question";
        public static final String OPTIONS = "_options";
        public static final String ANSWER = "_answer";
        public static final String YEAR = "_year";
    }
}
