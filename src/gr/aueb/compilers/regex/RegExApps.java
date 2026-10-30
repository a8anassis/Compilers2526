package gr.aueb.compilers.regex;

/**
 * Παραδείγματα Regular Expressions.
 */
public class RegExApps {

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(isHello(s));
        String s2 = "hcoding";
        String s3 = "*hello";
        System.out.println(startsWithUpperCaseEndingWithCoding(s2));
        System.out.println(startsWithLetterEndingWithHello(s3));

    }

    public static boolean isHello(String s) {
        return s.matches("Hello");
    }

    public static boolean isHelloOrHi(String s) {
        return s.matches("Hello|Hi");
    }

    public static boolean startsWithUpperCaseEndingWithCoding(String s) {
        return s.matches("[A-Z]coding");
    }

    public static boolean startsWithLetterEndingWithHello(String s) {
        return s.matches("[A-Za-z0-9_]hello");
    }

    public static boolean startsAnyAndDigit(String s) {
        return s.matches(".\\d");
    }

    public static boolean startsDotAndLetter(String s) {
        return s.matches("\\.\\d");
    }

    // Date Format dd/mm/yyyy
    public static boolean isDate(String s) {
        return s.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean anyCharOneOrMore(String s) {
        return  s.matches(".+");
    }

    public static boolean anyCharZeroOrMore(String s) {
        return  s.matches(".*");
    }

    // Δύο ακολουθίες χαρακτήρων που διαχωρίζονται με ένα ή περισσότερα κενά
    // "Hello   World"
    public static  boolean twoWordsSepByOneOrMoreSpaces(String s) {
        return s.matches(".+\\s+.+");
    }

    // Groups for backreference
    public static String reverse(String s) {
        return s.replaceAll("(.+)\\s+(.+)", "$2 $1");
    }



}
