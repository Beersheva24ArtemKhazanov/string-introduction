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
            "_nameName01",
            "_nameName$",
            "name_$Name$",
        };
        for (String example : examplesTrue) {
            assertTrue(example.matches(javaVariable()));
        }

        String[] examplesFalse = {
            " nameName",
            "NameName",
            ":name",
            "01Name",
        };
        for (String example : examplesFalse) {
            assertFalse(example.matches(javaVariable()));
        }
    }
}
