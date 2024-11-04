package lotto.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StringParser {

    private static final String MUST_ENTER_A_VALID_NUMBER = "유효한 숫자를 입력해야 합니다.";

    public static Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MUST_ENTER_A_VALID_NUMBER);
        }
    }

    public static List<Integer> toNumericsSplitBy(String input, String delimiter) {
        return Stream.of(input)
                .flatMap(s -> Arrays.stream(s.split(delimiter)))
                .map(StringParser::toInteger)
                .toList();
    }
}
