package lotto.validation;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.ErrorMessage.LOTTO_NUMBER_ONLY_CAN_MONEY;

public class WinningNumberValidation {
    private final static String DELIMITER = ",";

    public static List<Integer> parseLottoNumbers(String inputWinningNumbers) {
        List<String> winningNumbers = setTrimNumbers(inputWinningNumbers);
        return parseNumbers(winningNumbers);
    }

    public static List<String> setTrimNumbers(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(DELIMITER))
                .map(String::trim)
                .toList();
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
}
