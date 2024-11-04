package lotto.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class CollectionValidator {
    private static final String DUPLICATE_NUMBERS_EXIST = "중복된 숫자가 존재합니다.";
    private static final String SIZE_INVALID = "크기가 적절하지 않습니다. 현재 크기: %d";
    private static final String NUMBER_OUT_OF_RANGE = "제한 범위 밖의 수 입니다. 제한범위:%d~%d";

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXIST);
        }
    }

    public static void validateDuplicate(List<Integer> numbers,Integer number) {
        if(numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXIST);
        }
    }

    public static void validateSize(List<Integer> elements, int size) {
        if (elements.size() != size) {
            throw new IllegalArgumentException(String.format(SIZE_INVALID, elements.size()));
        }
    }

    public static void validateRange(int min, int max, Integer element) {
        boolean anyMatch = element >= min && element <= max;
        if (!anyMatch) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.formatted(min, max));
        }
    }

    public static void validateRange(int min, int max, List<Integer> elements) {
        elements.forEach(element -> validateRange(min, max,element));
    }
}
