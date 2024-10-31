package lotto.enums;

public enum Delimiter {
    ERROR("[ERROR] "),
    COMMA(","),
    CONTINUE_COMMA(",,");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
