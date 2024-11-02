package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = validateCount(validateNotDuplicate(winningNumbers));
        validateBonusNumberNotDuplicate(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumberNotDuplicate(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복 될 수 없습니다.");
        }
    }

    private static List<Integer> validateCount(List<Integer> integers) {
        if (integers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        return integers;
    }

    private static List<Integer> validateNotDuplicate(List<Integer> integers) {
        Set<Integer> set = new HashSet<>(integers);
        if (set.size() != integers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되면 안됩니다.");
        }
        return integers;
    }

}
