package lotto.constants;

public enum LottoConstInteger {
    LOTTO_PRICE(1000)
    ;
    private final int value;
    LottoConstInteger(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
