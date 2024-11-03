package lotto.statistics;

public enum LottoBall {
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int value;

    LottoBall(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isInRange(int number) {
        return isGreaterOrEqualMinNumber(number) && isLessOrEqualMaxNumber(number);
    }

    private static boolean isGreaterOrEqualMinNumber(int number) {
        return number >= MIN_NUMBER.getValue();
    }

    private static boolean isLessOrEqualMaxNumber(int number) {
        return number <= MAX_NUMBER.getValue();
    }
}
