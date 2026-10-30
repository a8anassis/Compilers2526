package gr.aueb.compilers.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedyPattern {

    public static void main(String[] args) {
        String s = "alice;12345;bob;hello;";

//        Pattern pattern = Pattern.compile(".*;");   // greedy - longest match
        Pattern pattern = Pattern.compile(".*?;");   // Reluctant - non-greedy - as little as possible
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
