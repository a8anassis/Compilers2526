package gr.aueb.compilers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Strong passwords with at least 12 characters
 * At least 1 Upper, 1 Lower, 1 digit, 1 Special char
 *
 * Zero-length assertions
 */
public class StrongPasswordApp {

    public static void main(String[] args) {
        String password = "C0mp1lers2026*&";

        Pattern pattern = Pattern.compile("(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[@#$%^&*])^.{12,}$");
        Matcher matcher = pattern.matcher(password);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
