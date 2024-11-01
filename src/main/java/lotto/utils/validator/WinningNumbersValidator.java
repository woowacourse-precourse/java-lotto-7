package lotto.validator;

import static lotto.constants.ErrorMessage.EMPTY_LOTTO_WINNING_NUMBERS;
import static lotto.constants.ErrorMessage.HAS_CONSECUTIVE_COMMA;
import static lotto.constants.ErrorMessage.ONLY_DIGITS_AND_COMMAS_ALLOWED;

public class WinningNumbersValidator {

    public void validateNumbers(String winningNumbers) {
        checkEmptyNumbers(winningNumbers);
        checkUnCorrectForm(winningNumbers);
    }

    private void checkEmptyNumbers(String winningNumbers) {
        if (winningNumbers.isBlank()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_WINNING_NUMBERS.getMessage());
        }
    }

    private void checkUnCorrectForm(String winningNumbers) {
        hasConsecutiveComma(winningNumbers);
        hasInvalidNumberCommaFormat(winningNumbers);
    }

    private void hasConsecutiveComma(String winningNumbers) {
        if (winningNumbers.contains(",,")) {
            throw new IllegalArgumentException(HAS_CONSECUTIVE_COMMA.getMessage());
        }
    }

    private void hasInvalidNumberCommaFormat(String winningNumbers) {
        for (int i = 0; i < winningNumbers.length(); i++){
            if (!Character.isDigit(winningNumbers.charAt(i)) && !isComma(winningNumbers.charAt(i))){
                throw new IllegalArgumentException(ONLY_DIGITS_AND_COMMAS_ALLOWED.getMessage());
            }
        }
    }

    private boolean isComma(char input) {
        return input == ',';
    }
}
