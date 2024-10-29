package lotto.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegexPattern {
    INTEGER_INPUT(Pattern.compile("^[0-9]*$"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern=pattern;
    }

    public boolean matches(String input){
        return pattern.matcher(input).find();
    }
}
