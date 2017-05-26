package Entities;

import java.util.StringTokenizer;

/**
 * Created by nar on 5/13/2017.
 */

public class Question {
    public String mQuestion;
    public String[] mOptions;
    public String mAnswers;

    public Question(String question, String options, String answers)
    {
        mQuestion = question;
        mOptions = options.split(";");
        mAnswers = answers;
    }

    public String getQuestion()
    {
        return mQuestion;
    }

    public String[] getOptions()
    {
        return mOptions;
    }

    public String getAnswers()
    {
        return mAnswers;
    }

    public String toString()
    {
        String question = mQuestion;

        String optionsStr = "";
        for(int ii = 0; ii < mOptions.length; ++ii)
        {
            if(ii%2 == 0)
                optionsStr += "\n";
            optionsStr += mOptions[ii] + "\t";
        }

        question += optionsStr;
        return (question);
    }
}
