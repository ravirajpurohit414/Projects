package main.ravirajpurohit414.com.feedback;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.firebase.client.Firebase;

public class Activity6 extends AppCompatActivity {

    LinearLayout Page6;
    AnimationDrawable animationDrawable;

    private Firebase mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        Page6 = (LinearLayout)findViewById(R.id.Page6);
        animationDrawable = (AnimationDrawable) Page6.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.start();

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://feedback-17fa2.firebaseio.com/");

        Button btn_most_likely = (Button)findViewById(R.id.btn_most_likely);
        Button btn_maybe = (Button)findViewById(R.id.btn_maybe);
        Button btn_least_likely = (Button)findViewById(R.id.btn_least_likely);

        btn_most_likely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity6.this,Activity5.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

                Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                mRefChild.child("Suggest Sartaj to others").setValue("Most Likely");
            }
        });

        btn_maybe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity6.this,Activity5.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

                Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                mRefChild.child("Suggest Sartaj to others").setValue("Maybe");
            }
        });

        btn_least_likely.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity6.this,Activity5.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

                Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                mRefChild.child("Suggest Sartaj to others").setValue("Least Likely");
            }
        });


    }
}
