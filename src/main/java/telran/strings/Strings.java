package telran.strings;

import java.util.Arrays;

public class Strings {
    static final String keyWords[] = { "abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while" };

    public static String firstName() {
        // regex for stirngs starting with capital letter and rest as lowercase
        // minimal lengths is 5 letters
        return "[A-Z][a-z]{4,}";
    }

    public static String javaVariable() {
        // TODO
        // regular expression for testing syntax of java variable names
        // only ASCII symbols are allowed
        return "[a-zA-Z$]|[a-zA-Z$_][\\w\\d$]+";
    }

    public static String number0_300() {
        return "[1-9]\\d?|[1-2]\\d{2}|300|0";
    }

    public static String ipV4Octet() {
        return "(\\d{1,2}|[0-1]\\d{2}|2([0-4]\\d|5[0-5]))";
    }

    public static String ipV4Address() {
        String octetExp = ipV4Octet();
        return String.format("%s(\\.%s){3}", octetExp, octetExp);
    }

    public static String stringWithJavaNames(String names) {
        String[] tokens = names.split("\\s+");
        int i = getJavaNameIndex(tokens, -1);
        String res = "";
        if (i >= 0) {
            res = tokens[i];
        }
        while ((i = getJavaNameIndex(tokens, i)) > 0) {
            res += " " + tokens[i];
        }

        return res;
    }

    private static int getJavaNameIndex(String[] tokens, int i) {
        i++;
        while (i < tokens.length && !isJavaName(tokens[i])) {
            i++;
        }
        return i < tokens.length ? i : -1;
    }

    private static boolean isJavaName(String string) {

        return string.matches(javaVariable()) && Arrays.binarySearch(keyWords, string) < 0;
    }

    public static boolean isArithmeticExpression(String expr) {
        // TODO
        // 1. brackets
        // right position of open / close bracket is matter of regex
        // matching between open and close bracket is matter of the method you are
        // supposed to write
        // based on a counter. If counter is negative - no matching;
        // if at ending up going through a string the counter doesn't equal 0 - no
        // matching
        // matching may be only in one case: at the ending up of going the counter will
        // be 0
        // Operator - regular expression for one out of 4 arithemetic operators [*/+-]
        // Operand may be either Java variable name or number (better any)
        return (isEqualBrackets(expr) && expr.matches("\\d*[\\+\\-\\*\\/]?\\(*\\d+(([\\+\\-\\*\\/][\\(\\d]+)+\\)*)+"));
    }

    private static boolean isEqualBrackets(String expr) {
        int openBracketCount = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                openBracketCount++;
            } else if (expr.charAt(i) == ')') {
                openBracketCount--;
            }
        }
        return openBracketCount == 0 ? true : false;
    }
}
