package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String SEPARATOR = ",";

    // TODO: 정적 메서드로 갈지? DI 할지?
    public static int parseStringToInt(final String inputValue) {
        long number = Long.parseLong(inputValue);
        Validator.checkIntegerRange(number);
        return (int) number;
    }

    public static List<String> parseElements(final String inputValue) {
        return Arrays.stream(inputValue.split(SEPARATOR)).toList();
    }

}
