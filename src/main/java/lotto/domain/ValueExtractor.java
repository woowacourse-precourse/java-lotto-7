package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.NumberValidate;

public class ValueExtractor {

    public static String[] getDelimitedValue(String input) {
        return input.split(",", -1);
    }

    public static List<Integer> convertNumericList(String[] input) throws IllegalArgumentException {
        try {
            NumberValidate.validateDelimitedValue(input);

            return Arrays.stream(input)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static int countDuplicate(List<Integer> list1, List<Integer> list2) {
        return (int) list1.stream()
                .filter(list2::contains)
                .count(); // 공통 요소의 개수 반환
    }
}
