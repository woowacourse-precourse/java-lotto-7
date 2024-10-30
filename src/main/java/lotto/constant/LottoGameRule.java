package lotto.constant;

public enum LottoGameRule {
    LOTTO_COST(1000);

    private int value;

    LottoGameRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
