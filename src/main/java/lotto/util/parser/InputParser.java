package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String SPLIT_DELIMITER = ",";

    private InputParser() {}

    public static List<Integer> parseWinningNumbers(String input) {
        // 문자열을 쉼표로 분리하여 Integer 리스트로 변환
        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(String::trim) // 공백 제거
                .map(Integer::parseInt) // String을 Integer로 변환
                .collect(Collectors.toList());
    }

    public static int parseNumber(String input) {
        return Integer.parseInt(input.trim());
    }
}
