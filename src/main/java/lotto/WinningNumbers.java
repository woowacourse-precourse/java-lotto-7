package lotto;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이여야 합니다.");
        }

        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
