package lotto.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    private final String DELIMITER = ",";
    public List<String> parse(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }
}
