package lotto;

import java.util.List;

public class LottoNumberValidator {

    public LottoNumberValidator validateRange(final int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public LottoNumberValidator validateUnit(final int number) {
        if (number % 1_000 != 0) {
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
