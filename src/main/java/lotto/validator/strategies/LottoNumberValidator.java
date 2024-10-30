package lotto.validator.strategies;

import java.util.List;
import lotto.constants.LottoConstants;
import lotto.view.ErrorMessage;

public class LottoNumberValidator implements ValidationStrategy<List<Integer>> {

    @Override
    public void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_INVALID.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!isAllNumbersInRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_INVALID.getMessage());
        }
    }

    private boolean isAllNumbersInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(this::isNumberInRange);
    }

    private boolean isNumberInRange(int number) {
        return number >= LottoConstants.MIN_NUMBER && number <= LottoConstants.MAX_NUMBER;
    }


}
