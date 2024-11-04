package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String ERROR_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String ERROR_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 중복된 숫자가 있습니다.";
    private static final String ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_RANGE);
            }
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE);
        }
    }
}