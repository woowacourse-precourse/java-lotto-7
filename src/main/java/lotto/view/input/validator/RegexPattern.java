package lotto.view.input.validator;
import java.util.regex.Pattern;

public enum RegexPattern {
    NUMBER_REGEX(Pattern.compile("^[1-9]\\d*$")),
    LOTTO_REGEX(Pattern.compile("^[1-9]\\d*(?:,[1-9]\\d*)+$"));
    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }
    public boolean unMatch(String input) {
        return !pattern.matcher(input).matches();
    }
}
