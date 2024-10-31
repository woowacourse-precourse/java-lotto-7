package lotto.model;

import lotto.constant.LottoConstant;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int findMatchNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .toList().size();
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicated(bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoConstant.LOTTO_NUMBER_LOWER_BOUND.getNumber() || bonusNumber > LottoConstant.LOTTO_NUMBER_UPPER_BOUND.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자의 범위가 1~45를 벗어납니다.");
        }
    }

    private void validateBonusNumberDuplicated(int bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 당첨 번호와 중복됩니다.");
        }
    }
}
