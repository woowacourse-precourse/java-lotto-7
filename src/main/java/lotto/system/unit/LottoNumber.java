package lotto.system.unit;

import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.system.utils.constants.LottoErrorMessages.INVALID_NUMBER_RANGE;

import lotto.system.utils.constants.LottoConstants;

public class LottoNumber implements Comparable<LottoNumber> { // 사용자가 입력 로또 번호 하나를 의미하는 객체

    private final int number;

    public LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        validate(number);
        return new LottoNumber(number);
    }

    public static void validate(final int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND || number > LottoConstants.LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUMBER_RANGE.getMessage(), LOTTO_NUMBER_LOWER_BOUND,
                            LottoConstants.LOTTO_NUMBER_UPPER_BOUND));
        }
    }

    public int getValue() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
