package lotto;

import java.util.List;
import lotto.domain.BonusNumber;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validate();
    }

    private void validate() {
        if (winningNumbers.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
