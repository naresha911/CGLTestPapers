package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.testpapers.nar.cgltestpapers.R;

public class HomeScreen extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Button mTestPapersBtn;
    Button mAnalyseBtn;

    public HomeScreen() {
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
        return inflater.inflate(R.layout.fragment_home_screen, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTestPapersBtn = (Button)getActivity().findViewById(R.id.testpapers);
        mTestPapersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "TestPapers", Toast.LENGTH_SHORT).show();
            }
        });

        mAnalyseBtn = (Button)getActivity().findViewById(R.id.analyze);
        mAnalyseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Analyse", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
