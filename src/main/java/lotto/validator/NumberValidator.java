package lotto.validator;

import static lotto.exception.NumberErrorCode.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;

public class NumberValidator {
    public void checkNumberDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR.getMessage());
            }
        }
    }

    public void checkNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstant.PICK_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR.getMessage());
        }
    }
}
