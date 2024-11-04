package lotto.model;

import static lotto.model.Lotto.MAX_RANGE;
import static lotto.model.Lotto.MIN_RANGE;

import java.util.List;

public class WinningValue {
    private final WinningNumbers winningNumbers;
    private final int bonusNumber;

    public WinningValue(WinningNumbers winningNumbers, int bonusNumber) {
        validateRange(bonusNumber);
        validateContainsNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int num) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException("번호는 1에서 45 사이여야 합니다.");
        }
    }

    private void validateContainsNumber(WinningNumbers winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복 됩니다.");
        }
    }

    public List<Integer> winningNumbers() {
        return winningNumbers.get();
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
