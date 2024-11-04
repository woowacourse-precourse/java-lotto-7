package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AnswerParser {
    public static List<Integer> getAnswerList(String input) {
        try {
            return Arrays.stream(input.replaceAll("\\[|\\]", "").split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
