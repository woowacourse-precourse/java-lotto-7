package lotto.config;

public enum LottoSettings {
    TICKET_PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    COUNT(6),
    PRIZE_3(5000),
    PRIZE_4(50000),
    PRIZE_5(1500000),
    PRIZE_5_BONUS(30000000),  // 5개 + 보너스 번호
    PRIZE_6(2000000000);

    private final int value;

    LottoSettings(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
