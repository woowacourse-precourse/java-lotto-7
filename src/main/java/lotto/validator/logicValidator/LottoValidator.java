package lotto.validator.logicValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateNotEmpty(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호가 비어 있습니다.");
        }
        // 각 요소가 null인지 검사
        for (Integer number : numbers) {
            if (number == null) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호에 null 값이 포함되어 있습니다.");
            }
        }
    }

    public static void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호에는 중복이 없어야 합니다.");
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }


}
