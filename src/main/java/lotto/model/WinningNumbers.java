package lotto.model;

import lotto.error.ErrorMessage;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningLotto) {
        this.winningLotto = winningLotto;
        this.bonusNumber = -1; // -1은 보너스 번호가 아직 세팅되지 않았음을 의미
    }

    private WinningNumbers(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    // 보너스 번호를 설정하여 기존 인스턴스를 기반으로 새로운 WinningNumbers 인스턴스를 생성
    public WinningNumbers createWithBonusNumber(WinningNumbers existingInstance, int bonusNumber) {
        validateBonusNumber(existingInstance.winningLotto, bonusNumber);
        return new WinningNumbers(existingInstance.winningLotto, bonusNumber);
    }

    // 주어진 Lotto 객체와 당첨 번호의 일치 개수를 반환 (Lotto의 메소드와 협업)
    public int getMatchCount(Lotto lotto) {
        return lotto.getMatchCount(winningLotto);
    }

    // 보너스 번호가 설정되었는지 확인하고, 주어진 Lotto 객체에 포함되는지 반환 (Lotto의 메소드와 협업)
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
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateNoDuplicateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContained(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
