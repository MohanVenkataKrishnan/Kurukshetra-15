package in.kurukshetra2015.org.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by goku on 13-12-2014.
 */
public class hosintro extends Fragment {


    public static final String TAG = hosintro.class.getSimpleName();
    public static class DummySectionFragment
            extends Fragment
    {
        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
        {
            switch (getArguments().getInt("section_number"))
            {
                default:
                    return null;
                case 1:
                    return paramLayoutInflater.inflate(R.layout.hos_intro, paramViewGroup, false);
                case 2:
                    return paramLayoutInflater.inflate(R.layout.hos_acc, paramViewGroup, false);
                case 3:
                    return paramLayoutInflater.inflate(R.layout.hos_ins, paramViewGroup, false);
                case 4:
                    return paramLayoutInflater.inflate(R.layout.hos_reach, paramViewGroup, false);
                case 5:
                    return paramLayoutInflater.inflate(R.layout.hos_faq, paramViewGroup, false);
                case 6:
                    return paramLayoutInflater.inflate(R.layout.hos_other, paramViewGroup, false);
                case 7:
                    return paramLayoutInflater.inflate(R.layout.hos_cont, paramViewGroup, false);



            }}
    }

}




