package main.ravirajpurohit414.com.feedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ActivityHome extends AppCompatActivity {

    EditText editTextMobNo;
    public static String mob_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextMobNo = (EditText)findViewById(R.id.editTextMobNo);

        Button buttonHome= (Button) findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editTextMobNo.getText().toString().length()<10 || editTextMobNo.getText().toString().length()>10){

                    Toast.makeText(ActivityHome.this, "Invalid number", Toast.LENGTH_SHORT).show();

                }
                else{
                    mob_no = editTextMobNo.getText().toString();
                    startActivity(new Intent(ActivityHome.this,Activity1.class));
                }
            }
        });

    }
}