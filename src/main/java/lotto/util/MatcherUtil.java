package lotto.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtil {

    public static Pattern providePattern(String pattern){
        return Pattern.compile(pattern);
    }
    public static Matcher provideMatcher(Pattern pattern, String inputNumber){
        return pattern.matcher(inputNumber);
    }
}
