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


public class events_coding_content extends ActionBarActivity {
    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    Intent i = new Intent(Intent.ACTION_VIEW);



    String url;
    private Toolbar toolbar;
    int position=0;


    String[] web = {
            "Onsite Programming Contest",
            "Microsoft's Tame the Code",
            "Onsite Debugging",
            "Heptathlon"


    };
    Integer[] imageId = {
            R.drawable.ospc_main,
            R.drawable.mtc_main,
            R.drawable.osdebug_main,
            R.drawable.heptathlon_main


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
                        url = "http://m.kurukshetra.org.in/#/Events/Coding/Onsite%20Programming%20Contest";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "http://m.kurukshetra.org.in/#/Events/Coding/Microsoft's%20Tame%20the%20Code";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url = "http://m.kurukshetra.org.in/#/Events/Coding/Onsite%20Debugging";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 3:
                        url = "http://m.kurukshetra.org.in/#/Events/Coding/Heptathlon";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                }

            }
        });

        getSupportActionBar().setTitle(web[position]);

        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_coding_opc_fragment.newInstance(), events_coding_opc_fragment.TAG).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_coding_mtc_fragment.newInstance(), events_coding_mtc_fragment.TAG).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_coding_od_fragment.newInstance(), events_coding_od_fragment.TAG).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_coding_heptathlon_fragment.newInstance(), events_coding_heptathlon_fragment.TAG).commit();
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
                    text="http://m.kurukshetra.org.in/#/Events/Coding/Onsite%20Programming%20Contest";

                    break;
                case 1:
                    text="http://m.kurukshetra.org.in/#/Events/Coding/Microsoft's%20Tame%20the%20Code";
                    break;
                case 2:
                    text="http://m.kurukshetra.org.in/#/Events/Coding/Onsite%20Debugging";
                    break;
                default:
                    text="http://m.kurukshetra.org.in/#/Events/Coding/Heptathlon";
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
            case R.id.fab_coding_tab_opc_contacts_mohan:

                dial.setData(Uri.parse("tel:+919445625768"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_opc_contacts_raghavan:
                dial.setData(Uri.parse("tel:+919940130204"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_opc_contacts_sundar:
                dial.setData(Uri.parse("tel:+918939678807"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_opc_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "ospc@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_coding_tab_mtc_contacts_sankar:
                dial.setData(Uri.parse("tel:+919842975789"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_mtc_contacts_sachin:
                dial.setData(Uri.parse("tel:+918675169101"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_mtc_contacts_sivakumar:
                dial.setData(Uri.parse("tel:+917845741516"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_mtc_contacts_surya_dev:
                dial.setData(Uri.parse("tel:+919489481729"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_mtc_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "tamethecode@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_coding_tab_ob_contacts_nandu:
                dial.setData(Uri.parse("tel:+919940381927"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_ob_contacts_pradeep:
                dial.setData(Uri.parse("tel:+917200420088"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_ob_contacts_dilip:
                dial.setData(Uri.parse("tel:+917845152198"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_ob_contacts_lokesh:
                dial.setData(Uri.parse("tel:+919944966067"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_ob_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "debugging@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_coding_heptathlon_hafeeza:
                dial.setData(Uri.parse("tel:+918489898916"));
                startActivity(dial);
                break;
            case R.id.fab_coding_heptathlon_rajasekar:
                dial.setData(Uri.parse("tel:+918056243976"));
                startActivity(dial);
                break;
            case R.id.fab_coding_heptathlon_sangeetha:
                dial.setData(Uri.parse("tel:+918903131245"));
                startActivity(dial);
                break;
            case R.id.fab_coding_heptathlon_shriya_sasank:
                dial.setData(Uri.parse("tel:+919790736022"));
                startActivity(dial);
                break;
            case R.id.fab_coding_heptathlon_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "heptathalon@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
        }
    }


}
