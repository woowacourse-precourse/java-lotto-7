package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidationUtils {
    public static final int LOTTERY_SIZE = 6;
    public static final int MIN_LOTTERY_NUMBER = 1;
    public static final int MAX_LOTTERY_NUMBER = 45;

    public static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    /**
     * 로또 번호, 당첨 번호 validation
     */
    public static void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateUniqueNumbers(numbers);
    }

    /**
     * 보너스 번호 validation
     *
     * @param bonusNumber    보너스 번호
     * @param winningNumbers 당첨 번호
     */
    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateRange(bonusNumber);
        validateUniqueNumbers(bonusNumber, winningNumbers);
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().anyMatch(InputValidationUtils::checkRange);
        throwOutOfRange(isOutOfRange);
    }

    private static void validateRange(int bonusNumber) {
        boolean isOutOfRange = checkRange(bonusNumber);
        throwOutOfRange(isOutOfRange);
    }

    private static boolean checkRange(int num) {
        return num > MAX_LOTTERY_NUMBER || num < MIN_LOTTERY_NUMBER;
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateUniqueNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void throwOutOfRange(boolean isOutOfRange) {
        if (isOutOfRange) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
