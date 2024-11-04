package lotto.enums;

import java.util.regex.Pattern;

public enum RegexPattern {

    START_WITH_ZERO(Pattern.compile("^0\\d+")),
    ONLY_NUMBER(Pattern.compile("^\\d+$")),
    ONLY_NUMBER_AND_COMMA(Pattern.compile("^\\d+(,\\d+)*$"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
