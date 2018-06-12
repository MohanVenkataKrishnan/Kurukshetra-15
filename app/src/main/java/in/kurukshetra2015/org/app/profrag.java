package in.kurukshetra2015.org.app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by goku on 13-12-2014.
 */
public class profrag extends Fragment {


    public static final String TAG = profrag.class.getSimpleName();
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
                    return paramLayoutInflater.inflate(R.layout.pro1, paramViewGroup, false);
                case 2:
                    return paramLayoutInflater.inflate(R.layout.pro2, paramViewGroup, false);
                case 3:
                    return paramLayoutInflater.inflate(R.layout.pro3, paramViewGroup, false);
                case 4:
                    return paramLayoutInflater.inflate(R.layout.pro4, paramViewGroup, false);
                case 5:
                    return paramLayoutInflater.inflate(R.layout.pro5, paramViewGroup, false);
                case 6:
                    return paramLayoutInflater.inflate(R.layout.pro6, paramViewGroup, false);
                case 7:
                    return paramLayoutInflater.inflate(R.layout.pro7, paramViewGroup, false);

                case 8:
                    return paramLayoutInflater.inflate(R.layout.pro8, paramViewGroup, false);

                case 9:
                    return paramLayoutInflater.inflate(R.layout.pro9, paramViewGroup, false);

            }}
    }

}




