package lotto.model.validator.lotto;

import static lotto.exception.InvalidLottoNumberException.INVALID_WINNING_NUMBERS;
import static lotto.util.LottoConstants.LOTTO_NUMBERS_COUNT;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;

public class WinningNumbersValidator extends NumberValidator {
    public WinningNumbersValidator(List<Integer> winNumbers) {
        super(winNumbers);
    }

    @Override
    protected void validateWithHook() {
        validateNumberCount();
    }

    private void validateNumberCount() {
        if (winNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new InvalidLottoNumberException(INVALID_WINNING_NUMBERS);
        }
    }

}
