package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 번호는 6개여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 번호는 중복될 수 없습니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 번호는 1에서 45 사이의 숫자여야 합니다.";

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateSingleNumberRange(number);
        }
    }

    public static void validateSingleNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateBonusNotInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복되지 않아야 합니다.");
        }
    }
}
