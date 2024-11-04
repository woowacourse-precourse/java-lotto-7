package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;
    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validBonusNumberDuplicateInWinningLotto(winningLotto, bonusNumber);
        this.lotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validBonusNumberDuplicateInWinningLotto(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.checkContainsBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다");
        }
    }
}
