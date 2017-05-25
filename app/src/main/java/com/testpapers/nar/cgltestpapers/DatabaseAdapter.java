package com.testpapers.nar.cgltestpapers;

import android.content.Context;
import android.database.Cursor;
import android.text.style.QuoteSpan;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import Entities.Question;

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

    public ArrayList<Question> GetAllQuestions()
    {
        ArrayList<Question> allData = new ArrayList<>();

        SQLiteDatabase db = mDBHelper.getWritableDatabase(DatabaseHelper.pwd);
        if(db == null)
            return allData;

        String[] columns = { DatabaseContract.DatabaseEntry._ID,
                DatabaseContract.DatabaseEntry.QUESTION,
                DatabaseContract.DatabaseEntry.OPTIONS,
                DatabaseContract.DatabaseEntry.ANSWER,
                DatabaseContract.DatabaseEntry.YEAR};
        Cursor cursor = db.query(DatabaseContract.DatabaseEntry.TABLE_NAME, columns, null, null, null, null, null);

        while(cursor.moveToNext())
        {
            String idString = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry._ID));
            String question = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry.QUESTION));
            String options = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry.OPTIONS));
            String answer = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry.ANSWER));

            Question questionEntity = new Question(question, options, answer);
            allData.add(questionEntity);
        }

        db.close();
        return allData;
    }

    public ArrayList<Question> GetQuestionsForGivenColumn(String columnName)
    {
        ArrayList<Question> questions = new ArrayList<>();

        SQLiteDatabase db = mDBHelper.getReadableDatabase(DatabaseHelper.pwd);
        if(db == null)
            return null;

        String[] columns = { DatabaseContract.DatabaseEntry._ID,
                DatabaseContract.DatabaseEntry.QUESTION,
                DatabaseContract.DatabaseEntry.OPTIONS,
                DatabaseContract.DatabaseEntry.ANSWER,
                DatabaseContract.DatabaseEntry.YEAR};

        String whereClause = "_year = ?";
        String whereArgs[] = {columnName};

        Cursor cursor = db.query(DatabaseContract.DatabaseEntry.TABLE_NAME, columns, whereClause, whereArgs, null, null, null);

        while(cursor.moveToNext())
        {
            String idString = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry._ID));
            String question = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry.QUESTION));
            String options = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry.OPTIONS));
            String answer = cursor.getString(cursor.getColumnIndex(DatabaseContract.DatabaseEntry.ANSWER));

            Question questionEntity = new Question(question, options, answer);
            questions.add(questionEntity);
        }

        db.close();
        return questions;

    }

}
