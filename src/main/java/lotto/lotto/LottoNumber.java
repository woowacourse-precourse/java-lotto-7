package lotto.lotto;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER + "과 " + MAX_LOTTO_NUMBER + " 사이여야 합니다.");
        }
    }
}
