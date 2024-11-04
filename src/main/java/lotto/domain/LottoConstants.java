package lotto.domain;

public enum LottoConstants {

    LOTTO_PRICE(1000),      // 로또 한 장의 가격
    LOTTO_NUMBER_COUNT(6),  // 로또 번호 개수
    LOTTO_MIN_NUMBER(1),    // 로또 번호 최소값
    LOTTO_MAX_NUMBER(45),   // 로또 번호 최대값
    ;

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
