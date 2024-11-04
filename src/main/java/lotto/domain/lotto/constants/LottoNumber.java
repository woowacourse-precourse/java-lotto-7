package lotto.domain.lotto.constants;

public enum LottoNumber {
    LOTTO_COUNT(6),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    LOTTO_COST(1000);

    private final int criteria;

    LottoNumber(int criterion) {
        this.criteria = criterion;
    }

    public int getCriteria() {
        return criteria;
    }
}
