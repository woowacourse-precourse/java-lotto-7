package lotto.application.common.ThousandWons;

import static lotto.application.util.StringConverter.toInt;

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
        validatePositive(value);
        validateThousandUnit(value);
    }

    private static void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 금액이어야 합니다.");
        }
    }

    private static void validateThousandUnit(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력 가능 합니다.");
        }
    }

}

