package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public int parseToInt(String input) {
        try {
            String inputWithoutSpace = input.replaceAll("\\s+", "");
            return Integer.parseInt(inputWithoutSpace);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[error] 정수만 입력할 수 있습니다.");
        }
    }

    public List<Integer> parseToIntList(String input) {
        List<String> parsedString = parseComma(input);

        return parsedString.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private List<String> parseComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

}
