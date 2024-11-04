package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoParser {
    private static final String DELIMITER = ",";
    private static final String INVALID_FORMAT_ERROR = "[ERROR] 로또 번호는 쉼표(,)로 구분된 숫자만 입력 가능합니다.";

    public static List<Integer> parseWinningNumbers(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
        }
    }
}