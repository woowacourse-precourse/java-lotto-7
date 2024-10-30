package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> arrayToList(String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
