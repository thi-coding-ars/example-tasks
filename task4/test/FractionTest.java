import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FractionTest extends EasyAssert {
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    protected String getOutput() {
        return testOut.toString();
    }

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void testStructure() throws SecurityException, ClassNotFoundException {
        Class<?> loadClass = null;
        try {
            loadClass = FractionTest.class.getClassLoader().loadClass("Fraction");
        } catch (ClassNotFoundException exc) {
            fail("Fraction Klasse muss definiert sein, stimmt die Schreibweise?");
        }
        assertTrue("Fraction Klasse muss definiert sein", loadClass != null);
        try {
            assertTrue("Das Attribut 'numerator' soll vom Typ 'int' sein",
                    loadClass.getDeclaredField("numerator").getType().equals(int.class));
        } catch (NoSuchFieldException e) {
            fail("Fraction Klasse soll ein Attribut 'numerator' haben");
        }
        try {
            assertTrue("Das Attribut 'denominator' soll vom Typ 'int' sein",
                    loadClass.getDeclaredField("numerator").getType().equals(int.class));
        } catch (NoSuchFieldException e) {
            fail("Fraction Klasse soll ein Attribut 'denominator' haben");
        }
        try {
            Method declaredMethod = loadClass.getDeclaredMethod("setNumerator", int.class);
            assertTrue(
                    "Fraction Klasse soll eine Methode 'setNumerator' haben, die einen Parameter vom Typ int erhält",
                    declaredMethod != null);
            assertTrue("Der Rückgabetyp von setNumerator soll void sein",
                    declaredMethod.getReturnType().equals(void.class));
        } catch (NoSuchMethodException e) {
            fail("Fraction Klasse soll eine Methode 'setNumerator' haben, die einen Parameter vom Typ int erhält");
        }
        try {
            Method declaredMethod = loadClass.getDeclaredMethod("setDenominator", int.class);
            assertTrue(
                    "Fraction Klasse soll eine Methode 'setDenominator' haben, die einen Parameter vom Typ int erhält",
                    declaredMethod != null);
            assertTrue("Der Rückgabetyp von setDenominator soll void sein",
                    declaredMethod.getReturnType().equals(void.class));
        } catch (NoSuchMethodException e) {
            fail("Fraction Klasse soll eine Methode 'setDenominator' haben, die einen Parameter vom Typ int erhält");
        }
        try {
            Method declaredMethod = loadClass.getDeclaredMethod("print");
            assertTrue("Fraction Klasse soll eine Methode 'print' haben, die keinen Parameter hat",
                    declaredMethod != null);
            assertTrue("Der Rückgabetyp von print soll void sein",
                    declaredMethod.getReturnType().equals(void.class));
        } catch (NoSuchMethodException e) {
            fail("Fraction Klasse soll eine Methode 'print' haben, die keinen Parameter hat");
        }
    }

    @Test
    public void testPrint00() {
        Class<?> loadClass = null;
        try {
            loadClass = FractionTest.class.getClassLoader().loadClass("Fraction");
            Object f = loadClass.newInstance();
            loadClass.getDeclaredMethod("setNumerator", int.class).invoke(f, 1);
            loadClass.getDeclaredMethod("setDenominator", int.class).invoke(f, 2);
            loadClass.getDeclaredMethod("print").invoke(f);

            String output = getOutput().trim();
            String expected = "1/2";
            assertEquals("Prüfe print mit Numerator 1 und Denominator 2", expected, output);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException exc) {
            fail("Deine Klassendefinition stimmt noch nicht!");
        }
    }

    @Test
    public void testPrint01() {
        Class<?> loadClass = null;
        try {
            loadClass = FractionTest.class.getClassLoader().loadClass("Fraction");
            Object f = loadClass.newInstance();
            loadClass.getDeclaredMethod("setNumerator", int.class).invoke(f, 0);
            loadClass.getDeclaredMethod("setDenominator", int.class).invoke(f, 200);
            loadClass.getDeclaredMethod("print").invoke(f);

            String output = getOutput().trim();
            String expected = "0/200";
            assertEquals("Prüfe print mit Numerator 1 und Denominator 2", expected, output);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException exc) {
            fail("Deine Klassendefinition stimmt noch nicht!");
        }
    }

}