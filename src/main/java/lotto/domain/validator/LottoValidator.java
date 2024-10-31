package lotto.domain.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    private LottoValidator() {
    }

    public static void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumber(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
