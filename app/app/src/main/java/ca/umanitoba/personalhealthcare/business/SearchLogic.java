package ca.umanitoba.personalhealthcare.business;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.Condition;
import ca.umanitoba.personalhealthcare.objects.Symptom;

public interface SearchLogic {

    /**
     * Get a list of common conditions
     * @return  String array
     */
    String[] getCommonConditions();

    /**
     * Get the Condition object to be shown on the results page,
     * based on the symptoms selected on the search page.
     * @return Condition
     */
    Condition getConditionResult(ArrayList<String> selectedItems, String bodyPart);

}
