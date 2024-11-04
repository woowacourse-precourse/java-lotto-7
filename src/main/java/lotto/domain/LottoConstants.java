package lotto.domain;

public enum LottoConstants {
    LOTTO_MIN_NUMBER(1),    // 로또 번호 최소값
    LOTTO_MAX_NUMBER(45),   // 로또 번호 최대값
    LOTTO_PRICE(1000),      // 한 장의 가격
    LOTTO_SIZE(6);  // 번호 개수

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
