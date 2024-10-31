package lotto.validation;

import java.util.Arrays;
import java.util.List;

public class WinningNumberValidation {
    private final static String DELIMITER = ",";

    public static void validate(String inputWinningNumbers) {
        List<String> winningNumbers = setTrimNumbers(inputWinningNumbers);
    }

    public static List<String> setTrimNumbers(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
