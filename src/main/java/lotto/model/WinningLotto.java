package lotto.model;

import lotto.exception.GameException;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateDuplicateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.isContain(bonusNumber.getNumber())) {
            throw new GameException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
