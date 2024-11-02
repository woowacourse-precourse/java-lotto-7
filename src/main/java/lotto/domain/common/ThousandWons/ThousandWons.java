package lotto.domain.common.ThousandWons;

import static lotto.util.StringConverter.toInt;

public class ThousandWons {

    private final int value;

    public ThousandWons(int value) {
        this.value = value;
    }

    public static ThousandWons of(String money) {
        int value = toInt(money);
        validate(value);

        return new ThousandWons(value);
    }

    public boolean isMuchThanOrEqual(int target) {
        return value >= target;
    }

    public int getValue() {
        return value;
    }

    public int divide(int target) {
        return value / target;
    }

    private static void validate(int value) {
        if (value == 0 || value % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력 가능 합니다.");
        }
    }

}

