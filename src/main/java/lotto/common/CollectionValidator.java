package lotto.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionValidator {
    private static final String DUPLICATE_NUMBERS_EXIST = "중복된 숫자가 존재합니다.";
    private static final String SIZE_INVALID = "크기가 적절하지 않습니다. 현재 크기: %d";

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXIST);
        }
    }

    public static void validateSize(List<Integer> winningNumbers, int size) {
        if (winningNumbers.size() != size) {
            throw new IllegalArgumentException(String.format(SIZE_INVALID, winningNumbers.size()));
        }
    }
}
