package in.kurukshetra2015.org.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by goku on 20-12-2014.
 */
public class Updates extends ActionBarActivity {


    private ListView listView1;
    private Toolbar toolbar;


    private static int updatecount = 0;
    private static ArrayList list = new ArrayList();

    public static final String My_Pref = "Updatelist";
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.clear();
        list.add("Plaese connect to the Internet");


        setContentView(R.layout.updates);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Updates");
        pref = getSharedPreferences(My_Pref, 0);

        updatecount = pref.getInt("size", 0);
        if (updatecount > 0)
            list.clear();

        for (int i = 0; i < updatecount; i++) {

            list.add(pref.getString("update" + i, ""));

        }



        listView1 = (ListView) findViewById(R.id.updateslistView);
        CustomList adapter = new
                CustomList(Updates.this, list);
        listView1.setAdapter(adapter);
    }


    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;


        private int lastPosition = -1;


        public CustomList(Activity context,
                          ArrayList arrayList) {
            super(context, R.layout.work_list, arrayList);
            this.context = context;


        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            final View rowView = inflater.inflate(R.layout.updates_list, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.jsontext);
            txtTitle.setText((CharSequence) list.get(position));
            Animation animation = AnimationUtils.loadAnimation(this.getContext(), (position > lastPosition) ? R.anim.pair_bottomleftin : R.anim.pair_toprightin);
            rowView.startAnimation(animation);
            lastPosition = position;


            return rowView;
        }
    }
}
