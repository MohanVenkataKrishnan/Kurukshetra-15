package in.kurukshetra2015.org.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by sabari on 23-12-2014.
 */
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.sword_anime);

       // ImageView k=(ImageView)findViewById(R.id.k);
        ImageView sword=(ImageView)findViewById(R.id.sword_img);

        sword.startAnimation(animation);

        Thread thread=new Thread(){
            @Override
            public void run() {
            try{sleep(1300);


            }catch (InterruptedException e)
            {
                e.printStackTrace();

            }
                finally {
                Intent openMain = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(openMain);
            }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
