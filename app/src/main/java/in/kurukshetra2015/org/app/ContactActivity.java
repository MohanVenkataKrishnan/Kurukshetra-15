package in.kurukshetra2015.org.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class ContactActivity extends ActionBarActivity implements View.OnClickListener{
    Intent intent = new Intent(Intent.ACTION_DIAL);
    Intent emailInt=new Intent(Intent.ACTION_SENDTO);

    private Toolbar toolbar;
    //String[] Emailto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Contacts");
        ImageButton ma1=(ImageButton) findViewById(R.id.mail1);
        ImageButton ma2=(ImageButton) findViewById(R.id.mail2);
        ImageButton ma3=(ImageButton) findViewById(R.id.mail3);
        ImageButton ma4=(ImageButton) findViewById(R.id.mail4);
        ImageButton ma5=(ImageButton) findViewById(R.id.mail5);
        ImageButton ma6=(ImageButton) findViewById(R.id.mail6);
        ImageButton ma7=(ImageButton) findViewById(R.id.mail7);
        ImageButton ma8=(ImageButton) findViewById(R.id.mail8);
        ImageButton ma9=(ImageButton) findViewById(R.id.mail9);
        ImageButton ma10=(ImageButton) findViewById(R.id.mail10);
        ImageButton ma11=(ImageButton) findViewById(R.id.mail11);
        ImageButton ma12=(ImageButton) findViewById(R.id.mail12);
        ImageButton ma13=(ImageButton) findViewById(R.id.mail13);
         ImageView qb1=(ImageView)findViewById(R.id.buttonsuha);

       // qb1.assignContactFromPhone("+91 81228 64265",true);
        ImageView qb2=(ImageView)findViewById(R.id.button3);
       // qb2.assignContactFromPhone("+91 72999 77332",true);
        ImageView qb3=(ImageView)findViewById(R.id.button);
       // qb3.assignContactFromPhone("+91 96888 64123",true);
        ImageView qb4=(ImageView)findViewById(R.id.button22);
   //     qb4.assignContactFromPhone("+91 75982 03019",true);
        ImageView qb5=(ImageView)findViewById(R.id.button32);
     //   qb5.assignContactFromPhone("+91 94875 52734",true);
        ImageView qb6=(ImageView)findViewById(R.id.button31);
  //      qb6.assignContactFromPhone("+91 97904 71029",true);
        ImageView  qb7=(ImageView)findViewById(R.id.button322);
        ImageView qb71=(ImageView)findViewById(R.id.button323);
 //       qb7.assignContactFromPhone("+91 98944 25441",true);
        ImageView   qb8=(ImageView)findViewById(R.id.button33);
 //       qb8.assignContactFromPhone("+91 89404 04914",true);
        ImageView   qb9=(ImageView)findViewById(R.id.button41);
 //       qb9.assignContactFromPhone("+91 94449 65407",true);
        ImageView  qb10=(ImageView)findViewById(R.id.button42);
  //      qb10.assignContactFromPhone("+91 99400 28323",true);
        ImageView  qb11=(ImageView)findViewById(R.id.button43);
        ImageView   qb44=(ImageView)findViewById(R.id.button44);
        ImageView    qb54=(ImageView)findViewById(R.id.button54);
  //      qb11.assignContactFromPhone("+91 95662 06294",true);
        ImageView qb12=(ImageView)findViewById(R.id.button51);
  //      qb12.assignContactFromPhone("+91 98412 21875",true);
        ImageView  qb13=(ImageView)findViewById(R.id.button52);
  //      qb13.assignContactFromPhone("+91 80560 98028",true);
        ImageView qb14=(ImageView)findViewById(R.id.button53);
  //      qb14.assignContactFromPhone("+91 88072 89032",true);
        ImageView  qb15=(ImageView)findViewById(R.id.button61);
  //      qb15.assignContactFromPhone("+91 96885 10059",true);
        ImageView qb16=(ImageView)findViewById(R.id.button71);
  //      qb16.assignContactFromPhone("+91 98401 81689",true);
        ImageView  qb17=(ImageView)findViewById(R.id.button72);
  ///      qb17.assignContactFromPhone("+91 97904 90202",true);
        ImageView  qb18=(ImageView)findViewById(R.id.button81);
  //      qb18.assignContactFromPhone("+91 90031 88936",true);
        ImageView  qb19=(ImageView)findViewById(R.id.button82);
 ///       qb19.assignContactFromPhone("+91 99403 82642",true);
        ImageView    qb20=(ImageView)findViewById(R.id.button91);
  //      qb20.assignContactFromPhone("+91 99524 70468",true);
        ImageView  qb21=(ImageView)findViewById(R.id.button92);
  //      qb21.assignContactFromPhone("+91 99524 70467",true);
        ImageView    qb22=(ImageView)findViewById(R.id.button93);
  //      qb22.assignContactFromPhone("+91 96290 70469",true);
        ImageView  qb23=(ImageView)findViewById(R.id.button111);
  //      qb23.assignContactFromPhone("+91 97879 50205",true);
        ImageView qb24=(ImageView)findViewById(R.id.button112);
  //      qb24.assignContactFromPhone("+91 77085 74343",true);
        ImageView qb25=(ImageView)findViewById(R.id.button121);
  //      qb25.assignContactFromPhone("+91 95009 12998",true);
        ImageView qb26=(ImageView)findViewById(R.id.button122);
   //     qb26.assignContactFromPhone("+91 99434 78633",true);
        ImageView  qb27=(ImageView)findViewById(R.id.button123);
  //      qb27.assignContactFromPhone("+91 99448 8230",true);
       ImageView   qb28=(ImageView)findViewById(R.id.button141);
  //      qb28.assignContactFromPhone("+91 97911 90892",true);
        ImageView  qb29=(ImageView)findViewById(R.id.button142);
  //      qb29.assignContactFromPhone("+91 88705 43354",true);
        ImageView    qb30=(ImageView)findViewById(R.id.button151);
  //      qb30.assignContactFromPhone("+91 98652 76660",true);
        ImageView qb31=(ImageView)findViewById(R.id.button152);
        ImageView qb124=(ImageView)findViewById(R.id.button124);
  //      qb31.assignContactFromPhone("+91 95008 43137",true);
        qb1.setOnClickListener(this);qb2.setOnClickListener(this);qb3.setOnClickListener(this);
        qb4.setOnClickListener(this);qb9.setOnClickListener(this);qb14.setOnClickListener(this);
        qb5.setOnClickListener(this);qb10.setOnClickListener(this);qb15.setOnClickListener(this);
        qb6.setOnClickListener(this);qb11.setOnClickListener(this);qb16.setOnClickListener(this);
        qb7.setOnClickListener(this);qb12.setOnClickListener(this);qb17.setOnClickListener(this);
        qb8.setOnClickListener(this);qb13.setOnClickListener(this);qb18.setOnClickListener(this);
        qb19.setOnClickListener(this);qb22.setOnClickListener(this);qb25.setOnClickListener(this);qb28.setOnClickListener(this);
        qb20.setOnClickListener(this);qb23.setOnClickListener(this);qb26.setOnClickListener(this);qb29.setOnClickListener(this);
        qb21.setOnClickListener(this);qb24.setOnClickListener(this);qb27.setOnClickListener(this);qb30.setOnClickListener(this);
        qb31.setOnClickListener(this);qb71.setOnClickListener(this);qb44.setOnClickListener(this);
        qb54.setOnClickListener(this);qb124.setOnClickListener(this);ma1.setOnClickListener(this);ma2.setOnClickListener(this);ma3.setOnClickListener(this);ma4.setOnClickListener(this);
        ma5.setOnClickListener(this);ma6.setOnClickListener(this);ma7.setOnClickListener(this);ma8.setOnClickListener(this);ma9.setOnClickListener(this);ma10.setOnClickListener(this);
        ma11.setOnClickListener(this);ma12.setOnClickListener(this);ma13.setOnClickListener(this);



    }



    @Override
    public void onClick(View ele) {
            switch (ele.getId())
            {

                case R.id.mail1:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"pr@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;
                case R.id.mail2:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"infodesk@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;
                case R.id.mail3:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"hospidesk@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;
                case R.id.mail4:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"workshop@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;
                case R.id.mail5:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"events@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;
                case R.id.mail6:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"xceed@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;
                case R.id.mail7:


                emailInt.setData(Uri.parse("mailto:"));
                emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"karnival@kurukshetra.org.in"});
                startActivity(emailInt);
                break;
                case R.id.mail8:


                emailInt.setData(Uri.parse("mailto:"));
                emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"guestlectures@kurukshetra.org.in"});
                startActivity(emailInt);
                break;
                case R.id.mail9:


                emailInt.setData(Uri.parse("mailto:"));
                emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"industryrelations@kurukshetra.org.in"});
                startActivity(emailInt);
                break;
                case R.id.mail10:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"media@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;
                case R.id.mail11:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"logistics@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;
                case R.id.mail12:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"kweb@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;
                case R.id.mail13:


                    emailInt.setData(Uri.parse("mailto:"));
                    emailInt.putExtra(Intent.EXTRA_EMAIL,new String[]{"tech@kurukshetra.org.in"});
                    startActivity(emailInt);
                    break;




                case R.id.button124:

                    intent.setData(Uri.parse("tel:+919944882303"));
                    startActivity(intent);
                    break;
                case R.id.buttonsuha:

                    intent.setData(Uri.parse("tel:+919176331318"));
                    startActivity(intent);
                    break;

                case R.id.button54:

                    intent.setData(Uri.parse("tel:+91 89397 26903"));
                    startActivity(intent);
                    break;

             /*   case R.id.button2:

                    intent.setData(Uri.parse("tel:+91 81228 64265"));
                    startActivity(intent);
                    break;*/
                case R.id.button3:

                    intent.setData(Uri.parse("tel:+91 72999 77332"));
                    startActivity(intent);
                    break;
                case R.id.button:

                    intent.setData(Uri.parse("tel:+91 96888 64123"));
                    startActivity(intent);
                    break;
                case R.id.button22:

                    intent.setData(Uri.parse("tel:+91 75982 03019"));
                    startActivity(intent);
                    break;
                case R.id.button32:

                    intent.setData(Uri.parse("tel:+91 94875 52734"));
                    startActivity(intent);
                    break;
                case R.id.button31:

                    intent.setData(Uri.parse("tel:+91 97904 71029"));
                    startActivity(intent);
                    break;
                case R.id.button322:

                    intent.setData(Uri.parse("tel:+91 98944 25441"));
                    startActivity(intent);
                    break;
                case R.id.button33:

                    intent.setData(Uri.parse("tel:+91 94452 27860"));
                    startActivity(intent);
                    break;
                case R.id.button41:

                    intent.setData(Uri.parse("tel:+919445227860"));
                    startActivity(intent);
                    break;
                case R.id.button42:

                    intent.setData(Uri.parse("tel:+91 99400 28323"));
                    startActivity(intent);
                    break;
                case R.id.button43:

                    intent.setData(Uri.parse("tel:+91 95662 06294"));
                    startActivity(intent);
                    break;
                case R.id.button51:

                    intent.setData(Uri.parse("tel:+91 98412 21875"));
                    startActivity(intent);
                    break;
                case R.id.button52:

                    intent.setData(Uri.parse("tel:+91 80560 98028"));
                    startActivity(intent);
                    break;
                case R.id.button53:

                    intent.setData(Uri.parse("tel:+91 88072 89032"));
                    startActivity(intent);
                    break;
                case R.id.button61:

                    intent.setData(Uri.parse("tel:+91 96885 10059"));
                    startActivity(intent);
                    break;
                case R.id.button71:

                    intent.setData(Uri.parse("tel:+91 98401 81689"));
                    startActivity(intent);
                    break;
                case R.id.button72:

                    intent.setData(Uri.parse("tel:+91 97904 90202"));
                    startActivity(intent);
                    break;
                case R.id.button81:

                    intent.setData(Uri.parse("tel:+91 90031 88936"));
                startActivity(intent);
                break;
                case R.id.button82:

                    intent.setData(Uri.parse("tel:+91 99403 82642"));
                    startActivity(intent);
                    break;
                case R.id.button91:

                    intent.setData(Uri.parse("tel:+91 99629 53177"));
                    startActivity(intent);
                    break;
                case R.id.button92:

                    intent.setData(Uri.parse("tel:+91 98845 31930"));
                    startActivity(intent);
                    break;
                case R.id.button93:

                    intent.setData(Uri.parse("tel:+91 90038 61942"));
                    startActivity(intent);
                    break;
                case R.id.button111:

                    intent.setData(Uri.parse("tel:+91 97879 50205"));
                    startActivity(intent);
                    break;
                case R.id.button112:

                    intent.setData(Uri.parse("tel:+91 77085 74343"));
                    startActivity(intent);
                    break;
                case R.id.button121:

                    intent.setData(Uri.parse("tel:+91 95009 12998"));
                    startActivity(intent);
                    break;
                case R.id.button122:

                    intent.setData(Uri.parse("tel:+91 99434 78633"));
                    startActivity(intent);
                    break;
                case R.id.button123:

                    intent.setData(Uri.parse("tel:+91 97919 73903"));
                    startActivity(intent);
                    break;
                case R.id.button141:

                    intent.setData(Uri.parse("tel:+91 97911 90892"));
                    startActivity(intent);
                    break;
                case R.id.button142:

                intent.setData(Uri.parse("tel:+91 88705 43354"));
                startActivity(intent);
                break;case R.id.button151:

                intent.setData(Uri.parse("tel:+91 98652 76660"));
                startActivity(intent);
                break;
                case R.id.button152:

                intent.setData(Uri.parse("tel:+91 95008 43137"));
                startActivity(intent);
                break;
                case R.id.button323:

                    intent.setData(Uri.parse("tel:+91 89404 04914"));
                    startActivity(intent);
                    break;
                case R.id.button44:

                    intent.setData(Uri.parse("tel:+91 96004 35002"));
                    startActivity(intent);
                    break;
            }


    }
}
