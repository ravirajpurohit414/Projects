package main.ravirajpurohit414.com.feedback;

        import android.content.Intent;
        import android.graphics.drawable.AnimationDrawable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.Toast;

        import com.firebase.client.Firebase;

public class Activity12 extends AppCompatActivity {

    LinearLayout Page12;
    AnimationDrawable animationDrawable;

    private Firebase mRef;
    CheckBox checkBox,checkBox2,checkBox3,checkBox4;
    EditText editText;

    String string = "Response Submitted";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_12);


        Page12 = (LinearLayout)findViewById(R.id.Page12);
        Toast toast= Toast.makeText(getApplicationContext(),string,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
        animationDrawable = (AnimationDrawable) Page12.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.start();

        //  Firebase
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://feedback-17fa2.firebaseio.com/");

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        editText = findViewById(R.id.editText);




        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                    String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                    mRefChild.child("Improve Id 1").setValue("Cleanliness");
                }
                else{

                }
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox2.isChecked()){
                    Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                    String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                    mRefChild.child("Improve Id 2").setValue("Staff Interaction");
                }
                else{

                }
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox3.isChecked()){
                    Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                    String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                    mRefChild.child("Improve Id 3").setValue("Dealing Time");
                }
                else{

                }
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox4.isChecked()){
                    Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                    String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                    mRefChild.child("Nothing to improve").setValue("All Good");
                }
                else{
                }
            }
        });



        Button buttonSubmit12 = (Button)findViewById(R.id.buttonSubmit12);
        buttonSubmit12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Activity12.this,Activity6.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);


                String other_sugg = editText.getText().toString();

                Firebase mRefChild = mRef.child(ActivityHome.mob_no);
                String id = mRefChild.child(ActivityHome.mob_no).push().getKey();
                mRefChild.child("Suggestion").setValue(other_sugg);

            }
        });

    }
}
