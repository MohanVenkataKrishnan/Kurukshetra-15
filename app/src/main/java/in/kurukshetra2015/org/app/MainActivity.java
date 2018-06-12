package in.kurukshetra2015.org.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    EditText et;
    TextView tv;
    static boolean active = false;
    String tosend;
    String url;
    static String Vb;
    private DrawerLayout drawerLayoutt;
    private View listView;
    private ListView listView1;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private static KenBurnsView mHeaderPicture;
    private static int updatecount = 0;
    private static ArrayList update = new ArrayList();

    public static final String My_Pref = "Updatelist";
    SharedPreferences pref;
    protected pushnotify app;
    private String[] navigationDrawerItems;
    String[] web = {

            "Events",
            "Workshops",
            "Xceed",
            "Sponsors",
            "Guest Lectures",
            "Projects",
            "K!arnival",
            "Hospitality",
            "Tip of the day",
            "Updates",
            "Contacts",
            "About Us"

    };
    Integer[] imageId = {
            R.drawable.eventss,
            R.drawable.workshops,
            R.drawable.xceed,
            R.drawable.sponsors,
            R.drawable.guest_lectures,
            R.drawable.projects,
            R.drawable.karnival,
            R.drawable.hospitality,
            R.drawable.tip,
            R.drawable.updates,
            R.drawable.contact,
            R.drawable.info

    };

    private static HandleJSON obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Pushbots.init(this, "851023428270", "5496cfd21d0ab1d6328b4589");
        // Pushbots.getInstance().setMsgReceiver(pushnotifications.class);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        pref = getSharedPreferences(My_Pref, 0);

        app = (pushnotify) getApplication();

        update.clear();
        updatecount = pref.getInt("size", 0);

        for (int i = 0; i < updatecount; i++) {
            update.add(pref.getString("update" + i, ""));
        }


        drawerLayoutt = (DrawerLayout) findViewById(R.id.drawer_layout);


        listView = (View) findViewById(R.id.left_drawer);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    obj = new HandleJSON();

                } catch (Exception e) {

                } finally {
                    setdata();
                }
            }
        };
        t.start();


        listView = (View) findViewById(R.id.left_drawer);


        listView1 = (ListView) findViewById(R.id.left_list);
        CustomList adapter = new
                CustomList(MainActivity.this, web, imageId);


        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                switch (position) {
                    case 0:
                        Intent wo = new Intent(getBaseContext(), event_begin_trial.class);
                        startActivity(wo);

                        break;

                    case 1:
                        Intent t = new Intent(getBaseContext(), Workshop.class);
                        startActivity(t);

                        break;
                    case 2:
                        Intent xceedIntent = new Intent(getBaseContext(), xceed_begin.class);
                        startActivity(xceedIntent);
                        break;

                    case 3:
                        Intent t1 = new Intent(getBaseContext(), Sponsers.class);
                        startActivity(t1);

                        break;
                    case 4:
                        Intent p = new Intent(getBaseContext(), gl.class);
                        startActivity(p);


                        break;
                    case 5:
                        Intent t2 = new Intent(getBaseContext(), pro.class);
                        startActivity(t2);

                        break;
                    case 6:
                        Intent hos = new Intent(getBaseContext(), karnival.class);
                        startActivity(hos);

                        break;
                    case 7:
                        Intent t3 = new Intent(getBaseContext(), hospitality.class);
                        startActivity(t3);

                        break;
                    case 8:
                        Intent t4 = new Intent(getBaseContext(), tipoftheday.class);
                        startActivity(t4);

                        break;
                    case 9:
                        Intent t5 = new Intent(getBaseContext(), Updates.class);
                        startActivity(t5);

                        break;
                    case 10:
                        Intent t6 = new Intent(getBaseContext(), ContactActivity.class);
                        startActivity(t6);

                        break;
                    case 11:
                        Intent t7 = new Intent(getBaseContext(), AboutDev.class);
                        startActivity(t7);

                        break;

                }

            }
        });


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayoutt, toolbar, R.string.app_name, R.string.app_name);
        drawerLayoutt.setDrawerListener(actionBarDrawerToggle);

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        active = true;
    }

    @Override
    public void onStop() {
        super.onStop();
        active = false;
    }

    public static boolean isActive() {
        return active;
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
        Fragment fragment = new DummyFragment();
        Bundle args = new Bundle();
        args.putInt(DummyFragment.ARG_MENU_INDEX, position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // update selected item and title, then close the drawer
        listView1.setItemChecked(position, true);

        drawerLayoutt.closeDrawer(listView);
    }


    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }


    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        private final String[] web;
        private final Integer[] imageId;

        public CustomList(Activity context,
                          String[] web, Integer[] imageId) {
            super(context, R.layout.list_single, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.list_single, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
            txtTitle.setText(web[position]);
            imageView.setImageResource(imageId[position]);
            return rowView;
        }
    }

    public static CardView CardView1, CardView2;
    public static TextView tv1, tv2, jsont;
    public static Animation right_to_left_animation;
    public static Animation left_to_right_animation;
    public static Animation left_to_right_animation1;
    public static Animation right_to_left_animation1;
    public static Animation jsonanime;
    public static Animation jsonanime1;
    public static int i = 1, j = 1, k = 1, flag = 0;


    public static class DummyFragment extends Fragment {

       // @SuppressLint("ValidFragment")
        public static final String ARG_MENU_INDEX = "index";


        public DummyFragment() {
            // Empty constructor required for fragment subclasses

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.dummy_fragment, container, false);


            //dialogShow(rootView);


            int index = getArguments().getInt(ARG_MENU_INDEX);
            mHeaderPicture = (KenBurnsView) rootView.findViewById(R.id.header_picture);
            mHeaderPicture.setResourceIds(R.drawable.image2, R.drawable.image1,R.drawable.image3);

            tv1 = (TextView) rootView.findViewById(R.id.t1);

            tv2 = (TextView) rootView.findViewById(R.id.t2);

            jsont = (TextView) rootView.findViewById(R.id.jsontext);
            CardView1 = (CardView) rootView.findViewById(R.id.c1);
            CardView2 = (CardView) rootView.findViewById(R.id.c2);
            right_to_left_animation = AnimationUtils.loadAnimation(getActivity(), R.anim.right_to_left);
            left_to_right_animation = AnimationUtils.loadAnimation(getActivity(), R.anim.left_to_right);
            right_to_left_animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.right_to_left1);
            left_to_right_animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.left_to_right1);
           // jsont.setText("K! Workshops registrations are open");
            jsonanime = AnimationUtils.loadAnimation(getActivity(), R.anim.json_anime);
            jsonanime1 = AnimationUtils.loadAnimation(getActivity(), R.anim.json_anime);


            jsont.startAnimation(jsonanime);

            CardView1.startAnimation(right_to_left_animation);
            CardView2.startAnimation(left_to_right_animation1);

            jsonanime.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {


                    if (updatecount > 0)
                        jsont.setText(update.get(flag).toString());
                    else
                        jsont.setText("Welcome to kurukshetra 2015");
                    flag = flag + 1;

                    if (flag > updatecount - 1)
                        flag = 0;
                    jsont.startAnimation(jsonanime1);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {


                }
            });

            jsonanime1.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (updatecount > 0)
                        jsont.setText(update.get(flag).toString());
                    else
                        jsont.setText("Welcome to kurukshetra 2015");
                    flag = flag + 1;

                    if (flag > updatecount - 1)
                        flag = 0;
                    jsont.startAnimation(jsonanime);

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });


            left_to_right_animation1.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                    // TODO Auto-generated method stub
                    if (j > 3) {
                        j = 0;
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    // TODO Auto-generated method stub
                    switch (j) {
                        case 0:
                            tv2.setText("30+");

                            j = j + 1;
                            break;
                        case 1:
                            tv2.setText("4+");

                            j = j + 1;
                            break;
                        case 2:
                            tv2.setText("10+");

                            j = j + 1;
                            break;
                        case 3:
                            tv2.setText("1M");

                            j = j + 1;
                            break;
                    }
                    CardView2.startAnimation(right_to_left_animation1);

                }
            });
            right_to_left_animation1.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                    // TODO Auto-generated method stub
                    if (k > 3) {
                        k = 0;
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    // TODO Auto-generated method stub

                    CardView2.startAnimation(left_to_right_animation1);


                }
            });

            right_to_left_animation.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                    // TODO Auto-generated method stub
                    if (i > 3) {
                        i = 0;
                    }
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    // TODO Auto-generated method stub

                    switch (i) {
                        case 0:
                            tv1.setText("Events");
                            i = i + 1;
                            break;
                        case 1:
                            tv1.setText("Guest Lectures");
                            i = i + 1;
                            break;
                        case 2:
                            tv1.setText("Workshops");
                            i = i + 1;
                            break;
                        case 3:
                            tv1.setText("Prize Money");
                            i = i + 1;
                            break;
                    }

                    CardView1.startAnimation(left_to_right_animation);

                }
            });
            left_to_right_animation.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    // TODO Auto-generated method stub
                    CardView1.startAnimation(right_to_left_animation);

                }
            });


            rootView.findViewById(R.id.facebook_fb).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("https://www.facebook.com/kurukshetra.org.in?fref=ts");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });

            rootView.findViewById(R.id.twitter_fb).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("https://twitter.com/kurukshetra_ceg");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
            rootView.findViewById(R.id.instagram_fb).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("http://instagram.com/kurukshetra_ceg");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });


