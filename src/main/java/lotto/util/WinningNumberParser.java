package lotto.util;

import java.util.Arrays;
import java.util.List;

public class WinningNumberParser {

    private static final String DELIMITER = ",";

    public static List<String> parseWinningNumber(String winningNumber) {
        return Arrays.stream(winningNumber.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
