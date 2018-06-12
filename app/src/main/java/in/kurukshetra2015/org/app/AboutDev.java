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

import com.astuetz.PagerSlidingTabStrip;





public class AboutDev extends ActionBarActivity {

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
        setContentView(R.layout.about_k);
        pager = (ViewPager) findViewById(R.id.pager);

        PagerSlidingTabStrip tabs=(PagerSlidingTabStrip)findViewById(R.id.tabs);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("About Us");




        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);






    }


    public void mailme(View v){ emailIntent.setData(Uri.parse("mailto:"));
        //emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "hospidesk@kurukshetra.org.in" });
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));

    }


    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = { "CEG", "CTF", "CYCLOTRON", "UNESCO", "DEVELOPERS"};

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
            aboutfrag.DummySectionFragment localDummySectionFragment = new aboutfrag.DummySectionFragment();
            Bundle localBundle = new Bundle();
            localBundle.putInt("section_number", position + 1);
            localDummySectionFragment.setArguments(localBundle);
            return localDummySectionFragment;

        }




    }

    public void Callthenumber(View dev){
        switch(dev.getId()){
            case R.id.calljai:
                dial.setData(Uri.parse("tel:9865276660"));
                startActivity(dial);
                break;
            case R.id.callgokul:
                dial.setData(Uri.parse("tel:9659172403"));
                startActivity(dial);
                break;
            case R.id.callmohan:
                dial.setData(Uri.parse("tel:9840490886"));
                startActivity(dial);
                break;
            case R.id.callranjith:
                dial.setData(Uri.parse("tel:9489970982"));
                startActivity(dial);
                break;
            case R.id.callsabari:
                dial.setData(Uri.parse("tel:9092155088"));
                startActivity(dial);
                break;
        }
    }

}