/*
            rootView.findViewById(R.id.robo_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, events_robotics_content.class);
                    contentIntent.putExtra("POSITION", 0);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.ros_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, events_online_content.class);
                    contentIntent.putExtra("POSITION", 5);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.god_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, events_engineering_content.class);
                    contentIntent.putExtra("POSITION", 3);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.open_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, events_quizzes_content.class);
                    contentIntent.putExtra("POSITION", 2);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.onsite_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, events_coding_content.class);
                    contentIntent.putExtra("POSITION", 0);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.alcatraz_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, events_general_content.class);
                    contentIntent.putExtra("POSITION", 0);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.cha_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, events_management_content.class);
                    contentIntent.putExtra("POSITION", 0);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.kiran_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this,gl.class);

                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.bio_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, WorkshopContent.class);
                    contentIntent.putExtra("POSITION", 8);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.digital_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, WorkshopContent.class);
                    contentIntent.putExtra("POSITION", 0);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.ez_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, WorkshopContent.class);
                    contentIntent.putExtra("POSITION",3);
                    startActivity(contentIntent);
                }
            });

            rootView.findViewById(R.id.robos_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, WorkshopContent.class);
                    contentIntent.putExtra("POSITION", 6);
                    startActivity(contentIntent);
                }
            });
            rootView.findViewById(R.id.laser_s).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent contentIntent = new Intent(MainActivity.this, karnival.class);
                    contentIntent.putExtra("POSITION", 7);
                    startActivity(contentIntent);
                }
            });



*/

            return rootView;
        }


    }


    public void setdata() {
        pref = getSharedPreferences(My_Pref, 0);
        SharedPreferences.Editor ed = pref.edit();
        if (obj.count > 0)
            ed.putInt("size", obj.count);
        for (int i = 0; i < obj.count; i++) {
            ed.putString("update" + i, obj.title[i]);
        }
        ed.commit();

    }


    @Override
    public void onBackPressed() {
        //Display alert message when back button has been pressed
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                MainActivity.this);


        alertDialog.setMessage("Are you sure you want to Exit?");

        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        dialog.cancel();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
    }



    public void dialogShow(final View v) {
        final Effectstype[] effect = {null};
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(this);


        Vb = "http://techteam.kurukshetra.org.in/subscribe.php?mail=";


        v.findViewById(R.id.gmail_fb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {


                effect[0] = Effectstype.RotateBottom;
                dialogBuilder
                        .withTitle("e-mail Updates")                                  //.withTitle(null)  no title
                        .withTitleColor("#000000")                                  //def
                        .withDividerColor("#ffffff")                              //def

                        .withMessageColor("#FF000000")                              //def  | withMessageColor(int resid)
                        .withDialogColor("#FFFFFFFF")                               //def  | withDialogColor(int resid)                               //def

                        .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                        .withDuration(350)                                          //def
                                                            //def Effectstype.Slidetop

                        .setCustomView(R.layout.custom_view2, v.getContext())                                      //def gone

                        .show();
                et = (EditText) dialogBuilder.findViewById(R.id.etRestg);
                dialogBuilder.findViewById(R.id.send_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isConnected()) {

                        } else {
                        }
                        Vb = "http://techteam.kurukshetra.org.in/subscribe.php?mail=";
                        String url = et.getText().toString();
                        tosend = Vb + url;
                        if (url == null) {

                        } else {
                            new HttpAsyncTask().execute(tosend);
                        }
                    }
                });
                dialogBuilder.findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.cancel();

                    }
                });


                et.setHint("Enter Mail id");
            }


        });
        v.findViewById(R.id.whatsapp_fb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {

                effect[0] = Effectstype.RotateBottom;
                dialogBuilder
                        .withTitle("WhatsApp Updates")                 //.withTitle(null)  no title


                        .withTitleColor("#000000")                                  //def
                        .withDividerColor("#11000000")                              //def

                        .withDialogColor("#FFFFFFFF")                               //def  | withDialogColor(int resid)                               //def

                        .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                        .withDuration(350)                                          //def
                                                            //def Effectstype.Slidetop
                        .setCustomView(R.layout.custom_view1, v.getContext())                                      //def gone
                        .show();
                et = (EditText) dialogBuilder.findViewById(R.id.etRestg);

                et.setHint("Please enter the Number");
                dialogBuilder.findViewById(R.id.send_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Vb = "http://techteam.kurukshetra.org.in/subscribe.php?number=";
                        String url = et.getText().toString();
                        tosend = Vb + url;
                        new HttpAsyncTask().execute(tosend);

                    }
                });
                dialogBuilder.findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.cancel();

                    }
                });

            }


        });


    }


    public static String GET(String url) {
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string

            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            if(result.length()>0)
            Toast.makeText(getBaseContext(),result, Toast.LENGTH_LONG).show();

            else
                Toast.makeText(getBaseContext(),"Network error", Toast.LENGTH_LONG).show();

        }


    }




   public void openthelayout(View v){

       switch(v.getId()){
           case R.id.robo_s:
               Intent contentIntent = new Intent(MainActivity.this, events_robotics_content.class);
               contentIntent.putExtra("POSITION", 0);
               startActivity(contentIntent);
               break;
           case R.id.ros_s:

               Intent contentIntent1 = new Intent(MainActivity.this, events_online_content.class);
               contentIntent1.putExtra("POSITION", 5);
               startActivity(contentIntent1);
               break;
           case R.id.god_s:
               Intent contentIntent2 = new Intent(MainActivity.this, events_engineering_content.class);
               contentIntent2.putExtra("POSITION", 3);
               startActivity(contentIntent2);
               break;
           case R.id.open_s:
               Intent contentIntent3 = new Intent(MainActivity.this, events_quizzes_content.class);
               contentIntent3.putExtra("POSITION", 2);
               startActivity(contentIntent3);
               break;
           case R.id.onsite_s:
               Intent contentIntent4 = new Intent(MainActivity.this, events_coding_content.class);
               contentIntent4.putExtra("POSITION", 0);
               startActivity(contentIntent4);
               break;
           case R.id.alcatraz_s:
               Intent contentIntent5 = new Intent(MainActivity.this, events_general_content.class);
               contentIntent5.putExtra("POSITION", 0);
               startActivity(contentIntent5);
               break;
           case R.id.cha_s:
               Intent contentIntent6 = new Intent(MainActivity.this, events_management_content.class);
               contentIntent6.putExtra("POSITION", 0);
               startActivity(contentIntent6);
               break;
           case R.id.kiran_s:
               Intent contentIntent7 = new Intent(MainActivity.this,gl.class);

               startActivity(contentIntent7);
               break;
           case R.id.bio_s:
               Intent contentIntent8 = new Intent(MainActivity.this, WorkshopContent.class);
               contentIntent8.putExtra("POSITION", 8);
               startActivity(contentIntent8);
               break;
           case R.id.digital_s:
               Intent contentIntent9 = new Intent(MainActivity.this, WorkshopContent.class);
               contentIntent9.putExtra("POSITION", 0);
               startActivity(contentIntent9);
               break;
           case R.id.ez_s:
               Intent contentIntent10 = new Intent(MainActivity.this, WorkshopContent.class);
               contentIntent10.putExtra("POSITION",3);
               startActivity(contentIntent10);
               break;
           case R.id.robos_s:
               Intent contentIntent11 = new Intent(MainActivity.this, WorkshopContent.class);
               contentIntent11.putExtra("POSITION", 6);
               startActivity(contentIntent11);
               break;
           case R.id.laser_s:
               Intent contentIntent12 = new Intent(MainActivity.this, karnival.class);
               contentIntent12.putExtra("POSITION", 7);
               startActivity(contentIntent12);
               break;

           case R.id.whatsapp_fb:
               Intent i1=new Intent(MainActivity.this,subnumber.class);
               startActivity(i1);
               break;
           case R.id.gmail_fb:
               Intent i2=new Intent(MainActivity.this,emailsub.class);
               startActivity(i2);
               break;
       }
   }




}