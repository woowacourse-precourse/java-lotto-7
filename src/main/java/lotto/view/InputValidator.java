package lotto.view;

import java.util.List;
import lotto.exception.ErrorMessage;

public class InputValidator {

    public void validateDivisibleByThousand(long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_DIVIDE_THOUSAND.get());
        }
    }

    public void validateIsSizeSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalStateException(ErrorMessage.INVALID_LOTTO_LENGTH.get());
        }
    }

    public void validateIsIn(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.get());
        }
    }

    public void validateIsInBound(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_BOUND.get());
        }
    }
}
