package lotto;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public static List<Integer> parseIntListByComma(String input) {
        return Arrays.stream(input.split(",", -1)).map(StringParser::parseInt).toList();
    }
}
