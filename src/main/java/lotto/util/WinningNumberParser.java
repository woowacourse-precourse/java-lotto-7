package lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.Constants.*;

public class WinningNumberParser {

    private List<Integer> winningNumbers;

    public List<Integer> parseWinningNumbers(String winningNumber) {
        winningNumbers = new ArrayList<>();

        String[] result = winningNumber.split(",");

        if (result.length != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_COUNT.getMessage());
        }

        for (String string : result) {
            int number = conventToInt(string.strip());
            validateNumberRange(number);
            winningNumbers.add(number);
        }

        validateDistinct();

        return winningNumbers;
    }

    private static int conventToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateDistinct() {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER.getMessage());
        }
    }
}
