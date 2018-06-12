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


public class events_robotics_content extends ActionBarActivity  {
    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    Intent i = new Intent(Intent.ACTION_VIEW);
    String url;
    private Toolbar toolbar;
    int position=0;


    String[] web = {
           "Robowars","K!ronicles Of Mars","To the Ark","Hawker Bot"


    };
    Integer[] imageId = {
            R.drawable.robowars_main,
            R.drawable.komars_main,
            R.drawable.ttark_main,
            R.drawable.hawkerbot_main

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
                        url = "http://m.kurukshetra.org.in/#/Events/Robotics/RoboWars";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "http://m.kurukshetra.org.in/#/Events/Robotics/K!ronicles%20of%20Mars";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url = "http://m.kurukshetra.org.in/#/Events/Robotics/To%20the%20ArK!";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 3:
                        url = "http://m.kurukshetra.org.in/#/Events/Robotics/Hawker%20Bot";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                }

            }
        });

        getSupportActionBar().setTitle(web[position]);

        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_robotics_robowars_fragment.newInstance(), events_robotics_robowars_fragment.TAG).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_robotics_kom_fragment.newInstance(), events_robotics_kom_fragment.TAG).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_robotics_ttark_fragment.newInstance(), events_robotics_ttark_fragment.TAG).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_robotics_hb_fragment.newInstance(), events_robotics_hb_fragment.TAG).commit();
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
                    text="http://m.kurukshetra.org.in/#/Events/Robotics/RoboWars";

                    break;
                case 1:
                    text="http://m.kurukshetra.org.in/#/Events/Robotics/K!ronicles%20of%20Mars";
                    break;
                case 2:
                    text="http://m.kurukshetra.org.in/#/Events/Robotics/To%20the%20ArK!";
                    break;



                default:
                    text="http://m.kurukshetra.org.in/#/Events/Robotics/Hawker%20Bot";
                    break;


            }

            intent2.setType("text/plain");
            intent2.putExtra(Intent.EXTRA_TEXT,"Check out the "+web[position]+" event at 'Kurukshetra'15'. "+text);
            startActivity(Intent.createChooser(intent2, "Share via . . ."));
        }
        return super.onOptionsItemSelected(item);
    }



    public void Callthenumber(View v){
        switch (v.getId()){
            case R.id.fab_robotics_tab_robowars_contacts_muhammed_afras:

                dial.setData(Uri.parse("tel:+918973255998"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_robowars_contacts_shibi_chakravarthy:
                dial.setData(Uri.parse("tel:+918760717918"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_robowars_contacts_senthil_nathan:
                dial.setData(Uri.parse("tel:+919025698040"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_robowars_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "robowars@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_robotics_tab_kom_contacts_anusha:
                dial.setData(Uri.parse("tel:+918754404042"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_kom_contacts_divya_parameswari:
                dial.setData(Uri.parse("tel:+919042810954"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_kom_contacts_karthikeyan:
                dial.setData(Uri.parse("tel:+919445678463"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_kom_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "autorobotics@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_robotics_tab_ttark_contacts_vignesh_janarthanan:
                dial.setData(Uri.parse("tel:+919442823746"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_ttark_contacts_pethan_raj:
                dial.setData(Uri.parse("tel:+919952377423"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_ttark_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "manualrobotics@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_robotics_tab_hb_contacts_noor_abdul:
                dial.setData(Uri.parse("tel:+919894486815"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_hb_contacts_goushika_janani:
                dial.setData(Uri.parse("tel:+918754864403"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_hb_contacts_chandrabose:
                dial.setData(Uri.parse("tel:+918056916131"));
                startActivity(dial);
                break;
            case R.id.fab_robotics_tab_hb_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "semiautonomous@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;

        }
    }

    public void openpage(View link) {
        switch(link.getId()){
            case R.id.robowars_rules_tdp:
                url = "http://test1.kurukshetra.org.in/TDP_Wars.docx";
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.kom_spec_camera:
                url = "http://www.logitech.com/en-us/product/hd-webcam-c270";
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.ttark_ps_tdp:
                url = "http://test1.kurukshetra.org.in/Ark_TDP.docx";
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.hb_faq_link1:
                url = "http://www.rakeshmondal.info/IR-Infrared-Sensor-Interface-lcd-Arduino-uno";
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.hb_faq_link2:
                url = "http://arduino.cc/en/Tutorial/Ping?from=Tutorial.UltrasoundSensor";
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.hb_faq_link3:
                url = "http://arduino.cc/en/Tutorial/ADXL3xx";
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.hb_faq_link4:
                url = "http://spot.ksac.in/2013/10/03/apexpredator-ball-pick-place-bot/";
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.hb_faq_link5:
                url = "http://www.youtube.com/watch?v=2N2rfo7h23c";
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
        }

    }
}
