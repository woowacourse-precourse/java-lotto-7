package lotto.utils;

import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class InputUtils {

    private static final int LIMIT_VALUE = 0;
    private static final String EMPTY_INPUT_ERROR = "[ERROR] 값을 입력해주세요.";
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 양의 정수를 입력해주세요.";


    public static int parseInt(String input) {
        checkBlank(input);
        int number = convertToInt(input);
        checkNegativeNumber(number);
        return number;
    }

    public static List<Integer> parseIntList(List<String> inputs) {
        checkBlank(inputs);
        List<Integer> parsedNumbers = inputs.stream()
                .map(InputUtils::parseInt)
                .toList();
        checkNegativeNumber(parsedNumbers);
        return parsedNumbers;
    }

    private static void checkBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private static void checkBlank(List<String> inputs) {
        if (inputs.stream().allMatch(StringUtils::isBlank)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private static void checkNegativeNumber(int input) {
        if (input <= LIMIT_VALUE) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private static void checkNegativeNumber(List<Integer> inputs) {
        if (inputs.stream().anyMatch(input -> input <= LIMIT_VALUE)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

}
