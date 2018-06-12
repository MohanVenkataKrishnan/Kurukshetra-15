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

/**
 * Created by goku on 13-12-2014.
 */
public class WorkshopContent extends ActionBarActivity {

    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    Intent i = new Intent(Intent.ACTION_VIEW);
    String url;
    private Toolbar toolbar;
    int position = 0;
    Intent intent2 = new Intent(Intent.ACTION_SEND);


    String[] web = {
            "Digital Freeze",
            "K!rack it",
            "Protection Relays in Power Systems",
            "eZsystems",
            "Internet of Things",
            "Brainwave controlled Robots",
            "Robot Operating Systems",
            "Follow your Passion",
            "Biomimicry",
            "Reverse Engineering",
            "IBM's Security Intelligence with Penetration Testing"


    };
    Integer[] imageId = {
            R.drawable.digfree_main,
            R.drawable.kractit_main,
            R.drawable.protection,
            R.drawable.ez_1,
            R.drawable.internetof,
            R.drawable.brainwave_main,
            R.drawable.ros,
            R.drawable.follow1,
            R.drawable.biomimicry_main,
            R.drawable.reverse_engg_main,
            R.drawable.ibmsecurity_main


    };

    private TextView t;
    private ImageView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.workshop_content);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = extras.getInt("POSITION");
        }

        t = (TextView) findViewById(R.id.worktext);
        t.setText(web[position]);
        v = (ImageView) findViewById(R.id.workimage);

        v.setImageResource(imageId[position]);
        findViewById(R.id.web_fb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {
                    case 0:
                        url = "http://m.kurukshetra.org.in/#/Workshops/Digital%20Freeze";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "http://m.kurukshetra.org.in/#/Workshops/K!rack%20it";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url = "http://m.kurukshetra.org.in/#/Workshops/Protection%20Relays%20in%20Power%20Systems";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 3:
                        url = "http://m.kurukshetra.org.in/#/Workshops/eZsystems";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 4:
                        url = "http://m.kurukshetra.org.in/#/Workshops/Internet%20of%20Things";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 5:
                        url = "http://m.kurukshetra.org.in/#/Workshops/Brainwave%20controlled%20Robots";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 6:
                        url = "http://m.kurukshetra.org.in/#/Workshops/Robot%20Operating%20System";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 7:
                        url = "http://m.kurukshetra.org.in/#/Workshops/Follow%20your%20Passion";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 8:
                        url = "http://m.kurukshetra.org.in/#/Workshops/Biomimicry";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 9:
                        url = "http://m.kurukshetra.org.in/#/Workshops/Reverse%20Engineering";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 10:
                        url = "http://m.kurukshetra.org.in/#/Workshops/IBM's%20Security%20Intelligence%20with%20penetration%20Testing";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                }

            }
        });

        getSupportActionBar().setTitle(web[position]);


        getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, WorkshopFragment.newInstance(position), WorkshopFragment.TAG).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_share)
        {String text;
          String workshop;
            switch (position)
            {

                case 0:workshop="Digital Freeze";
                    text="Hey! Master your photography skills to capture the best moment of your life! Checkout the 'Digital Freeze' workshop at Kurukshetra '15. http://m.kurukshetra.org.in/#/Workshops/Digital%20Freeze ";
                    break;
                case 1:workshop="K!rack it";
                    text="Problem solving made easier and faster! Checkout the 'K!rack it' workshop at Kurukshetra '15. http://m.kurukshetra.org.in/#/Workshops/K!rack%20it ";
                    break;
                case 2:workshop="Power Systems";
                    text="Ever wondered how quick relays can act to protect circuits and expensive equipments! Checkout the 'Protection relays in Power Systems' workshop at Kurukshetra '15.http://m.kurukshetra.org.in/#/Workshops/Protection%20Relays%20in%20Power%20Systems";
                    break;
                case 3:workshop="eZsystems";
                    text="Hey! Designing complex micro-controllers and embedded systems can be as easy as dragging and dropping components! Checkout the 'eZsystems' workshop at Kurukshetra '15. http://m.kurukshetra.org.in/#/Workshops/eZsystems";
                    break;
                case 4:workshop="Internet of Things";
                    text="nternet is the future and stay updated when it takes control by storm! Checkout the 'Internet of Things' workshop at Kurukshetra '15. http://m.kurukshetra.org.in/#/Workshops/Internet%20of%20Things";
                    break;
                case 5:workshop="Brainwave controlled Robots";
                    text="Hey! Ever imagined you can control a robot just by the impulses of your brain? Checkout the 'Brainwave Controlled Robots' workshop at Kurukshetra '15.http://m.kurukshetra.org.in/#/Workshops/Brainwave%20controlled%20Robots";
                    break;
                case 6:workshop="Robot operating systems";
                    text="Hey! Developing complex and robust robot applications is now easier! Checkout the 'Robot Operating System' workshop at Kurukshetra '15. http://m.kurukshetra.org.in/#/Workshops/Robot%20Operating%20System";
                    break;
                case 7:workshop="Follow your passion";
                    text="Hey! Ever wondered how you could build a business around your passion? Checkout the 'Follow you Passion' workshop at Kurukshetra '15. http://m.kurukshetra.org.in/#/Workshops/Follow%20your%20Passion";
                    break;
                case 8:workshop="Biomimicry";
                    text="Ever imagined if you could take inspiration from nature to solve design and engineering problems? Checkout the 'Biomimicry' workshop at Kurukshetra '15.http://m.kurukshetra.org.in/#/Workshops/Biomimicry";
                    break;
                case 9:workshop="Reverse Engineering";
                    text="Hey! learn to extract knowledge from anything man-made! Checkout the 'Reverse Engineering' workshop at Kurukshetra '15. http://m.kurukshetra.org.in/#/Workshops/Reverse%20Engineering";
                    break;
                default:workshop="IBM's Security Intelligence with penetration Testing ";
                    text="With IBM's expertise, feel secure from cyber attacks! Checkout the 'IBM's Security Intelligence with Penetration testing' workshop at Kurukshetra '15.http://m.kurukshetra.org.in/#/Workshops/IBM's%20Security%20Intelligence%20with%20penetration%20Testing";
                    break;

            }

            intent2.setType("text/plain");
            intent2.putExtra(Intent.EXTRA_TEXT,text);
            startActivity(Intent.createChooser(intent2, "Shar" +
                    "e via"));
        }
        return super.onOptionsItemSelected(item);
    }

    public void floataction(View v) {
        switch (v.getId()) {
            case R.id.df_call:
                dial.setData(Uri.parse("tel:+919488528995"));
                startActivity(dial);
                break;
            case R.id.df_call1:
                dial.setData(Uri.parse("tel:+919894982823"));
                startActivity(dial);
                break;
            case R.id.df_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"digitalfreeze@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;


            case R.id.reck_call:
                dial.setData(Uri.parse("tel:+919894019498"));
                startActivity(dial);
                break;
            case R.id.reck_call1:
                dial.setData(Uri.parse("tel:+918508682349"));
                startActivity(dial);
                break;
            case R.id.reck_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"krackit@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;


            case R.id.pro_call:
                dial.setData(Uri.parse("tel:+919566206294"));
                startActivity(dial);
                break;
            case R.id.pro_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"protectionrelays@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;

            case R.id.ez_call:
                dial.setData(Uri.parse("tel:+917502540440"));
                startActivity(dial);
                break;
            case R.id.ez_call1:
                dial.setData(Uri.parse("tel: +919445265162"));
                startActivity(dial);
                break;
            case R.id.ez_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ezsystems@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;

            case R.id.iot_call:
                dial.setData(Uri.parse("tel:+919791010262"));
                startActivity(dial);
                break;
            case R.id.iot_call1:
                dial.setData(Uri.parse("tel:+918056243976"));
                startActivity(dial);
                break;
            case R.id.iot_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"iot@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;

            case R.id.bcr_call:
                dial.setData(Uri.parse("tel:+919500712476"));
                startActivity(dial);
                break;
            case R.id.bcr_call1:
                dial.setData(Uri.parse("tel:+919952988177"));
                startActivity(dial);
                break;
            case R.id.bcr_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"brainwave@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;

            case R.id.ros_call:
                dial.setData(Uri.parse("tel:+919894891862"));
                startActivity(dial);
                break;
            case R.id.ros_call1:
                dial.setData(Uri.parse("tel: +919790280170"));
                startActivity(dial);
                break;
            case R.id.ros_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"robotos@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_balakumaran_reverse_engg:
                dial.setData(Uri.parse("tel:+919444333660"));
                startActivity(dial);
                break;
            case R.id.fab_harish_reverse_engg:
                dial.setData(Uri.parse("tel: +917708238293"));
                startActivity(dial);
                break;
            case R.id.fb_mail_reverse_engg:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"re@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_followurpassion_sanjai:
                dial.setData(Uri.parse("tel:+918883662904"));
                startActivity(dial);
                break;
            case R.id.fab_suriya_followurpassion:
                dial.setData(Uri.parse("tel: +919629918998"));
                startActivity(dial);
                break;
            case R.id.fab_followurpassion_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"fyp@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_biomimicry_muthukumar:
                dial.setData(Uri.parse("tel:+919443013161"));
                startActivity(dial);
                break;
            case R.id.fab_biomimicry_bhargavi:
                dial.setData(Uri.parse("tel: +919600002676"));
                startActivity(dial);
                break;
            case R.id.fab_biomimicry_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"biomimicry@kurukshetra.org.in"});
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_ibmsipt_harishankar:
                dial.setData(Uri.parse("tel:+919715442929"));
                startActivity(dial);
                break;
            case R.id.fab_ibmsipt_jeganmuthaiah:
                dial.setData(Uri.parse("tel:+919976097015"));
                startActivity(dial);
                break;
        }
    }
}
