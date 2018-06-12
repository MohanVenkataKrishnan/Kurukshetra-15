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

/**
 * Created by goku on 13-12-2014.
 */
public class WorkshopFragment extends Fragment {


    public static final String TAG = WorkshopFragment.class.getSimpleName();
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    static int position=0;

    public static WorkshopFragment newInstance(int p)
    {
        position=p;
        return new WorkshopFragment();
    }

    @Override
    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
    }

    @Override
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View localView = paramLayoutInflater.inflate(R.layout.tab_pager, paramViewGroup, false);
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
            if(position==0)
            {
            switch (getArguments().getInt("section_number"))
            {
                default:
                    return null;
                case 1:
                    return paramLayoutInflater.inflate(R.layout.df_tabone, paramViewGroup, false);
                case 2:
                    return paramLayoutInflater.inflate(R.layout.df_tabtwo, paramViewGroup, false);
                case 3:
                    return paramLayoutInflater.inflate(R.layout.df_tabthree, paramViewGroup, false);
                case 4:
                    return paramLayoutInflater.inflate(R.layout.df_tabfour, paramViewGroup, false);

            }}
            if(position==1)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.rackit_one, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.reckit_two, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.reckit_three, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.reckit_four, paramViewGroup, false);

                }
            }

            if(position==2)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.pro_one, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.pro_two, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.pro_three, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.pro_four, paramViewGroup, false);

                }
            }

            if(position==3)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.ez_one, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.ez_two, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.ez_three, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.ez_four, paramViewGroup, false);

                }
            }

            if(position==4)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.iot_one, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.iot_two, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.iot_three, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.iot_four, paramViewGroup, false);

                }
            }

            if(position==5)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.bcr_one, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.bcr_two, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.bcr_three, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.bcr_four, paramViewGroup, false);

                }
            }
            if(position==6)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.ros_one, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.ros_two, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.ros_three, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.ros_four, paramViewGroup, false);

                }
            }
            if(position==7)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.follow_your_passion_intro, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.follow_your_passion_session, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.follow_your_passion_rules, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.follow_your_passion_contacts, paramViewGroup, false);

                }
            }
            if(position==8)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.biomimicry_intro, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.biomimicry_session, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.biomimicry_rules, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.biomimicry_contacts, paramViewGroup, false);

                }
            }
            if(position==9)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.reverse_engineering_intro, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.reverse_engineerimg_session, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.reverse_engineering_rules, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.reverse_engineering_contacts, paramViewGroup, false);

                }
            }
            if(position==10)
            {
                switch (getArguments().getInt("section_number"))
                {
                    default:
                        return null;
                    case 1:
                        return paramLayoutInflater.inflate(R.layout.ibmsipt_intro, paramViewGroup, false);
                    case 2:
                        return paramLayoutInflater.inflate(R.layout.ibmsipt_session, paramViewGroup, false);
                    case 3:
                        return paramLayoutInflater.inflate(R.layout.ibmsipt_rules, paramViewGroup, false);
                    case 4:
                        return paramLayoutInflater.inflate(R.layout.ibmsipt_contacts, paramViewGroup, false);

                }
            }
            return  null;
        }
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
                    return "Sessions".toUpperCase(localLocale);
                case 2:
                    return "Rules".toUpperCase(localLocale);
                case 3:
                    return "Contact".toUpperCase(localLocale);

            }
        }
    }

}
