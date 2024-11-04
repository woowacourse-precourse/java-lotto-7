package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    private static final String DELIMITER = ",";

    public static List<String> splitWithComma(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
