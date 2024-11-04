package lotto.domain;

public record Bonus(int number) {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final String NUMBER_RANGE_ERROR_MESSAGE =
            String.format("보너스 번호는 %d이상 %d이하여야 합니다.", MIN_NUMBER, MAX_NUMBER);

    public Bonus {
        validate(number);
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
