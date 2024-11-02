package lotto.util;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.Constants.*;

public class WinningNumberParser {

    private static List<Integer> winningNumbers = new ArrayList<>();

    public List<Integer> parseWinningNumbers(String winningNumber) {
        String[] result = winningNumber.split(",");

        if (result.length != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_COUNT.getMessage());
        }

        for (String string : result) {
            int number = conventToInt(string.strip());
            validateNumberRange(number);  // 1-45 범위 체크 (필요한 경우)
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

    private static void validateDistinct() {
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER.getMessage());
        }
    }
}