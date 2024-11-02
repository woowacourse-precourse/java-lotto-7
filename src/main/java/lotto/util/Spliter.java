package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Spliter {
    private Spliter() {
    }

    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static List<String> splitWinningNumbers(String winnungNumbers) {
        return List.of(winnungNumbers.split(WINNING_NUMBER_DELIMITER, -1));
    }
}
