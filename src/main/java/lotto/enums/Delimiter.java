package lotto.enums;

public enum Delimiter {
    ERROR("[ERROR] "),
    COMMA(",");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
