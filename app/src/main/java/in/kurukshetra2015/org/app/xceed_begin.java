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


public class xceed_begin extends ActionBarActivity {

    private ListView listView1;

    String[] web = {
            "X-Code IIT(Kanpur)","Biz Quiz IIM(Bangalore)","Workshops KCT(Coimbatore)","Biz Quiz IIM(Kozhikode)"
    };

    Integer[] imageId = {
            R.drawable.iit_main,
            R.drawable.iim_bangalore,
            R.drawable.kct_main,
            R.drawable.iimkozhikode_main
    };
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xceed_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Xceed");

        listView1 = (ListView) findViewById(R.id.worklistView);
        CustomList adapter = new CustomList(xceed_begin.this, web, imageId);
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
            super(context, R.layout.xceed_single_list, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;
        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            final View rowView = inflater.inflate(R.layout.xceed_single_list, null, true);
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
                        contentIntent = new Intent(getContext(), xceed_xcode_content.class);
                            startActivity(contentIntent);
                        break;
                        case 1:
                            contentIntent = new Intent(getContext(), xceed_bizquiz_content.class);
                            startActivity(contentIntent);
                            break;
                        case 2:
                            contentIntent = new Intent(getContext(), xceed_kovai_javaclass.class);
                            startActivity(contentIntent);
                            break;
                        case 3:
                            contentIntent = new Intent(getContext(), xceed_kozhikode_bizquiz_content.class);
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
