package lotto.staticenum;

import java.text.NumberFormat;

public enum WinningAmountEnum {

    FIVE(5000),
    FOUR(50000),
    THREE(1500000),
    TWO(30000000),
    ONE(2000000000),
    ;

    private final int value;

    WinningAmountEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getStringValue() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(value);
    }
}
