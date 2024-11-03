package lotto.common.constants;

public enum LottoNumberType {

    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    LOTTO_SIZE(6);

    private final int number;

    LottoNumberType(int n) {
        this.number = n;
    }

    public int getNumber() {
        return number;
    }

}