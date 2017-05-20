package com.testpapers.nar.cgltestpapers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        //Get list of items
        ArrayList<Question> questions = dbAdapter.GetAllQuestions();
        dbAdapter.close();

        //Build adapter
        ArrayAdapter<Question> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(questions);

        //Configure list view
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);
    }
}
