package lotto.eunm;

public enum LottoConstants {
    TICKET_PRICE_UNIT(1000),  // 로또 구매 단위 금액
    MINIMUM_NUMBER(0),          // 최소 숫자 값
    MIN_LOTTO_NUMBER(1),       // 로또 번호의 최소값
    MAX_LOTTO_NUMBER(45),      // 로또 번호의 최대값
    PERCENTAGE_BASE(100),
    LOTTO_NUMBERS_COUNT(6);    // 로또 한 장에 포함되는 번호의 개수

    public final int value;

    LottoConstants(int value) {
        this.value = value;
    }

}
