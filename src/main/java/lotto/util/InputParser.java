package lotto.util;

import java.util.*;
import java.util.stream.Collectors;

public class InputParser {

    public static List<Integer> parseStringToInt(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(Integer :: parseInt)
                    .collect(Collectors.toList());
            Collections.sort(numbers);

            return numbers;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
