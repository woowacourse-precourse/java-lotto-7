package lotto.domain;

import static lotto.global.Error.LOTTO_NUMBER_COUNT_IS_NOT_SIX;
import static lotto.global.Error.LOTTO_NUMBER_IS_DUPLICATED;
import static lotto.global.Error.LOTTO_NUMBER_IS_NOT_BETWEEN_1_AND_46;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSizeIsNotSix(numbers);
        validateNumbersDuplicated(numbers);
        validateNumberNotBetween1And46(numbers);
    }

    private void validateLottoSizeIsNotSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_IS_NOT_SIX.getErrorMsg());
        }
    }

    private void validateNumbersDuplicated(List<Integer> numbers) {
        if (numbers.stream().count() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_DUPLICATED.getErrorMsg());
        }
    }

    private void validateNumberNotBetween1And46(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> notBetween1And46(number))) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_NOT_BETWEEN_1_AND_46.getErrorMsg());
        }
    }

    private boolean notBetween1And46(Integer number) {
        if (number < 1 || number > 46) {
            return true;
        }
        return false;
    }
}
