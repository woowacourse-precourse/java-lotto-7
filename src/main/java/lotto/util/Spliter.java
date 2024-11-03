package lotto.util;

import java.util.List;

public class Spliter {
    private Spliter() {
    }

    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static List<String> splitStringByDelimiter(String winnungNumbers) {
        return List.of(winnungNumbers.split(WINNING_NUMBER_DELIMITER, -1));
    }
}
