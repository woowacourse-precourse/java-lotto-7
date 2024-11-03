package lotto.util.input;

import java.util.Arrays;
import java.util.List;
import lotto.util.error.ErrorMessage;
import lotto.util.error.InputErrorMessage;
import org.junit.platform.commons.util.StringUtils;

public class InputParser {

    private static final String SEPARATOR = ",";
    private static final String ONLY_NUMBERS_AND_SEPARATORS = "^[\\d" + SEPARATOR + "]+$";

    private InputParser() {
    }

    public static int validateAndParsePurchaseAmount(String rawInput) {
        validateNotEmpty(rawInput, InputErrorMessage.PURCHASE_AMOUNT_EMPTY);
        return parseInteger(rawInput, InputErrorMessage.PURCHASE_AMOUNT_INVALID);
    }

    public static List<Integer> validateAndParseWinningNumbers(String rawInput) {
        validateNotEmpty(rawInput, InputErrorMessage.WINNING_NUMBERS_EMPTY);
        validateFormat(rawInput);
        return parseNumberList(rawInput);
    }

    public static int validateAndParseBonusNumber(String rawInput) {
        validateNotEmpty(rawInput, InputErrorMessage.BONUS_NUMBER_EMPTY);
        return parseInteger(rawInput.trim(), InputErrorMessage.BONUS_NUMBER_INVALID);
    }

    private static void validateNotEmpty(String input, ErrorMessage error) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(error.get());
        }
    }

    private static void validateFormat(String input) {
        if (!input.matches(InputParser.ONLY_NUMBERS_AND_SEPARATORS)) {
            throw new IllegalArgumentException(InputErrorMessage.WINNING_NUMBERS_INVALID.get());
        }
    }

    private static int parseInteger(String input, ErrorMessage errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage.get());
        }
    }

    private static List<Integer> parseNumberList(String input) {
        try {
            return Arrays.stream(input.split(SEPARATOR))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.WINNING_NUMBERS_INVALID.get());
        }
    }
}
