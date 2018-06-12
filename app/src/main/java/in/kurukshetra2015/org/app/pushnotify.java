package in.kurukshetra2015.org.app;

import android.app.Application;

import com.pushbots.push.Pushbots;

/**
 * Created by sabari on 23-12-2014.
 */
public class pushnotify extends Application {
    @Override
    public void onCreate(){

        super.onCreate();
        Pushbots.init(this,"851023428270","5496cfd21d0ab1d6328b4589");

        Pushbots.getInstance().setMsgReceiver(opennotify.class);
    }

}
