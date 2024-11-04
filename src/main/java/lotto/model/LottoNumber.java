package lotto.model;

public class LottoNumber {

    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;

    private Integer number;

    public LottoNumber(int number) {
        validate1To45Range(number);
        this.number = number;
    }

    private void validate1To45Range(int number) {
        if (number > LOTTO_MAXIMUM_NUMBER || number < LOTTO_MINIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
