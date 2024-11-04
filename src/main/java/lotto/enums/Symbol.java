package lotto.enums;

public enum Symbol {
    NEW_LINE("\n"),
    COMMA_SPACE(", "),
    COMMA(","),
    OPEN_BRACKET("["),
    CLOSE_BRACKET("]");

    private final String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
