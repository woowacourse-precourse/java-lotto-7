package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 정수를 입력해주세요.";
    
    public static Integer parseStringToInteger(String argument) {
        try {
            return Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    public static List<Integer> parseStringToIntegerList(String argument) {
        try {
            return Arrays.stream(argument.split(",")).mapToInt(Integer::parseInt).boxed().toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ARGUMENT_EXCEPTION_MESSAGE);
        }
    }
}
