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
import android.widget.Toast;


public class events_engineering_content extends ActionBarActivity {
    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    Intent i = new Intent(Intent.ACTION_VIEW);
    String url;
    private Toolbar toolbar;
    int position=0;


    String[] web = {
            "Circuit Craze","Contraptions","e-Zone","Godspeed","Paper Presentation",
            "TCS Innovate","BIM"


    };
    Integer[] imageId = {
            R.drawable.circuitcraze_main,
            R.drawable.contraption_main,
            R.drawable.ezone_main,
            R.drawable.godspeed_main,
            R.drawable.paperpresentation_main,
            R.drawable.innovate_main,
            R.drawable.bim_main

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
                        url = "http://m.kurukshetra.org.in/#/Events/Engineering/Circuit%20craze";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "http://m.kurukshetra.org.in/#/Events/Engineering/Contraptions";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url = "http://m.kurukshetra.org.in/#/Events/Engineering/e-Zone";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 3:
                        url = "http://m.kurukshetra.org.in/#/Events/Engineering/Godspeed";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 4:
                        url = "http://m.kurukshetra.org.in/#/Events/Engineering/Paper%20Presentation";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 5:
                        url = "http://m.kurukshetra.org.in/#/Events/Engineering/Innovate";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 6:
                        url = "http://m.kurukshetra.org.in/#/Events/Engineering/BIM";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                }

            }
        });

        getSupportActionBar().setTitle(web[position]);

        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_engineering_cc_fragment.newInstance(), events_engineering_cc_fragment.TAG).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_engineering_contraptions_fragment.newInstance(), events_engineering_contraptions_fragment.TAG).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_engineering_ezone_fragment.newInstance(), events_engineering_ezone_fragment.TAG).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_engineering_godspeed_fragment.newInstance(), events_engineering_godspeed_fragment.TAG).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_engineering_pp_fragment.newInstance(), events_engineering_pp_fragment.TAG).commit();
                break;
            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_engineering_innovate_fragment.newInstance(), events_engineering_innovate_fragment.TAG).commit();
                break;
            case 6:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_engineering_bim_fragment.newInstance(), events_engineering_bim_fragment.TAG).commit();
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
                    text="http://m.kurukshetra.org.in/#/Events/Engineering/Circuit%20craze";

                    break;
                case 1:
                    text="http://m.kurukshetra.org.in/#/Events/Engineering/Contraptions";
                    break;
                case 2:
                    text="http://m.kurukshetra.org.in/#/Events/Engineering/e-Zone";
                    break;
                case 3:
                    text="http://m.kurukshetra.org.in/#/Events/Engineering/Godspeed";
                    break;
                case 4:
                    text="http://m.kurukshetra.org.in/#/Events/Engineering/Paper%20Presentation";
                    break;
                case 5:
                    text="http://m.kurukshetra.org.in/#/Events/Engineering/Innovate";
                    break;
                default:
                    text="http://m.kurukshetra.org.in/#/Events/Engineering/BIM";
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

            case R.id.fab_engineering_tab_contraptions_contacts_Rahul_Prakash_J:
                dial.setData(Uri.parse("tel:+919443783564"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_contraptions_contacts_vimal_prakash:
                dial.setData(Uri.parse("tel:+919965365329"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_contraptions_contacts_sathiyaraj:
                dial.setData(Uri.parse("tel:+919940816866"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_contraptions_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "contraption@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_engineering_tab_bim_contacts_priya:
                dial.setData(Uri.parse("tel:+919940082177"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_bim_contacts_jaffer:
                dial.setData(Uri.parse("tel:+919940235638"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_bim_contacts_vignesh:
                dial.setData(Uri.parse("tel:+919944447059"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_bim_contacts_sai_mohit:
                dial.setData(Uri.parse("tel:+918015832603"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_bim_contacts_archana:
                dial.setData(Uri.parse("tel:+919003276213"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_bim_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "bim@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_engineering_tab_godspeed_contacts_rahulraj:
                dial.setData(Uri.parse("tel:+919677554445"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_godspeed_contacts_prabhu:
                dial.setData(Uri.parse("tel:+919578881591"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_godspeed_contacts_krishna_murali:
                dial.setData(Uri.parse("tel:+917200339939"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_godspeed_contacts_aswin:
                dial.setData(Uri.parse("tel:+917373204346"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_godspeed_contacts_vijayakumar:
                dial.setData(Uri.parse("tel:+919655434486"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_godspeed_contacts_bala_kumar:
                dial.setData(Uri.parse("tel:+918940534683"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_godspeed_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "godspeed@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_engineering_tab_innovate_contacts_bramya:
                dial.setData(Uri.parse("tel:+919488629304"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_innovate_contacts_sharmila:
                dial.setData(Uri.parse("tel:+919791078780"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_innovate_contacts_abishek:
                dial.setData(Uri.parse("tel:+919443621961"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_innovate_contacts_harita:
                dial.setData(Uri.parse("tel:+919487610557"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_innovate_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "innovate@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_engineering_tab_pp_contacts_alwish_ranjith:
                dial.setData(Uri.parse("tel:+918608678597"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_pp_contacts_pavithra_baskaran:
                dial.setData(Uri.parse("tel:+919788755186"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_pp_contacts_inbavel:
                dial.setData(Uri.parse("tel:+918015638681"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_pp_contacts_srikanth:
                dial.setData(Uri.parse("tel:+919488603970"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_pp_contacts_haritha:
                dial.setData(Uri.parse("tel:+919486924895"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_pp_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "paperpresentation@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_engineering_tab_ezone_contacts_anjali_annadurai:
                dial.setData(Uri.parse("tel:+919486985271"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_ezone_contacts_mohana_sundari:
                dial.setData(Uri.parse("tel:+919894549894"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_ezone_contacts_aishwarya_priyadharshini:
                dial.setData(Uri.parse("tel:+919500148971"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_ezone_contacts_priyadharshini:
                dial.setData(Uri.parse("tel:+919442484186"));
                startActivity(dial);
                break;
            case R.id.fab_engineering_tab_ezone_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "ezone@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_coding_tab_cc_contacts_syed:
                dial.setData(Uri.parse("tel:+917667419171"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_cc_contacts_yazhika:
                dial.setData(Uri.parse("tel:+918098076527"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_cc_contacts_priyanka:
                dial.setData(Uri.parse("tel:+918438246002"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_cc_contacts_ashwin:
                dial.setData(Uri.parse("tel:+919500984684"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_cc_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "circuitcraze@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;

        }
    }


}
