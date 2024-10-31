package lotto.util;

import java.util.Arrays;
import java.util.List;

import static lotto.common.ExceptionMessage.INPUT_NOT_NUMBER;
import static lotto.common.ExceptionMessage.INVALID_FORMAT;

public class InputParser {

    private final static String NUMBER_DELIMITER = ",";

    private InputParser() {
    }

    public static Integer parseMoney(String money) {
        try {
            return Integer.parseInt(money.replaceAll(" ", ""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER.getMessage());
        }
    }

    public static List<Integer> parseNumbers(String numbers) {
        try {
            if (numbers.endsWith(NUMBER_DELIMITER)) {
                throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
            }
            return Arrays.stream(numbers.replaceAll(" ", "").split(NUMBER_DELIMITER))
                    .map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER.getMessage());
        }
    }

    public static Integer parseBonusNumber(String number) {
        try {
            return Integer.parseInt(number.replaceAll(" ", ""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER.getMessage());
        }
    }
}
