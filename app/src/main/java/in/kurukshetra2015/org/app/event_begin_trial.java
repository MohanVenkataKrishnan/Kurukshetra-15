package in.kurukshetra2015.org.app;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;




public class event_begin_trial extends ActionBarActivity {

    private ListView listView1;

    String[] web = {
            "Engineering","Robotics","Quizzes","Management","Coding","Online","General"
    };

    Integer[] imageId = {
            R.drawable.engineering_main,
            R.drawable.robotics_main,
            R.drawable.quiz_main,
            R.drawable.management_main1,
            R.drawable.coding_main,
            R.drawable.online_main,
            R.drawable.general_main


    };
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Events");

        listView1 = (ListView) findViewById(R.id.worklistView);
        CustomList adapter = new CustomList(event_begin_trial.this, web, imageId);
        listView1.setAdapter(adapter);


    }


    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        private final String[] web;
        private final Integer[] imageId;
        private Image d;
        private int lastPosition = -1;
        private int flag=0;
        final float scale = getResources().getDisplayMetrics().density;
        public CustomList(Activity context,String[] web, Integer[] imageId) {
            super(context, R.layout.events_single_list, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            final View rowView = inflater.inflate(R.layout.events_single_list, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.worktext);
            final ImageView imageView = (ImageView) rowView.findViewById(R.id.workimage);
            txtTitle.setText(web[position]);

            imageView.setImageResource(imageId[position]);
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,(int)(200*scale)));
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent;

                    switch (position) {
                        case 0:
                        contentIntent = new Intent(getContext(), events_engineering_javaclass.class);
                            startActivity(contentIntent);
                        break;
                        case 1:
                            contentIntent = new Intent(getContext(), events_robotics_javaclass.class);
                            startActivity(contentIntent);
                            break;
                        case 2:
                            contentIntent = new Intent(getContext(), events_quizzes_javaclass.class);
                            startActivity(contentIntent);
                            break;
                        case 3:
                            contentIntent = new Intent(getContext(), events_management_javaclass.class);
                            startActivity(contentIntent);
                            break;
                        case 4:
                            contentIntent = new Intent(getContext(), events_coding_javaclass.class);
                            startActivity(contentIntent);
                            break;
                        case 5:
                            contentIntent = new Intent(getContext(), events_online_javaclass.class);
                            startActivity(contentIntent);
                            break;
                        case 6:
                            contentIntent = new Intent(getContext(), events_general_javaclass.class);
                            startActivity(contentIntent);
                            break;

                    }



                }
            });

            if(flag++>5) {
                Animation animation = AnimationUtils.loadAnimation(this.getContext(), (position > lastPosition) ? R.anim.pair_bottomleftin : R.anim.pair_toprightin);
                rowView.startAnimation(animation);
                lastPosition = position;
            }



            return rowView;
        }
    }


}
