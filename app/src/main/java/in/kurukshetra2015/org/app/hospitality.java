package in.kurukshetra2015.org.app;

/**
 * Created by Lalith on 18-Dec-14.
 */
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;





    public class hospitality extends ActionBarActivity {

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
            setContentView(R.layout.hospital);
            pager = (ViewPager) findViewById(R.id.pager);

            PagerSlidingTabStrip tabs=(PagerSlidingTabStrip)findViewById(R.id.tabs);
            adapter = new MyPagerAdapter(getSupportFragmentManager());
            pager.setAdapter(adapter);
            tabs.setViewPager(pager);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("Hospitality");




            pager.setAdapter(adapter);

            final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                    .getDisplayMetrics());
            pager.setPageMargin(pageMargin);




        }

        public void Callthenumber(View v){ dial.setData(Uri.parse("tel:+919790471029"));
            startActivity(dial);
            }
        public void mailme(View v){ emailIntent.setData(Uri.parse("mailto:"));
            //emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "hospidesk@kurukshetra.org.in" });
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));

        }
        public void floatmap(View v)
        {
            Toast.makeText(getBaseContext(),"Please ensure your location settings are turned on",Toast.LENGTH_SHORT);
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=13°00'28.1\"N 80°14'08.6\"E"));

          /*  intent.setClassName("com.google.android.apps.maps","com.google.android.maps.MapsActivity");*/
            startActivity(intent);
        }


        public class MyPagerAdapter extends FragmentPagerAdapter {

            private final String[] TITLES = { "Introduction", "Accomodation", "Instruction", "Reaching CEG", "FAQs","Other Accomodation","Contact"};

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
           hosintro.DummySectionFragment localDummySectionFragment = new hosintro.DummySectionFragment();
                Bundle localBundle = new Bundle();
                localBundle.putInt("section_number", position + 1);
                localDummySectionFragment.setArguments(localBundle);
                return localDummySectionFragment;

            }


        }

    }

