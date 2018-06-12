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


public class events_management_content extends ActionBarActivity {
    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    Intent i = new Intent(Intent.ACTION_VIEW);
    String url;
    private Toolbar toolbar;
    int position=0;


    String[] web = {
           "Chaos Theory","K! Idol","Marketing Madness"


    };
    Integer[] imageId = {
            R.drawable.chaostheory_main,
            R.drawable.kidol_main,
            R.drawable.marketingmadness_main

    };

    private TextView t;
    private ImageView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.events_final_content);
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
                        url = "http://m.kurukshetra.org.in/#/Events/Management/Chaos%20Theory";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "http://m.kurukshetra.org.in/#/Events/Management/K!%20Idol";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url = "http://m.kurukshetra.org.in/#/Events/Management/Marketing%20Madness";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;

                }

            }
        });

        getSupportActionBar().setTitle(web[position]);

        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_management_ct_fragment.newInstance(), events_management_ct_fragment.TAG).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_management_kidol_fragment.newInstance(), events_management_kidol_fragment.TAG).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_management_mm_fragment.newInstance(), events_management_mm_fragment.TAG).commit();
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    Intent intent2=new Intent(Intent.ACTION_SEND);
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_share)
        {String text;
            switch (position)
            {

                case 0:
                    text="http://m.kurukshetra.org.in/#/Events/Management/Chaos%20Theory";

                    break;
                case 1:
                    text="http://m.kurukshetra.org.in/#/Events/Management/K!%20Idol";
                    break;


                default:
                    text="http://m.kurukshetra.org.in/#/Events/Management/Marketing%20Madness";
                    break;


            }

            intent2.setType("text/plain");
            intent2.putExtra(Intent.EXTRA_TEXT,"Check out the "+web[position]+" event at kurukshetra'15. "+text);
            startActivity(Intent.createChooser(intent2, "Share via . . ."));
        }
        return super.onOptionsItemSelected(item);
    }



    public void Callthenumber(View v){
        switch (v.getId()){
            case R.id.fab_management_tab_ct_contacts_adharsh_gukan:

                dial.setData(Uri.parse("tel:+919487539200"));
                startActivity(dial);
                break;
            case R.id.fab_management_tab_ct_contacts_rajkumar:
                dial.setData(Uri.parse("tel:+917598346156"));
                startActivity(dial);
                break;
            case R.id.fab_management_tab_ct_contacts_gokulkumar:
                dial.setData(Uri.parse("tel:+919489313295"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_opc_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "chaostheory@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_management_tab_kidol_contacts_pradeep_kumar:
                dial.setData(Uri.parse("tel:+919444541635"));
                startActivity(dial);
                break;
            case R.id.fab_management_tab_kidol_contacts_lakshmanan:
                dial.setData(Uri.parse("tel:+919444302431"));
                startActivity(dial);
                break;
            case R.id.fab_management_tab_kidol_contacts_koushik:
                dial.setData(Uri.parse("tel:+918807851503"));
                startActivity(dial);
                break;
            case R.id.fab_management_tab_mm_contacts_praveen:
                dial.setData(Uri.parse("tel:+919791234840"));
                startActivity(dial);
                break;
            case R.id.fab_management_tab_mm_contacts_swetha:
                dial.setData(Uri.parse("tel:+919600129784"));
                startActivity(dial);
                break;
            case R.id.fab_management_tab_mm_contacts_ajay:
                dial.setData(Uri.parse("tel:+919841547969"));
                startActivity(dial);
                break;
            case R.id.fab_management_tab_mm_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "mmadness@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;


    }


}}
