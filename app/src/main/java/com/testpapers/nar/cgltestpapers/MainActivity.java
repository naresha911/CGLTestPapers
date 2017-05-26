package com.testpapers.nar.cgltestpapers;

import android.support.v4.app.Fragment;
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
import fragments.QuestionViewFragment;
import fragments.SearchListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddHomeScreenFragment();
    }

    public void OnTestPapersButtonClicked()
    {
        SearchListFragment searchListFragment = new SearchListFragment();

        DatabaseAdapter dbAdapter = new DatabaseAdapter(this);
        try {
            dbAdapter.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(dbAdapter == null)
            return;

        ArrayList<String> yearStrings = dbAdapter.GetColumnData(DatabaseContract.DatabaseEntry.YEAR);
        dbAdapter.close();

        searchListFragment.SetYearStrings(yearStrings);
        ReplaceFragment(searchListFragment, SearchListFragment.class.getSimpleName() );
    }

    public void OnSubmitButtonclicked(String year)
    {
        DatabaseAdapter dbAdapter = new DatabaseAdapter(this);
        try {
            dbAdapter.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(dbAdapter == null)
            return;

        ArrayList<Question> questions = dbAdapter.GetQuestionsForGivenColumn(year);
        dbAdapter.close();

        QuestionViewFragment questionViewFragment = new QuestionViewFragment();
        questionViewFragment.SetQuestionsToDisplay(questions);
        ReplaceFragment(questionViewFragment, QuestionViewFragment.class.getSimpleName() );
    }

    public void AddHomeScreenFragment()
    {
        HomeScreen homeScreen = new HomeScreen();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_linear_layout, homeScreen, "HomeScreen");
        fragmentTransaction.commit();
    }

    public void ReplaceFragment(Fragment newFragment, String nameOfFragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(nameOfFragment);
        fragmentTransaction.replace(R.id.main_linear_layout, newFragment);
        fragmentTransaction.commit();
    }
}
