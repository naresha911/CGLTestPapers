package com.testpapers.nar.cgltestpapers;

import android.provider.BaseColumns;

/**
 * Created by nar on 5/10/2017.
 */

public final class DatabaseContract {
    public static abstract class DatabaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String SECOND_COLUMN = "name";
    }
}
