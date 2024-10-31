package lotto.validation;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.LottoNumbers.*;

public class WinningNumberValidation {
    private final static String DELIMITER = ",";

    public static void validate(String inputWinningNumbers) {
        List<String> winningNumbers = setTrimNumbers(inputWinningNumbers);
        winningNumbers = setUniqueNumbers(winningNumbers);
        List<Integer> parsedWinningNumbers = parseNumbers(winningNumbers);
        validateRange10To45(parsedWinningNumbers);
    }

    public static List<String> setTrimNumbers(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public static List<String> setUniqueNumbers(List<String> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
        }

        Set<String> uniqueWinningNumbers = Set.copyOf(winningNumbers);
        if (uniqueWinningNumbers.size() < winningNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_LENGTH_6.getErrorMessage());
        }

        return uniqueWinningNumbers.stream().toList();
    }

    public static List<Integer> parseNumbers(List<String> winningNumbers) {
        return winningNumbers.stream().map(number -> {
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_MONEY.getErrorMessage());
            }
        }).toList();
    }

    public static void validateRange10To45(List<Integer> winningNumbers) {
        boolean isLottoNumber = winningNumbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
        if (!isLottoNumber) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ONLY_CAN_RANGE_1_TO_45.getErrorMessage());
        }
    }
}
