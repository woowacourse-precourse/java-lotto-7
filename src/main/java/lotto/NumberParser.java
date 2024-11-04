package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class NumberParser {
    private static final String DELIMITER = ",";

    private NumberParser() {

    }

    public static List<Integer> split(String numbers) {
        List<String> a = Arrays.stream(numbers.split(DELIMITER))
                .toList();

        return convertToInteger(a);
    }

    public static List<Integer> convertToInteger(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
