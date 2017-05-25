package fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.testpapers.nar.cgltestpapers.R;

import java.util.ArrayList;

import Entities.Question;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionViewFragment extends Fragment {

    ArrayList<Question> mQuestionsToDisplay;
    public QuestionViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Build adapter
        ArrayAdapter<Question> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(mQuestionsToDisplay);

        //Configure list view
        ListView listView = (ListView) getActivity().findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
    }

    public void SetQuestionsToDisplay(ArrayList<Question> questionsToDisplay)
    {
        mQuestionsToDisplay = questionsToDisplay;
    }
}
