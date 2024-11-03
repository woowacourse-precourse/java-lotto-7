package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersParser {
    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public static List<Integer> parse(String input) {
        List<Integer> parsedWinningNumbers = new ArrayList<>();
        String[] splitNumbers = input.split(WINNING_NUMBERS_DELIMITER);
        for (String number : splitNumbers) {
            parsedWinningNumbers.add(Integer.parseInt(number.trim()));
        }
        return parsedWinningNumbers;
    }
}
