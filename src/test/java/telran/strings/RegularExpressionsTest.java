package telran.strings;

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
            "__"
        };
        for (String example : examplesTrue) {
            assertTrue(example.matches(javaVariable()));
        }

        String[] examplesFalse = {
            " nameName",
            ":name",
            "01Name ",
            "",
            "_"
        };
        for (String example : examplesFalse) {
            assertFalse(example.matches(javaVariable()));
        }
    }
}
