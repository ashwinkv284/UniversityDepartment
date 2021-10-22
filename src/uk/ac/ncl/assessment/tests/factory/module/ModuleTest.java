package uk.ac.ncl.assessment.tests.factory.module;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.assessment.factory.module.Module;

import java.util.Random;

import static org.junit.Assert.*;

public class ModuleTest {
    Module module;
    int code;
    @Before
    public void setUp() throws Exception{
        Random rd = new Random();
        code = rd.nextInt(10000);
        module = Module.getInstance(String.valueOf(code), "Adv Programming in Java", 10);
    }

    @Test
    public void getInstance() {
        assertNotNull(module);
    }

    @Test
    public void getCode() {
        assertEquals(String.valueOf(code), module.getCode());
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
        assertEquals(String.valueOf(code) + ",Adv Programming in Java,10", module.toString());
    }

    @Test
    public void equalsTest() throws Exception {
        Module mod1 = Module.getInstance("CSC8709", "MBSE", 10);
        assertNotEquals(module, mod1);
    }

    @Test
    public void hashCodeTest() throws Exception {
        Module mod1 = Module.getInstance("CSC8710", "MBSE", 10);
        assertNotEquals(module.hashCode(), mod1.hashCode());
    }

    @Test
    public void moduleAlreadyExistsTest() {
        try {
            Module.getInstance(String.valueOf(code), "Adv Programming in Java", 10);
        } catch(Exception e) {
            assertEquals("Module already exists", e.getMessage());
        }
    }
}