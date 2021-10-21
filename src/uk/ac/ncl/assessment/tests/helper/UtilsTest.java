package uk.ac.ncl.assessment.tests.helper;

import org.junit.Test;
import uk.ac.ncl.assessment.factory.module.Module;
import uk.ac.ncl.assessment.helper.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UtilsTest {
    @Test
    public void calculateAgeTest(){
        Calendar cal  = Calendar.getInstance();
        cal.set(1990, 1, 1);
        int age = Utils.calculateAge(cal.getTime());
        assertEquals(31, age);
    }
    @Test
    public void checkEnoughCreditTest() {
        List<Module> moduleList = new ArrayList<Module>();
        Module module = Module.getInstance("CSC8404", "Adv Programming in Java", 10);
        moduleList.add(module);
        boolean enoughCredit = Utils.checkEnoughCredit(moduleList, 10);
        assertTrue(enoughCredit);
    }
}
