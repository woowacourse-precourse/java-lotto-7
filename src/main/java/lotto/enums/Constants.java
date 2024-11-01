package lotto.enums;

public enum Constants {
    MONEY_UNIT(1000),
    MAX_LOTTO_NUM(45),
    MIN_LOTTO_NUM(1),
    NUMBER_OF_LOTTO_NUMBERS(6);
    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
