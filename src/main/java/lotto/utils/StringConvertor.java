package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConvertor {
    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> toLottoNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
