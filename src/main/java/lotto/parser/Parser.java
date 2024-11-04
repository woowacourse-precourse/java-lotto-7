package lotto.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private static final String DELIMITER = ",";

    public List<Integer> parseInputToNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public int parseStringToInt(String input) {
        return Integer.parseInt(input);
    }
    public long parseStringToLong(String input) {
        return Long.parseLong(input);
    }
}
