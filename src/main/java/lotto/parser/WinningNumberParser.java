package lotto.parser;

import static lotto.message.ErrorMessage.INVALID_INTEGER_RANGE_WINNING_NUMBERS_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberParser {

    public static List<Integer> parseRawWinningNumbers(String rawWinningNumber) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] contents = rawWinningNumber.split(",");

        try {
            for (String content : contents) {
                int number = Integer.parseInt(content);
                winningNumbers.add(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_RANGE_WINNING_NUMBERS_ERROR_MESSAGE.getContent());
        }
        return winningNumbers;
    }
}
