package in.kurukshetra2015.org.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

public class events_general_mm_fragment extends Fragment {


    public static final String TAG = events_general_mm_fragment.class.getSimpleName();
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    public static events_general_mm_fragment newInstance()
    {
        return new events_general_mm_fragment();
    }

    @Override
    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);

    }

    @Override
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View localView = paramLayoutInflater.inflate(R.layout.events_tab_pager, paramViewGroup, false);
        this.mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        this.mViewPager = ((ViewPager)localView.findViewById(R.id.pager));
        this.mViewPager.setAdapter(this.mSectionsPagerAdapter);

        return localView;
    }




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
                    return paramLayoutInflater.inflate(R.layout.events_general_tab_mm_intro, paramViewGroup, false);
                case 2:
                    return paramLayoutInflater.inflate(R.layout.events_general_tab_mm_format, paramViewGroup, false);
                case 3:

                    return paramLayoutInflater.inflate(R.layout.events_general_tab_mm_rules, paramViewGroup, false);
                case 4:

                    return paramLayoutInflater.inflate(R.layout.events_general_tab_mm_contacts, paramViewGroup, false);
            }}


    }


    public class SectionsPagerAdapter
            extends FragmentPagerAdapter
    {
        public SectionsPagerAdapter(FragmentManager paramFragmentManager)
        {
            super(paramFragmentManager);
        }

        @Override
        public int getCount()
        {

            return 4;
        }

        @Override
        public Fragment getItem(int paramInt)
        {
            DummySectionFragment localDummySectionFragment = new DummySectionFragment();
            Bundle localBundle = new Bundle();
            localBundle.putInt("section_number", paramInt + 1);
            localDummySectionFragment.setArguments(localBundle);
            return localDummySectionFragment;
        }

        @Override
        public CharSequence getPageTitle(int paramInt)
        {
            Locale localLocale = Locale.getDefault();
            switch (paramInt)
            {
                default:
                    return null;
                case 0:
                    return "Introduction".toUpperCase(localLocale);
                case 1:
                    return "Format".toUpperCase(localLocale);
                case 2:
                    return "Rules".toUpperCase(localLocale);
                case 3:
                    return "Contact".toUpperCase(localLocale);


            }
        }
    }

}
