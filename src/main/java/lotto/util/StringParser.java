package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    public static List<Integer> parseWinningNumbers(String input) {
        String[] numbers = input.split(",");
        return Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
