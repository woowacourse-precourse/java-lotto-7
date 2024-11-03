package lotto.util;

import java.util.List;

public class LottoNumberValidator {
    public static void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplication(numbers);
    }

    private static void validateDuplication(List<Integer> numbers) {
        boolean hasDuplication = numbers.size() != numbers.stream()
                .distinct()
                .count();
        if (hasDuplication) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
