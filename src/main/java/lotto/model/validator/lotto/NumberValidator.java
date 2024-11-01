package lotto.model.validator.lotto;

import static lotto.exception.InvalidLottoNumberException.DUPLICATE_WINNING_NUMBERS;
import static lotto.exception.InvalidLottoNumberException.OUT_OF_RANGE_NUMBER;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;
import lotto.model.validator.Validator;

public abstract class NumberValidator implements Validator {
    protected final List<Integer> winNumbers;

    public NumberValidator(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public final void validate() {
        validateNumberRange();
        validateNoDuplicates();
        validateWithHook();
    }

    private void validateNumberRange() {
        boolean outOfRange = winNumbers.stream().anyMatch(this::isOutOfRange);
        if (outOfRange) {
            throw new InvalidLottoNumberException(OUT_OF_RANGE_NUMBER);
        }
    }

    private void validateNoDuplicates() {
        long uniqueNumberCount = getUniqueNumberCount();

        if (uniqueNumberCount != winNumbers.size()) {
            throw new InvalidLottoNumberException(DUPLICATE_WINNING_NUMBERS);
        }
    }

    protected abstract void validateWithHook();

    private boolean isOutOfRange(int number) {
        return number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX;
    }

    private long getUniqueNumberCount() {
        return winNumbers.stream()
                .distinct()
                .count();
    }
}
