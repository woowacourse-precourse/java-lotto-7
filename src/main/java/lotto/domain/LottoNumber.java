package lotto.domain;

public record LottoNumber(int number) {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public LottoNumber {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

}
