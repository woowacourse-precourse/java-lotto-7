package lotto.common.validator;

import lotto.domain.Number;
import lotto.error.LottoErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    public static void validate(List<Number> numbers) {
        checkSize(numbers.size());
        checkDuplicatedNumber(numbers);
    }

    private static void checkDuplicatedNumber(List<Number> numbers) {
        Set<Integer> visited = new HashSet<>();
        for (Number number : numbers) {
            checkVisited(visited, number);
            visited.add(number.getNumber());
        }
    }

    private static void checkVisited(Set<Integer> visited, Number number) {
        if (visited.contains(number.getNumber())) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATED_NUMBER
                    .getMessage());
        }
    }

    private static void checkSize(int size) {
        if (size != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.UNMATCHED_SIZE
                    .getMessage());
        }
    }
}
