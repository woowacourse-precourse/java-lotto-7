package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public int parseToInt(String input) {
        return Integer.parseInt(input);
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
