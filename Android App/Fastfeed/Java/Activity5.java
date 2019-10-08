package main.ravirajpurohit414.com.feedback;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.firebase.client.Firebase;

public class Activity5 extends AppCompatActivity {

    LinearLayout Page5;
    AnimationDrawable animationDrawable;

    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        Page5 = (LinearLayout)findViewById(R.id.Page5);
        animationDrawable = (AnimationDrawable) Page5.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.start();

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://feedback-17fa2.firebaseio.com/");


        Button btn_skip = (Button)findViewById(R.id.btn_skip);
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity5.this,Activity13.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });

        final RatingBar star_rating = (RatingBar)findViewById(R.id.star_rating);

        star_rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                startActivity(new Intent(Activity5.this,Activity13.class));

                Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                mRefChild.child("Star Rating for App").setValue(star_rating.getRating());
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });


    }
}
