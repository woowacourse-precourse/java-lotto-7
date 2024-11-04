package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoParser {
    private static final String DELIMITER = ",";
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호가 올바르지 않습니다.";

    public static List<Integer> parseWinningNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
