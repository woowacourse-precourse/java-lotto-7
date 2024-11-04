package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static List<Integer> convertToNumbers(List<String> input) {
        return input.stream()
                .map(Parser::parseInt)
                .collect(Collectors.toList());
    }
}
