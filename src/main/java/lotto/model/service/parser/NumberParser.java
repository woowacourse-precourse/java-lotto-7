package lotto.model.service.parser;

import static lotto.message.ErrorMessage.INVALID_BONUS_NUMBER_INPUT;
import static lotto.message.ErrorMessage.INVALID_WINNING_NUMBER_INPUT;

import java.util.List;
import java.util.stream.Stream;

public class NumberParser {

    private static final String DELIMITER = ",";

    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        try {
            return Stream.of(winningNumbers.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_INPUT.getMessage());
        }

    }

    public static Integer parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_INPUT.getMessage());
        }
    }
}
