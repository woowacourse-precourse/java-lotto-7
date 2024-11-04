package lotto.util;

import java.util.List;

public class LottoNumberValidator {
    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
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

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
            }
        }
    }

    public static void validateRange(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
        }
    }
}
