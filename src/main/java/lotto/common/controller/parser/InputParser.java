package lotto.common.controller.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class InputParser {

    private static final String LIST_DELIMITER = ",";

    private InputParser() {
    }

    public static long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 long 타입의 수로 변환될 수 없습니다.");
        }
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 int 타입의 수로 변환될 수 없습니다.");
        }
    }

    public static List<Integer> parseIntegerList(String input) {
        try {
            return Arrays.stream(input.split(LIST_DELIMITER)).map(InputParser::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 int 타입의 수로 변환될 수 없습니다.");
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("[ERROR] list 구분자가 유효하지 않습니다.");
        }
    }
}
