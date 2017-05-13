package com.testpapers.nar.cgltestpapers;

import android.content.Context;
import android.database.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;

import java.io.File;
import java.io.IOException;

/**
 * Created by nar on 5/10/2017.
 */

public class DatabaseAdapter {
    public DatabaseHelper mDBHelper;

    public DatabaseAdapter(Context context)
    {
        SQLiteDatabase.loadLibs(context);
        mDBHelper = DatabaseHelper.getInstance(context);
    }

    public void open() throws IOException
    {
        try {
            mDBHelper.CreateDatabase();
        }
        catch (SQLiteException e)
        {
            File dbFile = new File(DatabaseHelper.DATABASE_FULL_PATH);
            if(dbFile.exists())
                dbFile.delete();

        }
        mDBHelper.openDatabase();
    }

    public void close()
    {
        if(mDBHelper != null)
            mDBHelper.close();
    }

    public void ShowAllColumns()
    {
        SQLiteDatabase db = m DBHelper.getWritableDatabase(DatabaseHelper.pwd);
        if(db == null)
            return;

        String[] columns = { DatabaseContract.DatabaseEntry._ID, DatabaseContract.DatabaseEntry.SECOND_COLUMN};
        Cursor cursor = db.query(DatabaseContract.DatabaseEntry.TABLE_NAME, columns, null, null, null, null, null);

        String allData = "";
        while(cursor.moveToNext())
        {
            String idString = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry._ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry.SECOND_COLUMN));

            allData += idString + " " + name + "\n";
        }

    }

}
