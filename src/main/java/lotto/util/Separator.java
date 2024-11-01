package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Separator {

    private static final String DEFAULT_DELIMITER  = ",";

    public static String[] splitWithComma(String str) {
        return str.split(DEFAULT_DELIMITER);
    }

    public static List<Integer> splitWithCommaToInteger(String str) {
        String[] numbers = splitWithComma(str);
        return List.of(Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toArray(Integer[]::new));
    }

}
