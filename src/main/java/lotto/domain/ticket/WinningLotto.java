package lotto.domain.ticket;

import lotto.domain.result.LottoRank;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        validateBonusRange(bonusNumber);
        validateBonusDuplicate(winningNumbers, bonusNumber);
    }

    private void validateBonusRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusDuplicate(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public LottoRank calculateRank(Lotto lotto) {
        int matchCount = winningNumbers.countMatch(lotto);
        boolean hasBonusNumber = lotto.contains(bonusNumber);
        return LottoRank.of(matchCount, hasBonusNumber);
    }

}