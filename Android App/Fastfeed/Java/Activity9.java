package main.ravirajpurohit414.com.feedback;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.firebase.client.Firebase;

public class Activity9 extends AppCompatActivity {

    LinearLayout Page9;
    AnimationDrawable animationDrawable;

    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);

        Page9 = (LinearLayout)findViewById(R.id.Page9);
        animationDrawable = (AnimationDrawable) Page9.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.start();

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://feedback-17fa2.firebaseio.com/");



        Button buttonSubmit9 = (Button)findViewById(R.id.buttonSubmit9);
        buttonSubmit9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity9.this,Activity12.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

                Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                mRefChild.child("experience").setValue("Okay");
            }
        });
    }
}
