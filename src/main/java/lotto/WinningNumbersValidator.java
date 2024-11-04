package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersValidator {

    public static void validateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateRange(winningNumbers);
        validateSize(winningNumbers);
        validateNoDuplicates(winningNumbers);

        // 보너스 번호가 -1이 아닐 때만 검증
        if (bonusNumber != -1) {
            validateRange(List.of(bonusNumber));
            validateBonusNumber(winningNumbers, bonusNumber);
        }
    }

    // 1~45 범위 검증
    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    // 당첨 번호 6개 검증
    private static void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    // 중복되지 않는지 검증
    private static void validateNoDuplicates(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    // 보너스 번호가 당첨 번호와 중복되지 않는지 검증
    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
