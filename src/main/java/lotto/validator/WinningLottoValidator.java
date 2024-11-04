package lotto.validator;

import java.util.Arrays;
import java.util.List;
import lotto.exception.IllegalDuplicationException;
import lotto.exception.IllegalInputException;
import lotto.exception.IllegalRangeException;
import lotto.exception.IllegalSizeException;
import lotto.exception.IllegalTypeException;
import org.junit.platform.commons.util.StringUtils;

public class WinningLottoValidator {

    public static final String INPUT = "로또 번호";
    public static final String TYPE = "정수";
    public static final int MIN_VALUE = 1, MAX_VALUE = 45;
    public static final int SIZE = 6;
    private static final String DELIMITER = ",";

    public static List<Integer> validateWinningNumbers(String input) {
        validateBlank(input);

        List<Integer> winningNumbers = Arrays.stream(input.split(DELIMITER))
                .peek(WinningLottoValidator::validateBlank)
                .map(WinningLottoValidator::validateType)
                .peek(WinningLottoValidator::validateRange)
                .toList();

        validateSize(winningNumbers);
        validateDuplication(winningNumbers);

        return winningNumbers;
    }

    private static void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalInputException();
        }
    }

    private static int validateType(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalTypeException(INPUT, TYPE);
        }
    }

    private static void validateRange(int input) {
        if (input < MIN_VALUE || input > MAX_VALUE) {
            throw new IllegalRangeException(INPUT, MIN_VALUE, MAX_VALUE);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalSizeException(INPUT, SIZE, TYPE);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalDuplicationException(INPUT);
        }
    }
}
