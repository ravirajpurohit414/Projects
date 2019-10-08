package main.ravirajpurohit414.com.feedback;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Activity13 extends AppCompatActivity {

    LinearLayout Page13;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_13);

        Page13 = (LinearLayout)findViewById(R.id.Page13);
        animationDrawable = (AnimationDrawable) Page13.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.start();

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {

                Intent i = new Intent().setClass(Activity13.this, ActivityHome.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        };

        handler.sendEmptyMessageDelayed(0, 3000);
    }
}
