package ca.umanitoba.personalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bodyPartsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);
    }

    public void clickHead(View v){
        Intent i = new Intent(this, Head_Activity.class);
        startActivity(i);
    }

    public void clickStomach(View v){
        Intent i = new Intent(this, Stomach_Activity.class);
        startActivity(i);
    }

}