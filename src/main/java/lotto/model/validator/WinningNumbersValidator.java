package lotto.model.validator;

import static lotto.exception.InvalidLottoNumberException.DUPLICATE_WINNING_NUMBERS;
import static lotto.exception.InvalidLottoNumberException.INVALID_WINNING_NUMBERS;
import static lotto.exception.InvalidLottoNumberException.OUT_OF_RANGE_NUMBER;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;
import lotto.util.LottoConstants;

public class WinningNumbersValidator implements Validator{
    private final List<Integer> winNumbers;

    public WinningNumbersValidator(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    @Override
    public void validate() {
        validateNumberCount();
        validateNoDuplicateNumbers();
        validateNumberRange();
    }

    private void validateNumberCount() {
        if (winNumbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS);
        }
    }

    private void validateNoDuplicateNumbers() {
        long uniqueNumberCount = getUniqueNumberCount();

        if (uniqueNumberCount != winNumbers.size()) {
            throw new InvalidLottoNumberException(DUPLICATE_WINNING_NUMBERS);
        }
    }

    private void validateNumberRange() {
        boolean outOfRange = winNumbers.stream()
                .anyMatch(n -> n < LottoConstants.LOTTO_NUMBER_MIN || n > LottoConstants.LOTTO_NUMBER_MAX);

        if (outOfRange) {
            throw new InvalidLottoNumberException(OUT_OF_RANGE_NUMBER);
        }
    }

    private long getUniqueNumberCount() {
        return winNumbers.stream()
                .distinct()
                .count();
    }
}
