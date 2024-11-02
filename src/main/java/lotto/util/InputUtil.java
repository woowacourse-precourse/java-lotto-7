package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputUtil {

    public static List<Integer> splitNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
