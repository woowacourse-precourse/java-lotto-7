package lotto.util;

import lotto.constant.Separator;

import java.util.Arrays;
import java.util.List;

public class Convertor {
    public static Long stringToLong(String input) {
        return Long.parseLong(input);
    }
    public static List<Integer> splitByList(String input) {
        return Arrays.stream(input.split(Separator.COMMA.getSeparator()))
                .map(Integer::parseInt)
                .toList();
    }
    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
