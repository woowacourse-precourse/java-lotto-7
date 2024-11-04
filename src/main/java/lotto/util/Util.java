package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<Integer> stringToInt(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
