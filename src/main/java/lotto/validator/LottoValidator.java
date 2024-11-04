package lotto.validator;

import java.util.List;
import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoException;
import lotto.model.LottoConstants;

public class LottoValidator {

    public void validateLotto(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateLottoNumbersDuplication(numbers);
        validateLottoNumberRange(numbers);
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        if (hasOutOfRangeNumber(numbers)) {
            throw new LottoException(LottoErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE);
        }
    }

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(Integer number) {
        return number > LottoConstants.MAX_LOTTO_NUMBER.getValue()
                || number < LottoConstants.MIN_LOTTO_NUMBER.getValue();
    }

    private void validateLottoNumbersDuplication(List<Integer> numbers) {
        long distinctCount = getDistinctCount(numbers);
        int totalCount = numbers.size();
        if (distinctCount != totalCount) {
            throw new LottoException(LottoErrorMessage.LOTTO_NUMBER_DUPLICATION);
        }
    }

    private long getDistinctCount(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_COUNT.getValue()) {
            throw new LottoException(LottoErrorMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
    }
}
