package lotto.util;

public enum Regex {

    COMMA(","),
    INTEGER("-?\\d+");

    private final String value;

    Regex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
