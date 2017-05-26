package com.testpapers.nar.cgltestpapers;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by nar on 5/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static DatabaseHelper instance;
    public Context mContx;
    public SQLiteDatabase mDB;

    private static final String TAG = "DatabaseHelper";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TestPapers.db";
    public static final String Text_TYPE = "TEXT";
    public static final String DATABASE_PATH = "/data/data/com.testpapers.nar.cgltestpapers/databases/";;
    public static final String pwd = "fantastic@1";
    public static String DATABASE_FULL_PATH = DATABASE_PATH + DATABASE_NAME;

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContx = context;
        InitializeSQLCipher();
    }

    private void InitializeSQLCipher()
    {
    }

    public static synchronized DatabaseHelper getInstance(Context context)
    {
        if(instance == null)
            instance = new DatabaseHelper(context);
        return instance;
    }

    public void CreateDatabase() throws IOException
    {
        File dbFile = new File(DATABASE_FULL_PATH);
        if(dbFile.exists())
            dbFile.delete();
        boolean checkDb = CheckDatabaseExists();
        if(checkDb == false)
        {
            File dbPathFile = new File(DATABASE_FULL_PATH);
            if (!dbPathFile.exists())
                dbPathFile.getParentFile().mkdirs();

            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DATABASE_FULL_PATH, pwd, null);
            db.close();

            try{
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            }

            catch (SQLiteException mIOException)
            {
                throw new Error("ErrorCopyingDataBase");
            } catch (IOException e) {
                throw new Error("ErrorCopyingDataBase");
            }

        }
    }

    public void openDatabase() throws IOException
    {
        mDB = SQLiteDatabase.openDatabase(DATABASE_FULL_PATH, pwd, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void close()
    {
        mDB.close();
    }

    public boolean CheckDatabaseExists()
    {

        File file = new File(DATABASE_FULL_PATH);
        return file.exists();
    }

    public void copyDataBase() throws IOException
    {
        InputStream myInput = mContx.getAssets().open(DATABASE_NAME);
        OutputStream dbFile = new FileOutputStream(DATABASE_FULL_PATH);

        byte[] buffer = new byte[1024];
        while(myInput.read(buffer) >= 0)
        {
            dbFile.write(buffer);
        }

        dbFile.flush();
        dbFile.close();
        myInput.close();
    }

    public Context getContext()
    {
        return mContx;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
