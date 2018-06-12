package in.kurukshetra2015.org.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class gl extends ActionBarActivity {
    CardView ll1,ll2,l13,l14,l15;
    private Toolbar toolbar;
    TextView tv1,tv2,tv3,tv4,tv5;
    TextView tv1_2;
    int i1=1,i2=1,i3=1,i4=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glx);
        ll1=(CardView)findViewById(R.id.card_view1);
        ll2=(CardView)findViewById(R.id.card_view2);
        l13=(CardView)findViewById(R.id.card_view3);
        l14=(CardView)findViewById(R.id.card_view4);
        l15=(CardView)findViewById(R.id.card_view5);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        tv5=(TextView)findViewById(R.id.tv5);

        tv1_2=(TextView)findViewById(R.id.tv1_2);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Guest Lectures");

        ll1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                if(tv1.getVisibility()==View.GONE && tv1_2.getVisibility()==View.GONE)
{
    tv1.setVisibility(View.VISIBLE);
    tv1_2.setVisibility(View.VISIBLE);

}else{

    tv1.setVisibility(View.GONE);
                    tv1_2.setVisibility(View.GONE);
}

                tv5.setVisibility(View.GONE);
                tv2.setVisibility(View.GONE);
                tv3.setVisibility(View.GONE);
                tv4.setVisibility(View.GONE);
            }

        });
        ll2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                if(tv2.getVisibility()==View.GONE)
                {
                    tv2.setVisibility(View.VISIBLE);

                }else{

                    tv2.setVisibility(View.GONE);
                }

                    tv1.setVisibility(View.GONE);
                tv1_2.setVisibility(View.GONE);

                    tv3.setVisibility(View.GONE);
                    tv4.setVisibility(View.GONE);
                tv5.setVisibility(View.GONE);




            }
        });
        l13.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {


                if(tv3.getVisibility()==View.GONE)
                {
                    tv3.setVisibility(View.VISIBLE);

                }else{

                    tv3.setVisibility(View.GONE);
                }

                tv1.setVisibility(View.GONE);
                tv1_2.setVisibility(View.GONE);

                tv2.setVisibility(View.GONE);
                tv4.setVisibility(View.GONE);
                tv5.setVisibility(View.GONE);
            }
        });
        l14.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                if(tv4.getVisibility()==View.GONE)
                {
                    tv4.setVisibility(View.VISIBLE);

                }else{

                    tv4.setVisibility(View.GONE);
                }

                    tv3.setVisibility(View.GONE);
                    tv2.setVisibility(View.GONE);
                    tv1.setVisibility(View.GONE);
                tv1_2.setVisibility(View.GONE);

                tv5.setVisibility(View.GONE);
              }
        });
        l15.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                if(tv5.getVisibility()==View.GONE)
                {
                    tv5.setVisibility(View.VISIBLE);

                }else{

                    tv5.setVisibility(View.GONE);
                }

                tv3.setVisibility(View.GONE);
                tv2.setVisibility(View.GONE);

                tv1.setVisibility(View.GONE);
                tv1_2.setVisibility(View.GONE);

                tv4.setVisibility(View.GONE);

            }
        });

    }



}
