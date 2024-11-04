package lotto.util.validator;

import java.util.Arrays;
import java.util.List;

public class WinnerNumberValidator {
    private static final String WINNER_NUMBER_DELIMITER = ",";

    public static List<Integer> validate(String winnerNumber) {
        return Arrays.stream(winnerNumber.split(WINNER_NUMBER_DELIMITER))
                .peek(NumericValidator::validate)
                .map(Integer::parseInt)
                .toList();
    }
}
