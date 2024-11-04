package lotto.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static List<Integer> parseStringToInt(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::strip)
                    .map(Integer::parseInt).sorted().collect(Collectors.toList());

            return numbers;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
