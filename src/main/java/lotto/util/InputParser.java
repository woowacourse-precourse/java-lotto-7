package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값에 대해 숫자로 입력해야합니다.");
        }
    }

    public static List<Integer> convertStringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim) // 각 요소의 양쪽 공백 제거
                .filter(part -> {
                    if (part.isEmpty() || !part.matches("\\d+")) {
                        throw new IllegalArgumentException("[ERROR] 입력 값은 쉼표(,)로 구분된 숫자여야 합니다.");
                    }
                    return true;
                })
                .map(Integer::parseInt)
                .toList();
    }
}
