package lotto.domain;

import java.util.List;

public class Draw {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public Draw(Lotto winningNumbers, BonusNumber bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber, winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(Lotto winningNumbers) {
        if (winningNumbers == null) {
            throw new IllegalArgumentException("당첨 번호는 null 일 수 없습니다.");
        }
    }

    private void validateBonusNumber(BonusNumber bonusNumber, Lotto winningNumbers) {
        if (winningNumbers.hasNumber(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Rank compare(Lotto lotto) {
        List<Integer> matchedWinningNumbers = winningNumbers.match(lotto);
        boolean hasBonusNumber = lotto.hasNumber(bonusNumber.getNumber());
        return Rank.with(matchedWinningNumbers.size(), hasBonusNumber);
    }
}
