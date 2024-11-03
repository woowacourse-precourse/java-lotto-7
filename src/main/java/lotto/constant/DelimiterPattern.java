package lotto.constant;

public enum DelimiterPattern {
    NUMBER_VALIDATION_REGEX("^-?\\d+$"),

    COMMA(","),
    COMMA_SEPARATED_NUMERIC_LIST_REGEX("^(\\s*[0-9]+\\s*)(,\\s*[0-9]+\\s*)*$");


    private final String pattern;

    DelimiterPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
