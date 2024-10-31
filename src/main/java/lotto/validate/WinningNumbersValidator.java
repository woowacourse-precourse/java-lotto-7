package lotto.validate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.ErrorMessage;

public class WinningNumbersValidator {

    private static final String DELIMITER = ",";
    private static final String INPUT_PATTERN = String.format("^[0-9]+(%s[0-9])*$", DELIMITER);

    public static List<Integer> getValidatedWinningNumbers(String input) {
        validatePattern(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validatePattern(String input) {
        if (!input.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_PATTERN.getMessage());
        }
    }
}
