package lotto.domain;

public class LottoNumber {
    private static final int MAX_LOTTO = 45;
    private static final int MIN_LOTTO = 1;

    public LottoNumber(int number) {
        vaildateNumberRange(number);
    }

    private void vaildateNumberRange(int number) {
        if (number < MIN_LOTTO || number > MAX_LOTTO) {
            throw new IllegalArgumentException(" 번호는 1-45의 숫자여야 합니다.");
        }
    }

}
