package lotto.validator;

import static lotto.message.ExceptionMessage.INVALID_TYPE_INPUT;

import java.util.Arrays;
import java.util.List;
import lotto.exception.IllegalTypeException;

public class WinningLottoValidator {

    private static final String INPUT = "로또 번호";
    private static final String TYPE = "정수";
    private static final String DELIMITER = ",";
    private static final int MIN_VALUE = 1, MAX_VALUE = 45;

    public static List<Integer> validateWinningNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER)).map(WinningLottoValidator::validateType).toList();
    }

    public static int validateBonusNumber(String input) {
        return Integer.parseInt(input);
    }

    private static int validateType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalTypeException(
                    String.format(INVALID_TYPE_INPUT.getMessage(), INPUT, TYPE)
            );
        }
    }
}
