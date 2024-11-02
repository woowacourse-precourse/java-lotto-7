package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static long convertStringToLong(String input) {
        return Long.parseLong(input.trim());
    }

    public static List<Integer> convertStringToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static String convertIntToString(int input) {
        return Integer.toString(input);
    }

    public static String convertListToString(List<Integer> input) {
        return input.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
