package lotto.domain;

import java.util.Set;

public class LottoGame {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoGame(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
