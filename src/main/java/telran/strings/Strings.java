package telran.strings;

public class Strings {
    public static String firstName() {
        //regex for stirngs starting with capital letter and rest as lowercase
        //minimal lengths is 5 letters  
        return "[A-Z][a-z]{4,}";
    }

    public static String javaVariable() {
        //TODO
        //regular expression for testing syntax of java variable names
        //only ASCII symbols are allowed 
        return "^[A-Za-z$_][A-Za-z0-9$_]*([A-Za-z0-9$]|[_]{1,})$";
    }
}
