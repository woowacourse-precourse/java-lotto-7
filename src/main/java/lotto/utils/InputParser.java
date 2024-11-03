package lotto.utils;

import static java.lang.String.format;
import static lotto.exception.ErrorMessage.BONUS_NUMBER_NOT_DIGIT;
import static lotto.exception.ErrorMessage.END_WITH_DELIMITER;
import static lotto.exception.ErrorMessage.INPUT_EMPTY_ERROR;
import static lotto.exception.ErrorMessage.MONEY_NOT_NUMBER;
import static lotto.exception.ErrorMessage.WINNING_NUMBER_NOT_DIGIT;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;

public class InputParser {
    private final static String DELIMITER = ",";

    public static int parsePrice(final String input) {
        validateEmpty(input);

        int purchaseAmount;

        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(MONEY_NOT_NUMBER);
        }

        return purchaseAmount;
    }

    public static List<Integer> parseNumbers(final String input) {
        validateInput(input);

        return splitByDelimiter(input).stream()
                .map(InputParser::convertToInt)
                .toList();
    }

    public static int parseBonusNumber(final String input) {
        validateEmpty(input);

        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoException(BONUS_NUMBER_NOT_DIGIT);
        }

        return number;
    }

    private static void validateInput(final String input) {
        validateEndWithDelimiter(input);
        validateEmpty(input);
    }

    private static void validateEmpty(final String input) {
        if (isEmpty(input)) {
            throw new LottoException(INPUT_EMPTY_ERROR);
        }
    }

    private static void validateEndWithDelimiter(final String input) {
        if (isEndWithDelimiter(input)) {
            throw new LottoException(format(END_WITH_DELIMITER.getMessage(), DELIMITER));
        }
    }

    private static List<String> splitByDelimiter(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .toList();
    }

    private static int convertToInt(final String str) {
        int number;

        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new LottoException(WINNING_NUMBER_NOT_DIGIT);
        }

        return number;
    }

    private static boolean isEndWithDelimiter(final String input) {
        return input.endsWith(DELIMITER);
    }

    private static boolean isEmpty(final String input) {
        return input.isEmpty();
    }
}
