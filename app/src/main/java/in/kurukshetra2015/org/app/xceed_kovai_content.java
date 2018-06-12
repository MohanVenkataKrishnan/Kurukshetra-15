package in.kurukshetra2015.org.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class xceed_kovai_content extends ActionBarActivity {
    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent i = new Intent(Intent.ACTION_VIEW);
    String url;
    private Toolbar toolbar;
    int position=0;


    String[] web = {
           "Voice Controlled Robotics Workshop","Web Development Workshop"


    };
    Integer[] imageId = {
            R.drawable.vcrw,
            R.drawable.wdw,



    };

    private TextView t;
    private ImageView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.xceed_final_content);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = extras.getInt("POSITION");
        }

        t=(TextView)findViewById(R.id.worktext);
        t.setText(web[position]);
        v=(ImageView)findViewById(R.id.workimage);

        v.setImageResource(imageId[position]);
        findViewById(R.id.web_fb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(position){
                    case 0:
                        url = "http://m.kurukshetra.org.in/#/xceed/ktc-voice";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "http://m.kurukshetra.org.in/#/xceed/ktc-web";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;

                }

            }
        });

        getSupportActionBar().setTitle(web[position]);

        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, xceed_kovai_vcrw_fragment.newInstance(), xceed_kovai_vcrw_fragment.TAG).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, xceed_kovai_wdw_fragment.newInstance(), xceed_kovai_wdw_fragment.TAG).commit();
                break;

        }
    }

    Intent intent2 = new Intent(Intent.ACTION_SEND);


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (position)
        {
            case 0: intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT,"Checkout the "+"'"+web[position]+"'"+"  at Xceed Kurukshetra'15. "+"http://m.kurukshetra.org.in/#/xceed/ktc-voice");
                startActivity(Intent.createChooser(intent2, "Share via"));
                break;
            case 1:intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT,"Checkout the "+"'"+web[position]+"'"+"  at Xceed Kurukshetra'15. "+"http://m.kurukshetra.org.in/#/xceed/ktc-web");
                startActivity(Intent.createChooser(intent2, "Share via"));
                break;
        }


    return super.onOptionsItemSelected(item);
}


    public void Callthenumber(View v){
        switch (v.getId()){
            case R.id.fab_xceed_tab_vcrw_contacts_jeeva:

                dial.setData(Uri.parse("tel:+919688510059"));
                startActivity(dial);
                break;
            case R.id.fab_xceed_tab_vcrw_contacts_sanjay:
                dial.setData(Uri.parse("tel:+918883662904"));
                startActivity(dial);
                break;
            case R.id.fab_xceed_tab_wdw_contacts_jeeva:
                dial.setData(Uri.parse("tel:+919688510059"));
                startActivity(dial);
                break;
            case R.id.fab_xceed_tab_wdw_contacts_jai:
                dial.setData(Uri.parse("tel:+919865276660"));
                startActivity(dial);
                break;


        }
    }


}
