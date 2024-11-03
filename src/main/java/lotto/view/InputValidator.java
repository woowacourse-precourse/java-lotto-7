package lotto.view;

import java.util.List;
import lotto.exception.ErrorMessage;

public class InputValidator {

    public void isDivisibleByThousand(long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_DIVIDE_THOUSAND.get());
        }
    }

    public void isSizeSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalStateException(ErrorMessage.INVALID_LOTTO_LENGTH.get());
        }
    }

    public void isExistsIn(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.get());
        }
    }
}
