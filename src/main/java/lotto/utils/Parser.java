package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static final String DELIMITER = ",";

    public static List<String> inputParser(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
