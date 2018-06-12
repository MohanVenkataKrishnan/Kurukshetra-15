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

public class xceed_kovai_wdw_fragment extends Fragment {


    public static final String TAG = xceed_kovai_wdw_fragment.class.getSimpleName();
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    public static xceed_kovai_wdw_fragment newInstance()
    {
        return new xceed_kovai_wdw_fragment();
    }

    @Override
    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);

    }

    @Override
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View localView = paramLayoutInflater.inflate(R.layout.xceed_tab_pager, paramViewGroup, false);
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
                    return paramLayoutInflater.inflate(R.layout.xceed_kovai_wdw_intro, paramViewGroup, false);
                case 2:
                    return paramLayoutInflater.inflate(R.layout.xceed_kovai_wdw_format, paramViewGroup, false);
                case 3:

                    return paramLayoutInflater.inflate(R.layout.xceed_kovai_wdw_rules, paramViewGroup, false);
                case 4:

                    return paramLayoutInflater.inflate(R.layout.xceed_kovai_wdw_contacts, paramViewGroup, false);
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
                    return "Who can Attend?".toUpperCase(localLocale);
                case 2:
                    return "Topics Covered".toUpperCase(localLocale);
                case 3:
                    return "Contact".toUpperCase(localLocale);


            }
        }
    }

}
