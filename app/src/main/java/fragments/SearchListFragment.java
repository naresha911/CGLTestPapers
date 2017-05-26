package fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.testpapers.nar.cgltestpapers.MainActivity;
import com.testpapers.nar.cgltestpapers.R;

import java.util.ArrayList;

public class SearchListFragment extends Fragment {
    Button mSubmitButton;
    Spinner mYearSpinnerButon;
    ArrayList<String> mYearStrings;

    Color mColor;
    public SearchListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_list, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSubmitButton = (Button) getActivity().findViewById(R.id.submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String year = (String)mYearSpinnerButon.getSelectedItem();
                ((MainActivity)getActivity()).OnSubmitButtonclicked(year);
            }
        });

        InitializeYearSpinner();
    }

    public void SetYearStrings(ArrayList<String> yearStrings)
    {
        mYearStrings = yearStrings;
    }

    public void SetColor(Color color)
    {
        mColor = color;
    }

    public void InitializeYearSpinner()
    {
        mYearSpinnerButon = (Spinner) getActivity().findViewById(R.id.year_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.addAll(mYearStrings);

        mYearSpinnerButon.setAdapter(arrayAdapter);
    }
}
