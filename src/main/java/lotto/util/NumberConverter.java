package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class NumberConverter {

    public static List<Integer> convertToIntegerList(List<String> numbers) {
        return numbers.stream()
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }

    public static Integer convertToInteger(String number) {
        return Integer.parseInt(number.trim());
    }

}
