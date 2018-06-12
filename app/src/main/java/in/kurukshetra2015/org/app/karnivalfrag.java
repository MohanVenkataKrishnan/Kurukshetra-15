package in.kurukshetra2015.org.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by goku on 13-12-2014.
 */
public class karnivalfrag extends Fragment {


    public static final String TAG = karnivalfrag.class.getSimpleName();
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
                    return paramLayoutInflater.inflate(R.layout.karnival_dummytab1, paramViewGroup, false);
                case 2:
                    return paramLayoutInflater.inflate(R.layout.karnival_dummytab2, paramViewGroup, false);

            }}
    }

}




