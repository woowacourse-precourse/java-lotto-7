package lotto.util.validator;

import static lotto.message.ErrorMessage.CHAINED_COMMA_WINNING_NUMBERS_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.EMPTY_INPUT_WINNING_NUMBERS_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.INVALID_CONTENT_WINNING_NUMBERS_ERROR_MESSAGE;

public class WinningNumbersValidator {

    private static final char COMMA = ',';

    public static void validate(String rawWinningNumbers) {
        validateNotEmptyString(rawWinningNumbers);
        validateContent(rawWinningNumbers);
        validateValidChainedComma(rawWinningNumbers);
    }

    private static void validateNotEmptyString(String rawWinningNumbers) {
        if (rawWinningNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_WINNING_NUMBERS_ERROR_MESSAGE.getContent());
        }
    }

    private static void validateContent(String rawWinningNumbers) {
        for (int i = 0; i < rawWinningNumbers.length(); i++) {
            char c = rawWinningNumbers.charAt(i);
            if (!(Character.isDigit(c) || isComma(c) || Character.isWhitespace(c))) {
                throw new IllegalArgumentException(INVALID_CONTENT_WINNING_NUMBERS_ERROR_MESSAGE.getContent());
            }
        }
    }

    private static void validateValidChainedComma(String rawWinningNumbers) {
        for (int i = 0; i < rawWinningNumbers.length() - 1; i++) {
            char content = rawWinningNumbers.charAt(i);
            char nextContent = rawWinningNumbers.charAt(i + 1);
            if (isComma(content) && isComma(nextContent)) {
                throw new IllegalArgumentException(CHAINED_COMMA_WINNING_NUMBERS_ERROR_MESSAGE.getContent());
            }
        }
    }

    private static boolean isComma(char c) {
        return c == COMMA;
    }
}
