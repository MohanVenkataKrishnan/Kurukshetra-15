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


public class events_quizzes_content extends ActionBarActivity {
    Intent dial = new Intent(Intent.ACTION_DIAL);
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    Intent i = new Intent(Intent.ACTION_VIEW);
    String url;
    private Toolbar toolbar;
    int position=0;


    String[] web = {
           "Sci-Tech Quiz","School Quiz","K! Open Quiz","Biz Quiz"


    };
    Integer[] imageId = {
            R.drawable.scitechquiz_main,
            R.drawable.schoolquiz_main,
            R.drawable.quiz_quiz,
            R.drawable.bizquiz_main


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
                        url = "http://m.kurukshetra.org.in/#/Events/Quizzes/Sci-tech%20Quiz";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "http://m.kurukshetra.org.in/#/Events/Quizzes/School%20Quiz";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url = "http://m.kurukshetra.org.in/#/Events/Quizzes/K!%20Open%20Quiz";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 3:
                        url = "http://m.kurukshetra.org.in/#/Events/Quizzes/Biz%20Quiz";
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                }

            }
        });

        getSupportActionBar().setTitle(web[position]);

        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_quizzes_stq_fragment.newInstance(), events_quizzes_stq_fragment.TAG).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_quizzes_sq_fragment.newInstance(), events_quizzes_sq_fragment.TAG).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_quizzes_koq_fragment.newInstance(), events_quizzes_koq_fragment.TAG).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.workshop_tab, events_quizzes_bizquiz_fragment.newInstance(), events_quizzes_bizquiz_fragment.TAG).commit();
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
                    text="http://m.kurukshetra.org.in/#/Events/Quizzes/Sci-tech%20Quiz";

                    break;
                case 1:
                    text="http://m.kurukshetra.org.in/#/Events/Quizzes/School%20Quiz";
                    break;
                case 2:
                    text="http://m.kurukshetra.org.in/#/Events/Quizzes/K!%20Open%20Quiz";
                    break;



                default:
                    text="http://m.kurukshetra.org.in/#/Events/Quizzes/Biz%20Quiz";
                    break;


            }

            intent2.setType("text/plain");
            intent2.putExtra(Intent.EXTRA_TEXT,"Check out the "+web[position]+" event at Kurukshetra'15.  "+text);
            startActivity(Intent.createChooser(intent2, "Share via . . ."));
        }
        return super.onOptionsItemSelected(item);
    }

    public void Callthenumber(View v){
        switch (v.getId()){
            case R.id.fab_quizzes_tab_koq_contacts_sainath:

                dial.setData(Uri.parse("tel:+919940569372"));
                startActivity(dial);
                break;
            case R.id.fab_coding_tab_bq_contacts_sainath:

                dial.setData(Uri.parse("tel:+919940569372"));
                startActivity(dial);
                break;
            case R.id.fab_quizzes_tab_stq_contacts_sainath:

                dial.setData(Uri.parse("tel:+919940569372"));
                startActivity(dial);
                break;
            case R.id.fab_quizzes_tab_koq_contacts_sriram_sundaram:
                dial.setData(Uri.parse("tel:+919445348709"));
                startActivity(dial);
                break;
            case R.id.fab_quizzes_tab_bq_contacts_sriram_sundaram:
                dial.setData(Uri.parse("tel:+919445348709"));
                startActivity(dial);
                break;
            case R.id.fab_quizzes_tab_stq_contacts_sriram_sundaram:
                dial.setData(Uri.parse("tel:+919445348709"));
                startActivity(dial);
                break;

            case R.id.fab_quizzes_tab_koq_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "openquiz@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_quizzes_tab_bq_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "bizquiz@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_quizzes_tab_stq_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "scitechquiz@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;
            case R.id.fab_quizzes_tab_schoolq_contacts_raja:
                dial.setData(Uri.parse("tel:+919629314522"));
                startActivity(dial);
                break;
            case R.id.fab_quizzes_tab_schoolq_contacts_reuben_mathew:
                dial.setData(Uri.parse("tel:+919789113731"));
                startActivity(dial);
                break;
            case R.id.fab_quizzes_tab_schoolq_contacts_tharunya:
                dial.setData(Uri.parse("tel:++919940497559"));
                startActivity(dial);
                break;
            case R.id.fab_quizzes_tab_schoolq_contacts_mail:
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "schoolquiz@kurukshetra.org.in" });
                startActivity(Intent.createChooser(emailIntent, "Send mail ..."));
                break;

        }
    }


}
