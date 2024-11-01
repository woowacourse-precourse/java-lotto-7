package lotto.common.constant;

public enum LottoNumber {
    
    LOTTO_NUMBER_LOWER_BOUND(1),
    LOTTO_NUMBER_UPPER_BOUND(45),
    ;

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}
