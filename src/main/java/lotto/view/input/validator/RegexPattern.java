package lotto.view.input.validator;

import java.util.regex.Pattern;

public enum RegexPattern {
    NUMBER_REGEX(Pattern.compile("^[1-9]\\d*$")),
    LOTTO_REGEX(Pattern.compile("^\\d+(?:,\\d+)+$"));
    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }
    public boolean match(String input) {
        return pattern.matcher(input).matches();
    }
}
