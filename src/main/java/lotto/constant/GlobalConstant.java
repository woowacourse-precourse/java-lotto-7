package lotto.constant;

public enum GlobalConstant {
    NUMBER_REGEX("\\d+"),
    SEPARATOR(","),
    WINNING_COUNT("winningCount"),
    BONUS_COUNT("bonusCount"),
    UNIT("1000");

    private final String value;

    public int intValue() {
        return Integer.parseInt(value);
    }

    public String value() {
        return value;
    }

    GlobalConstant(String value) {
        this.value = value;
    }

}
