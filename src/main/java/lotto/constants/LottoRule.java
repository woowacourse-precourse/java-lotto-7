package lotto.constants;

public enum LottoRule {
    LOTTO_NUMBER_SIX(6),
    LOTTO_MATCH_FIVE(5),
    SAME_NUMBER_COUNT(1),
    Lotto_Number_Min(1),
    Lotto_Number_Max(45),
    USE_ZERO(0),
    Thousand_Multi_Number(1000),
    PROFIT_PERCENTAGE_CALCULATE(100),
    SPLIT_ALL_TOKEN(-1),
    WIN_NUMBER_DELIMITER(",");

    private final int value;
    private final String delimiter;

    LottoRule(int value) {
        this.value = value;
        this.delimiter = null;
    }

    LottoRule(String delimiter) {
        this.value = -1;
        this.delimiter = delimiter;
    }

    public int getValue() {
        return value;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
