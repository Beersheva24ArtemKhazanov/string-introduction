package telran.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.strings.Strings.*;

import org.junit.jupiter.api.Test;

public class RegularExpressionsTest {
    
    @Test
    void javaVariableTest() {
        // TODO
        String[] examplesTrue = {
            "nameName",
            "$nameName",
            "_nameName",
            "_nameNam3e01",
            "_nameName$",
            "name_$Name$",
            "A",
            "__",
            "$"
        };
        for (String example : examplesTrue) {
            assertTrue(example.matches(javaVariable()));
        }

        String[] examplesFalse = {
            " nameName",
            ":name",
            "01Name ",
            "",
            "_",
            "1"
        };
        for (String example : examplesFalse) {
            assertFalse(example.matches(javaVariable()));
        }
    }

    @Test
    void number0_300TrueTest() {
        String regex = number0_300();
        assertTrue("0".matches(regex));
        assertTrue("3".matches(regex));
        assertTrue("300".matches(regex));
        assertTrue("250".matches(regex));
        assertTrue("25".matches(regex));
        assertTrue("12".matches(regex));
        assertTrue("299".matches(regex));
        assertTrue("199".matches(regex));
    }

    @Test
    void number0_300FalseTest() {
        String regex = number0_300();
        assertFalse("00".matches(regex));
        assertFalse("301".matches(regex));
        assertFalse("01".matches(regex));
        assertFalse("1(".matches(regex));
        assertFalse("1000".matches(regex));
        assertFalse(" 20".matches(regex));
        assertFalse("1001".matches(regex));
    }

    @Test
    void ipV4OctetTrueTest() {
        String regex = ipV4Octet();
        assertTrue("0".matches(regex));
        assertTrue("000".matches(regex));
        assertTrue("00".matches(regex));
        assertTrue("10".matches(regex));
        assertTrue("100".matches(regex));
        assertTrue("255".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("249".matches(regex));
        assertTrue("250".matches(regex));
    }
    @Test
    void ipV4OctetFalseTest() {
        String regex = ipV4Octet();
        assertFalse("0000".matches(regex));
        assertFalse("t".matches(regex));
        assertFalse("-1".matches(regex));
        assertFalse("1111".matches(regex));
        assertFalse("0001".matches(regex));
        assertFalse("256".matches(regex));
        assertFalse("*".matches(regex));
        assertFalse("1 ".matches(regex));
    }

    @Test
    void ipV4AddressTrueTest() {
        String regex = ipV4Address();
        assertTrue("0.0.0.0".matches(regex));
        assertTrue("255.255.255.255".matches(regex));
    }

    @Test
    void ipV4AddressFalseTest() {
        String regex = ipV4Address();
        assertFalse("0.0.0".matches(regex));
        assertFalse("0.0.0+0".matches(regex));
        assertFalse("0".matches(regex));
        assertFalse("0.-".matches(regex));
        assertFalse("0.0.0 0".matches(regex));
        assertFalse("0.0.0* 0".matches(regex));
    }

    @Test
    void stringWithJavaNamesTest() {
        String names = "123 1a _ abs int enum null lmn";
        String expected = "abs lmn";
        assertEquals(expected, stringWithJavaNames(names));
    }

    @Test
    void isArithmeticExpressionTrueTest() {
        assertTrue(isArithmeticExpression("56+32+(56*7)"));
        assertTrue(isArithmeticExpression("5+7"));
        assertTrue(isArithmeticExpression("(32+55)*8"));
        assertTrue(isArithmeticExpression("(78/5)+(23+56)+(24*35)*3"));
        assertTrue(isArithmeticExpression("3*2+8*4+8"));
        assertTrue(isArithmeticExpression("(((56+8)+9)+7)+(54*8)"));
    }

    @Test
    void isArithmeticExpressionFalseTest() {
        assertFalse(isArithmeticExpression("+"));
        assertFalse(isArithmeticExpression("5+"));
        assertFalse(isArithmeticExpression("32_"));
        assertFalse(isArithmeticExpression(" 56+78"));
        assertFalse(isArithmeticExpression("(56+8)+9)+7)+(54*8)"));
        assertFalse(isArithmeticExpression("()()()()()"));
        assertFalse(isArithmeticExpression("((()))"));
        assertFalse(isArithmeticExpression("56+8*"));
        assertFalse(isArithmeticExpression("56+8*)"));
    }
}
