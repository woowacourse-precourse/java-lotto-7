package lotto.utils;

import static java.util.Arrays.stream;
import static lotto.utils.Error.BONUS_NUMBER_NOT_A_NUMBER;
import static lotto.utils.Error.PURCHASE_AMOUNT_NOT_A_NUMBER;
import static lotto.utils.Error.WINNING_NUMBERS_NOT_A_NUMBER;

import java.util.List;

public class Parser {
    private static final String DELIMITER = ",";

    public static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_A_NUMBER.getDescription());
        }
    }

    public static List<Integer> parseWinningNumbers(String input) {
        try {
            return stream(input.split(DELIMITER, -1)).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_A_NUMBER.getDescription());
        }
    }

    public static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_A_NUMBER.getDescription());
        }
    }
}
