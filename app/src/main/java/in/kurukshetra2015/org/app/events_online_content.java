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


public class events_online_content extends ActionBarActivity {
    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    Intent i = new Intent(Intent.ACTION_VIEW);
    String url;
    private Toolbar toolbar;
    int position=0;


    String[] web = {
           "Sherlock","Online Programming Contest","Dalal Bull",
            "Cerebra","Athena","Riddles Of the Sphinx"
    };
    Integer[] imageId = {
            R.drawable.sherlock_main,
            R.drawable.onlinepc_main,
            R.drawable.dalalbull_main,
            R.drawable.cerebra_main,
            R.drawable.athena_main,
            R.drawable.ros_main



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
                        url = "http://m.kurukshetra.org.in/#/Events/Online/Sherlock";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "http://m.kurukshetra.org.in/#/Events/Online/Online%20Programming%20Contest";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url = "http://m.kurukshetra.org.in/#/Events/Online/Dalal%20bull";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 3:
                        url = "http://m.kurukshetra.org.in/#/Events/Online/Cerebra";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 4:
                        url = "http://m.kurukshetra.org.in/#/Events/Online/Athena";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 5:
                        url = "http://m.kurukshetra.org.in/#/Events/Online/Riddles%20of%20the%20Sphinx";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                }

            }
        });

        getSupportActionBar().setTitle(web[position]);

        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_online_sherlock_fragment.newInstance(), events_online_sherlock_fragment.TAG).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_online_opc_fragment.newInstance(), events_online_opc_fragment.TAG).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_online_db_fragment.newInstance(), events_online_db_fragment.TAG).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_online_cerebra_fragment.newInstance(), events_online_cerebra_fragment.TAG).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_online_athena_fragment.newInstance(), events_online_athena_fragment.TAG).commit();
                break;
            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_online_ros_fragment.newInstance(), events_online_ros_fragment.TAG).commit();
                break;
        }
    }

    Intent intent2=new Intent(Intent.ACTION_SEND);
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_share)
        {String text;
            switch (position)
            {

                case 0:
                    text="http://m.kurukshetra.org.in/#/Events/Online/Sherlock";

                    break;
                case 1:
                    text="http://m.kurukshetra.org.in/#/Events/Online/Online%20Programming%20Contest";
                    break;
                case 2:
                    text="http://m.kurukshetra.org.in/#/Events/Online/Dalal%20bull";
                    break;
                case 3:
                    text="http://m.kurukshetra.org.in/#/Events/Online/Cerebra";
                    break;
                case 4:
                    text="http://m.kurukshetra.org.in/#/Events/Online/Athena";
                    break;


                default:
                    text="http://m.kurukshetra.org.in/#/Events/Online/Riddles%20of%20the%20Sphinx";
                    break;


            }

            intent2.setType("text/plain");
            intent2.putExtra(Intent.EXTRA_TEXT,"Check out the "+web[position]+" event at Kurukshetra'15. "+text);
            startActivity(Intent.createChooser(intent2, "Share via . . ."));
        }
        return super.onOptionsItemSelected(item);
    }


    public void Callthenumber(View v){
        switch (v.getId()){
            case R.id.fab_online_tab_sherlock_contacts_karthikeyan:

                dial.setData(Uri.parse("tel:+918056361207"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_sherlock_contacts_arun_kumar:
                dial.setData(Uri.parse("tel:+919597829154"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_sherlock_contacts_vasantha_kumar:
                dial.setData(Uri.parse("tel:+918903459489"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_sherlock_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "sherlock@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_online_tab_opc_contacts_surendhar:
                dial.setData(Uri.parse("tel:+917708878744"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_opc_contacts_hari_krishnan:
                dial.setData(Uri.parse("tel:+919786402210"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_opc_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "opc@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_online_tab_db_contacts_gopinath:
                dial.setData(Uri.parse("tel:+919841221875"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_db_contacts_naveen:
                dial.setData(Uri.parse("tel:+918870543354"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_db_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "dalalbull@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_online_tab_cerebra_contacts_singara_velan:
                dial.setData(Uri.parse("tel:+918643863070"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_cerebra_contacts_sai_prasanna:
                dial.setData(Uri.parse("tel:+918903870810"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_cerebra_contacts_barathe_raja:
                dial.setData(Uri.parse("tel:+918144359181"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_cerebra_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "cerebra@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_online_tab_athena_contacts_adthiya:
                dial.setData(Uri.parse("tel:+918939222530"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_athena_contacts_anushya:
                dial.setData(Uri.parse("tel:+919884132925"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_athena_contacts_bala_lakshmi:
                dial.setData(Uri.parse("tel:+918124788103"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_athena_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "athena@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_online_tab_ros_contacts_karthikeyan:
                dial.setData(Uri.parse("tel:+918056361207"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_ros_contacts_arun_kumar:
                dial.setData(Uri.parse("tel:+919597829154"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_ros_contacts_aadhavan:
                dial.setData(Uri.parse("tel:+917708805455"));
                startActivity(dial);
                break;
            case R.id.fab_online_tab_ros_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "ros@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
        }
    }


}
