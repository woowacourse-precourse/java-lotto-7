package lotto.enums;

public enum Symbol {

    COMMA(","),
    ;

    private final String value;

    Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
