package lotto.constants;

public enum RegExConstants {
    LOTTO_NUMBERS_REGEX("^(?:[1-9]|[1-3][0-9]|4[0-5])(,(?:[1-9]|[1-3][0-9]|4[0-5])){5}$");
    private final String regex;

    RegExConstants(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
