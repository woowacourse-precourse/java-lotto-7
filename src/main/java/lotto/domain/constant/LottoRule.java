package lotto.domain.constant;

public enum LottoRule {

    LOTTO_SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int number;

    LottoRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
