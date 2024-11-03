package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.Constants;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

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
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        int numbersLength = numbers.size();
        if (numbersLength != Constants.LOTTO_LENGTH.getValue()) {
            throw LottoException.from(ErrorMessage.WINNING_LOTTO_IS_NOT_SIX_LENGTH);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constants.LOTTO_MIN_NUMBER.getValue() || number > Constants.LOTTO_MAX_NUMBER.getValue()) {
                throw LottoException.from(ErrorMessage.WINNING_LOTTO_RANGE_ERROR);
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int number : numbers) {
            if (!numberSet.add(number)) {
                throw LottoException.from(ErrorMessage.WINNING_LOTTO_DUPLICATE_ERROR);
            }
        }
    }
}
