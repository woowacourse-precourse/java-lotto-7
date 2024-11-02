package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class ConvertInput {
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    public static int makeMoneyToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw InputException.from(ErrorMessage.MONEY_HAS_CHARACTER);
        }
    }

    public static List<Integer> makeWinningNumberToList(String input) {
        try {
            return Arrays.stream(input.split(LOTTO_NUMBER_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw InputException.from(ErrorMessage.LOTTO_NUMBER_HAS_CHARACTER);
        }
    }

    public static int makeBonusNumberToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw InputException.from(ErrorMessage.BONUS_NUMBER_HAS_CHARACTER);
        }
    }
}
