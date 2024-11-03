package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFormatter {
    public static String formatLotto(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static List<Integer> parseStringToIntList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
