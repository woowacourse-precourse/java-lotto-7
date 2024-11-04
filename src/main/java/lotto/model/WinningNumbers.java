package lotto.model;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        this.bonusNumber = -1;
    }

    private WinningNumbers(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers createWithBonusNumber(WinningNumbers existingInstance, int bonusNumber) {
        validateBonusNumber(existingInstance.winningLotto, bonusNumber);
        return new WinningNumbers(existingInstance.winningLotto, bonusNumber);
    }

    public int getMatchCount(Lotto lotto) {
        return lotto.getMatchCount(winningLotto);
    }

    public boolean isBonusNumberMatched(Lotto lotto) {
        if (bonusNumber == -1) {
            throw new IllegalStateException("[ERROR] 보너스 번호가 설정되지 않았습니다.");
        }
        return lotto.isContained(bonusNumber);
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateNoDuplicateBonusNumber(winningLotto, bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 0) {
            throw new IllegalArgumentException("[Error] 보너스 번호의 범위는 1~45 입니다.");
        }
    }

    private void validateNoDuplicateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContained(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
