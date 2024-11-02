package lotto.util;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Constants.ERROR_DUPLICATE_NUMBER;
import static lotto.util.Constants.ERROR_LOTTO_NUMBER;

public class WinningNumberParser {

    private List<Integer> winningNumbers = new ArrayList<>();

    public List<Integer> parseWinningNumbers(String winningNumber) {
        String[] result = winningNumber.split(",");

        for (String string : result) {
            winningNumbers.add(conventToInt(string.strip()));
        }

        winningNumbers = winningNumbers.stream().distinct().toList();

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER.getMessage());
        }

        return winningNumbers;
    }

    private static int conventToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER.getMessage());
        }
    }
}