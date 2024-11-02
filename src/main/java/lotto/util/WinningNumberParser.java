package lotto.util;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Constants.ERROR_LOTTO_NUMBER;

public class WinningNumberParser {

    private static final List<Integer> winningNumbers = new ArrayList<>();

    public List<Integer> parseWinningNumbers(String winningNumber) {
        String[] result = winningNumber.split(",");

        for (String string : result) {
            winningNumbers.add(conventToInt(string.strip()));
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