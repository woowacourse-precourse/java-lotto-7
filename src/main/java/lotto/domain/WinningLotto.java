package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateNoDuplicateWithWinningNumbers(winningLotto, bonusNumber);
        validateBonusNumberRange(bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto userLotto) {
        return winningLotto.countMatchingNumbers(userLotto);
    }

    public boolean isBonusNumberMatched(Lotto userLotto) {
        return userLotto.containsNumber(bonusNumber);
    }

    private void validateNoDuplicateWithWinningNumbers(Lotto lotto, int bonusNumber) {
        if (lotto.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자로 입력해야 합니다.");
        }
    }

}
