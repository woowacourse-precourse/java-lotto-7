package lotto.constant;

public enum Condition {
    ONLY_NUMBERS("[^0-9,]|\\s|,,+");

    private final String value;

    private Condition(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
