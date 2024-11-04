package lotto.enums;

public enum LottoConstant {

    // 프로그램 정보
    ACCESS_COUNT(3),

    // 로또 티켓 정보
    PRICE(1000),
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COUNT(6),
    BONUS_MATCH_COUNT(5);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
