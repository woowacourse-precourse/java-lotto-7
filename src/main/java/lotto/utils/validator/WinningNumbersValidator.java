package lotto.utils.validator;

import static lotto.constants.ErrorMessage.EMPTY_LOTTO_WINNING_NUMBERS;
import static lotto.constants.ErrorMessage.HAS_CONSECUTIVE_COMMA;
import static lotto.constants.ErrorMessage.ONLY_DIGITS_AND_COMMAS_ALLOWED;

public class WinningNumbersValidator {

    public final static String CONSECUTIVE_COMMAS = ",,";
    public final static char COMMA = ',';

    public static void validateNumbers(String winningNumbers) {
        checkEmptyNumbers(winningNumbers);
        checkUnCorrectForm(winningNumbers);
    }

    private static void checkEmptyNumbers(String winningNumbers) {
        if (winningNumbers.isBlank()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_WINNING_NUMBERS.getMessage());
        }
    }

    private static void checkUnCorrectForm(String winningNumbers) {
        hasConsecutiveComma(winningNumbers);
        hasInvalidNumberCommaFormat(winningNumbers);
    }

    private static void hasConsecutiveComma(String winningNumbers) {
        if (winningNumbers.contains(CONSECUTIVE_COMMAS)) {
            throw new IllegalArgumentException(HAS_CONSECUTIVE_COMMA.getMessage());
        }
    }

    private static void hasInvalidNumberCommaFormat(String winningNumbers) {
        for (int i = 0; i < winningNumbers.length(); i++) {
            if (!Character.isDigit(winningNumbers.charAt(i)) && !isComma(winningNumbers.charAt(i))) {
                throw new IllegalArgumentException(ONLY_DIGITS_AND_COMMAS_ALLOWED.getMessage());
            }
        }
    }

    private static boolean isComma(char input) {
        return input == COMMA;
    }
}
