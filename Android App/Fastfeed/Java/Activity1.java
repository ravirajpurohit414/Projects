package main.ravirajpurohit414.com.feedback;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.hsalf.smilerating.SmileRating;

public class Activity1 extends AppCompatActivity {

    LinearLayout Page1;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Page1 = (LinearLayout)findViewById(R.id.Page1);
        animationDrawable = (AnimationDrawable) Page1.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.start();

        SmileRating smileRating = (SmileRating) findViewById(R.id.smile_rating);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {

                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(Activity1.this, "BAD", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Activity1.this,Activity10.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(Activity1.this, "GOOD", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Activity1.this,Activity8.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(Activity1.this, "GREAT", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Activity1.this,Activity7.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(Activity1.this, "OKAY", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Activity1.this,Activity9.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(Activity1.this, "TERRIBLE", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Activity1.this,Activity11.class));
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                        break;
                }
            }
        });

    }
}