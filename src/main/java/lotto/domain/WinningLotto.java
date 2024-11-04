package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(Lotto userLotto) {
        return winningLotto.countMatchingNumbers(userLotto);
    }

    public boolean isBonusNumberMatched(Lotto userLotto) {
        return userLotto.containsNumber(bonusNumber);
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
