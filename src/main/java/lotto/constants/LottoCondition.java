package lotto.constants;

public enum LottoCondition {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBERS(6),
    ONE_LOTTO_TICKET_PRICE(1000);

    private final int lottoCondition;

    private LottoCondition(int lottoCondition) {
        this.lottoCondition = lottoCondition;
    }

    public int get() {
        return lottoCondition;
    }
}
