package lotto.config;

public enum LottoInfo {

    LOTTO_TICKET_PRICE(1000),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    LOTTO_NUMBER_SIZE(6);

    private final Integer value;

    LottoInfo(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
