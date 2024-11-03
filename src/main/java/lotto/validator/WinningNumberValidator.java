package lotto.validator;

import static lotto.validator.ValidatorUtils.WINNING_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.validateNumberRange;

public class WinningNumberValidator implements Validator<String[]> {

    private static final Integer LOTTO_NUMBER_COUNT = 6;

    @Override
    public void validate(String[] winningNumbers) {
        validateWinningNumbersRange(winningNumbers);
    }

    private void validateWinningNumbersRange(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            try {
                validateNumberRange(Integer.parseInt(winningNumber));
            } catch {
        }
    }
}
