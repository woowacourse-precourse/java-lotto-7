package lotto.validator;

import static lotto.message.ExceptionMessage.INVALID_BLANK_INPUT;
import static lotto.message.ExceptionMessage.INVALID_DUPLICATION_INPUT;
import static lotto.message.ExceptionMessage.INVALID_RANGE_INPUT;
import static lotto.message.ExceptionMessage.INVALID_TYPE_INPUT;

import java.util.Arrays;
import java.util.List;
import lotto.exception.IllegalDuplicationException;
import lotto.exception.IllegalInputException;
import lotto.exception.IllegalRangeException;
import lotto.exception.IllegalTypeException;
import org.junit.platform.commons.util.StringUtils;

public class WinningLottoValidator {

    public static final String INPUT = "로또 번호";
    public static final String TYPE = "정수";
    public static final int MIN_VALUE = 1, MAX_VALUE = 45;
    private static final String DELIMITER = ",";

    public static List<Integer> validateWinningNumbers(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(DELIMITER))
                .peek(WinningLottoValidator::validateBlank)
                .map(WinningLottoValidator::validateType)
                .peek(WinningLottoValidator::validateRange)
                .toList();
        validateDuplication(winningNumbers);

        return winningNumbers;
    }

    public static int validateBonusNumber(String input) {
        return Integer.parseInt(input);
    }

    private static void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalInputException(INVALID_BLANK_INPUT.getMessage());
        }
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

    private static void validateRange(int input) {
        if (input < MIN_VALUE || input > MAX_VALUE) {
            throw new IllegalRangeException(
                    String.format(INVALID_RANGE_INPUT.getMessage(), INPUT, MIN_VALUE, MAX_VALUE)
            );
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalDuplicationException(
                    String.format(INVALID_DUPLICATION_INPUT.getMessage(), INPUT)
            );
        }
    }
}
