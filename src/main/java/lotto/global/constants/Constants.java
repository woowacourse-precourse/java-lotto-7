package lotto.global.constants;

public enum Constants {
    ERROR_HEADER("[ERROR] "),

    IS_CONTAIN_WHITESPACE_REGEX(".*\\s+.*"),
    WHITE_SPACE("\\s+"),
    COMMA_DIGITS_REGEX("^[0-9,]+$"),
    DIGIT_REGEX("^[0-9]+$")
    ;

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
