package lotto.domain;

import java.util.List;

public class Winning {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public Winning(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateBonusNumber(winningNumbers.getWinningNumbers(),bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<WinningNumber> winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.stream().anyMatch(num -> num.winningNumber() == bonusNumber.bonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
