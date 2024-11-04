package lotto.util;

import java.util.List;

public class Separator {
    private static final String DEFAULT_DELIMITER = ",";

    public static List<String> separateLottoNumbers(String numbers) {
        return List.of(numbers.split(DEFAULT_DELIMITER));
    }
}
