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


public class events_general_javaclass extends ActionBarActivity {

    private ListView listView1;

    String[] web = {
            "Alcatraz","The Fourth Estate","Math Modelling"


    };
    Integer[] imageId = {
            R.drawable.alcatraz_main,
            R.drawable.tfe_main,
            R.drawable.mathmodelling_main

    };
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.events_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("General");

        Bundle r=getIntent().getExtras();
        if(r!=null)
        {
            int position=r.getInt("POSITION");
        }


        listView1 = (ListView) findViewById(R.id.worklistView);
        CustomList adapter = new CustomList(events_general_javaclass.this, web, imageId);
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
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,(int)(200*scale)));
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent=new Intent(getContext(),events_general_content.class);
                    contentIntent.putExtra("POSITION",position);
                    startActivity(contentIntent);
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
