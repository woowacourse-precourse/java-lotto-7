package lotto;

import java.util.List;

public class LottoNumberValidator {

    public LottoNumberValidator validateRange(final int number, final int min, final int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public LottoNumberValidator validateUnit(final int number, final int unit) {
        if (number % unit != 0) {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public LottoNumberValidator validateContains(final List<Integer> numbers, final int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
        return this;
    }
}
