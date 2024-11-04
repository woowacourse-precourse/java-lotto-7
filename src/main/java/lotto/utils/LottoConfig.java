package lotto.utils;

public enum LottoConfig {
    LOTTO_MAX_NUM(45),
    LOTTO_MIN_NUM(1),
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000),
    THREE_MATCHES_PRIZE(5000),
    FOUR_MATCHES_PRIZE(50000),
    FIVE_MATCHES_PRIZE(1500000),
    FIVE_MATCHES_WITH_BONUS_PRIZE(30000000),
    SIX_MATCHES_PRIZE(2000000000);
    
    private final int value;
    LottoConfig(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
