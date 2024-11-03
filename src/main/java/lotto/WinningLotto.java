package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(bonusNumber, winningNumbers.getNumbers());
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자 중 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }
}
