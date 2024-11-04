package lotto.constants.lottoType;

public enum CalculateType {

    NO_WINNINGS_MONEY(0),
    PERCENT_100(100.0),
    ROUNDING_SCALE(10),
    ROUNDING_DIVISOR(10.0);

    private final double value;

    CalculateType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public int getIntValue() {
        return (int) value;
    }
}
