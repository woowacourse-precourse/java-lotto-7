package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumberRule;

public class LottoNumbersValidator implements Validator {
    private final List<Integer> winningNumbers;

    public LottoNumbersValidator(List<Integer> winningNumbers) {
        this.winningNumbers = List.copyOf(winningNumbers);
    }

    @Override
    public void validate() throws IllegalArgumentException {
        validateWinningNumbersCountSix();
        validateWinningNumbersInRange();
        validateWinningNumbersDuplication();
    }

    private void validateWinningNumbersCountSix() throws IllegalArgumentException {
        if (winningNumbers.size() != LottoNumberRule.FIXED_SIZE.get()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_COUNT_NOT_SIX.get());
        }
    }

    private void validateWinningNumbersInRange() throws IllegalArgumentException {
        winningNumbers.forEach(number -> {
            if (number < LottoNumberRule.MIN_NUMBER.get() || number > LottoNumberRule.MAX_NUMBER.get()) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.get());
            }
        });
    }

    private void validateWinningNumbersDuplication() throws IllegalArgumentException {
        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED.get());
        }
    }
}
