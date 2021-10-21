package uk.ac.ncl.assessment.tests.factory.module;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.module.Module;

import static org.junit.Assert.*;

public class ModuleTest {
    Module module;
    @Before
    public void setUp() {
        module = Module.getInstance("CSC8404", "Adv Programming in Java", 10);
    }

    @Test
    public void getInstance() {
        assertNotNull(module);
    }

    @Test
    public void getCode() {
        assertEquals("CSC8404", module.getCode());
    }

    @Test
    public void getName() {
        assertEquals("Adv Programming in Java", module.getName());
    }

    @Test
    public void getCredits() {
        assertEquals(10, module.getCredits());
    }

    @Test
    public void toStringTest() {
        assertEquals("CSC8404,Adv Programming in Java,10", module.toString());
    }

    @Test
    public void equalsTest() {
        Module mod1 = Module.getInstance("CSC8701", "MBSE", 10);
        assertNotEquals(module, mod1);
    }

    @Test
    public void hashCodeTest() {
        Module mod1 = Module.getInstance("CSC8702", "MBSE", 10);
        assertNotEquals(module.hashCode(), mod1.hashCode());
    }
}