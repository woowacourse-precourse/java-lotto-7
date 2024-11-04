package lotto.enums;

public enum LottoConfig{
    LOTTO_START_NUM(1),
    LOTTO_END_NUM(45),

    LOTTO_NUM_LENGTH(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConfig(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
