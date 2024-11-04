package lotto.domain;

public record LottoNumber(int value) {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public LottoNumber {
        validate(value);
    }

    public void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 로또 번호는 %d에서 %d사이의 숫자여야 합니다. ", MIN_NUMBER, MAX_NUMBER));
        }
    }
}
