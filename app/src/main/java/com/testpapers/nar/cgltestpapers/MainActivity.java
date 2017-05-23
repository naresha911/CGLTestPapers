package com.testpapers.nar.cgltestpapers;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import Entities.Question;
import fragments.HomeScreen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeScreen homeScreen = new HomeScreen();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_linear_layout, homeScreen, "MainActivityFragment");
        fragmentTransaction.commit();


       /* DatabaseAdapter dbAdapter = new DatabaseAdapter(this);
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
        listView.setAdapter(arrayAdapter);*/
    }
}
