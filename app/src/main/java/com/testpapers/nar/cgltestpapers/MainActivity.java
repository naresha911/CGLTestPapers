package com.testpapers.nar.cgltestpapers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

import Entities.Question;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseAdapter dbAdapter = new DatabaseAdapter(this);
        try {
            dbAdapter.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Question> questions = dbAdapter.GetAllQuestions();
        dbAdapter.close();


    }
}
