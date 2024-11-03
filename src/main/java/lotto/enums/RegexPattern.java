package lotto.enums;

import java.util.regex.Pattern;

public enum RegexPattern {

    START_WITH_ZERO(Pattern.compile("^0\\d+")),
    ONLY_NUMBER(Pattern.compile("^\\d+$")),
    ;

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
