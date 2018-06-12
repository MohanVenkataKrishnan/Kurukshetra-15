package in.kurukshetra2015.org.app;

/**
 * Created by Lalith on 18-Dec-14.
 */
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;

import com.astuetz.PagerSlidingTabStrip;





public class pro extends ActionBarActivity {

    private final Handler handler = new Handler();

    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    private ViewPager pager;
    private MyPagerAdapter adapter;
    private Toolbar toolbar;


    private Drawable oldBackground = null;
    private int currentColor = 0xFF666666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project);
        pager = (ViewPager) findViewById(R.id.pager);

        PagerSlidingTabStrip tabs=(PagerSlidingTabStrip)findViewById(R.id.tabs);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Projects");




        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);




    }



    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = { "Autogreen", "E-Glove", "Mine Closure Aid", "ORAA", "Pseudo Eyes","Robotic Scavanger","Walking Chair","Indigeneous 3d printer","Wireless Relay Communication"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            profrag.DummySectionFragment localDummySectionFragment = new profrag.DummySectionFragment();
            Bundle localBundle = new Bundle();
            localBundle.putInt("section_number", position + 1);
            localDummySectionFragment.setArguments(localBundle);
            return localDummySectionFragment;

        }


    }

}

