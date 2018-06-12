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


public class events_general_content extends ActionBarActivity {
    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    Intent i = new Intent(Intent.ACTION_VIEW);
    String url;
    private Toolbar toolbar;
    int position=0;


    String[] web = {
           "Alcatraz","The Fourth Estate","Math Modelling"


    };
    Integer[] imageId = {
            R.drawable.alcatraz_main,
            R.drawable.tfe_main,
            R.drawable.mathmodelling_main

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
                        url = "http://m.kurukshetra.org.in/#/Events/General/Alcatraz";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "http://m.kurukshetra.org.in/#/Events/General/The%20fourth%20estate";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url = "http://m.kurukshetra.org.in/#/Events/General/Math%20modeling";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;

                }

            }
        });

        getSupportActionBar().setTitle(web[position]);

        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_general_alcatraz_fragment.newInstance(), events_general_alcatraz_fragment.TAG).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_general_tfe_fragment.newInstance(), events_general_tfe_fragment.TAG).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_general_mm_fragment.newInstance(), events_general_mm_fragment.TAG).commit();
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
                    text="http://m.kurukshetra.org.in/#/Events/General/Alcatraz";

                    break;
                case 1:
                    text="http://m.kurukshetra.org.in/#/Events/General/The%20fourth%20estate";
                    break;


                default:
                    text="http://m.kurukshetra.org.in/#/Events/General/Math%20modeling";
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
            case R.id.fab_general_alcatraz_lavalya_lala:

                dial.setData(Uri.parse("tel:+919655726999"));
                startActivity(dial);
                break;
            case R.id.fab_general_alcatraz_durga_devi:
                dial.setData(Uri.parse("tel:+919043984227"));
                startActivity(dial);
                break;
            case R.id.fab_general_alcatraz_parthiban:
                dial.setData(Uri.parse("tel:+919789887587"));
                startActivity(dial);
                break;
            case R.id.fab_general_alcatraz_ponni:
                dial.setData(Uri.parse("tel:+919487613215"));
                startActivity(dial);
                break;
            case R.id.fab_general_alcatraz_murugaiah:
                dial.setData(Uri.parse("tel:+919489560192"));
                startActivity(dial);
                break;
            case R.id.fab_general_alcatraz_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "alcatraz@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_general_tfe_aahir_giri:
                dial.setData(Uri.parse("tel:+919790740279"));
                startActivity(dial);
                break;
            case R.id.fab_general_tfe_vidya:
                dial.setData(Uri.parse("tel:+919840759858"));
                startActivity(dial);
                break;
            case R.id.fab_general_tfe_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "fourthestate@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_general_mm_amutha:
                dial.setData(Uri.parse("tel:+919750614694"));
                startActivity(dial);
                break;
            case R.id.fab_general_mm_dharani:
                dial.setData(Uri.parse("tel:+919994090182"));
                startActivity(dial);
                break;
            case R.id.fab_general_mm_kaviya_priya:
                dial.setData(Uri.parse("tel:+919790520060"));
                startActivity(dial);
                break;

        }
    }


}
