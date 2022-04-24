package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.ResultsLogic;
import ca.umanitoba.personalhealthcare.business.ResultsLogicImp;
import ca.umanitoba.personalhealthcare.objects.Condition;

/**
 * This class is displaying the description
 * of the condition that the user might have
 * */
public class ResultsActivity extends AppCompatActivity {

    ResultsLogic thisLogic;     //Logic
    String conditionToShow;     //Name of the condition that will be shown
    Condition thisCondition;    //Condition object that will be shown

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        conditionToShow = b.getString("Name");
        thisLogic = new ResultsLogicImp(conditionToShow);
        setTitle(thisLogic.getCondition().getName());

        //The various text boxes on the page
        TextView nameText = (TextView) findViewById(R.id.textView9);
        TextView linkText = (TextView) findViewById(R.id.textView11);
        TextView descriptionText = (TextView) findViewById(R.id.textView10);
        TextView linkNameText = (TextView) findViewById(R.id.textView);

        //Set the text based on the Condition object coming from the persistence layer
        nameText.setText(thisLogic.getCondition().getName());
        linkText.setText(thisLogic.getCondition().getSourceLink());
        descriptionText.setText(thisLogic.getCondition().getDescription());
        linkNameText.setText(thisLogic.getCondition().getSourceName());

    }
}
