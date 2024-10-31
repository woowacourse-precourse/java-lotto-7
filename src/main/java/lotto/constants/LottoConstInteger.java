package lotto.constants;

public enum LottoConstInteger {
    LOTTO_PRICE(1000),
    LOTTO_START_NUMBER(1),
    LOTTO_END_NUMBER(45),

    ;
    private final int value;
    LottoConstInteger(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
