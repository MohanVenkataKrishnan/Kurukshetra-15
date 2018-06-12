package in.kurukshetra2015.org.app;

/**
 * Created by Lalith on 18-Dec-14.
 */

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class karnival extends ActionBarActivity {


    private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.karnival_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("K!arnival");

        final TextView text1=(TextView)findViewById(R.id.karnivel_text1);
        final TextView text2=(TextView)findViewById(R.id.karnivel_text2);
        final TextView text3=(TextView)findViewById(R.id.karnivel_text3);


        findViewById(R.id.layout_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text1.getVisibility()==View.GONE)
                    text1.setVisibility(View.VISIBLE);
                else
                    text1.setVisibility(View.GONE);

                if(text2.getVisibility()==View.VISIBLE)
                    text2.setVisibility(View.GONE);
                if(text3.getVisibility()==View.VISIBLE)
                    text3.setVisibility(View.GONE);
            }
        });
        findViewById(R.id.layout_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text2.getVisibility()==View.GONE)
                    text2.setVisibility(View.VISIBLE);
                else
                    text2.setVisibility(View.GONE);
                if(text1.getVisibility()==View.VISIBLE)
                    text1.setVisibility(View.GONE);
                if(text3.getVisibility()==View.VISIBLE)
                    text3.setVisibility(View.GONE);
            }
        });
        findViewById(R.id.layout_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text3.getVisibility()==View.GONE)
                    text3.setVisibility(View.VISIBLE);
                else
                    text3.setVisibility(View.GONE);
                if(text1.getVisibility()==View.VISIBLE)
                    text1.setVisibility(View.GONE);
                if(text2.getVisibility()==View.VISIBLE)
                    text2.setVisibility(View.GONE);
            }
        });




    }





}

