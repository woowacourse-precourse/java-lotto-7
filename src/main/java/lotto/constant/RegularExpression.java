package lotto.constant;

public enum RegularExpression {
    INTEGER_PATTERN("-?\\d+");

    private final String expression;

    RegularExpression(String regularExpression) {
        this.expression = regularExpression;
    }

    public String getExpression() {
        return expression;
    }
}
