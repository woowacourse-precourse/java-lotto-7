package lotto.controller;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<Integer> parseIntegers(String input) {
        String[] split = input.split(",");

        List<Integer> integers = null;
        try {
            integers = Arrays.stream(split).map(String::strip).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.", e);
        }

        if (integers.isEmpty()) {
            throw new IllegalArgumentException("최소 하나의 숫자는 입력해야 합니다.");
        }

        return integers;
    }

    public static int parseInteger(String input) {
        int integer;

        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.", e);
        }

        return integer;
    }

}
