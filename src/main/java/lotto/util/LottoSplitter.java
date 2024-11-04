package lotto.util;

import java.util.Arrays;
import java.util.List;

public class LottoSplitter {
    private static final String DELIMITER = ",";

    public static List<Integer> split(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
