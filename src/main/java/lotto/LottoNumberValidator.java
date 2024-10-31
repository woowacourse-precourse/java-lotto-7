package lotto;

import java.util.List;

public class LottoNumberValidator {

    public void validateRange(final int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    public void validateUnit(final int number) {
        if (number % 1_000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateContains(final List<Integer> numbers, final int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
