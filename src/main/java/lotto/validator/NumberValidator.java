package lotto.validator;

import static lotto.exception.NumberErrorCode.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.exception.NumberErrorCode;

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

    public void checkNumberRange(List<Integer> numbers) {
        numbers.forEach(this::checkNumberRange);
    }

    public void checkNumberRange(Integer number) {
        if (isNotInRange(number)) {
            throw new IllegalArgumentException(NumberErrorCode.NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public void checkNumberDuplicatedWithWinningNumber(Integer bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private boolean isNotInRange(int number) {
        return number < LottoConstant.START_INDEX || number > LottoConstant.END_INDEX;
    }
}
