package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final int value;

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.value = number;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_MIN || lottoNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 정수만 가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }
}
