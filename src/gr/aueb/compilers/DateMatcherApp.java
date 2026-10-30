package gr.aueb.compilers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Μετατρέπει ημερομηνίες από mm/dd/yyyy
 * σε dd/mm/yyyy
 */
public class DateMatcherApp {

    public static void main(String[] args) {
        String s = "10/23/2026 01/12/2026";

        Pattern pattern = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());    // the whole match

            String month  = matcher.group(1);
            String day = matcher.group(2);
            String year = matcher.group(3);

            String grFormat = day + "/" + month + "/" + year;
            System.out.println(grFormat);
            System.out.println();
        }
    }
}
