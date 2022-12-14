package ca.umanitoba.personalhealthcare.objects;
import static org.junit.Assert.*;

import org.junit.Test;

import ca.umanitoba.personalhealthcare.objects.Symptom;

public class SymptomTest {

    @Test
    public void testCreation(){
        System.out.println("\nStarting Symptom object creation test");

        Symptom sym = new Symptom("Blurry vision", "Head");

        assertNotNull(sym);

        assertTrue("Symptom name should be Blurry vision", "Blurry vision".equals(sym.getSymptomName()) );
        assertTrue("BodyPart should be Head", "Head".equals(sym.getBodyPart()) );
        assertTrue("Symptom toString() should return its name", "Blurry vision".equals(sym.toString()) );


        System.out.println("Finished testCreation");
    }

    @Test
    public void testEquals(){
        System.out.println("\nStarting Symptom equals() test");

        Symptom sym1 = new Symptom("Blurry vision", "Head");
        Symptom sym2 = new Symptom("Blurry vision", "Legs");
        Symptom sym3 = new Symptom("Headache", "Head");

        // whitebox testing the equals() method because we know it should test the strings with ignoreCase()
        assertTrue("Checking if Blurry vision equals Blurry vision", sym1.equals(new Symptom("BlURry ViSiOn", "heAd")) );

        assertFalse("Both symptoms bodyParts are different, should not be equal", sym2.equals(sym1) );
        assertFalse("Both symptoms names are different, should not be equal", sym1.equals(sym3) );

        System.out.println("Finished testEquals");
    }

}
