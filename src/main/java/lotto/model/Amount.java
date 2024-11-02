package lotto.model;

import lotto.util.NumberUtil;

public class Amount {
    private final int value;

    public Amount(int number) {
        validateUnit(number);
        this.value = number;
    }

    public static Amount from(String number) {
        return new Amount(NumberUtil.parseInt(number));
    }

    private void validateUnit(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매는 1000원 단위로 가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
