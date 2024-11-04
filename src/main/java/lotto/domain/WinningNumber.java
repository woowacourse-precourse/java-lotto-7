package lotto.domain;

import java.util.List;

public class WinningNumber {
    private static final String CONTAIN_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.";

    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this(Lotto.from(winningNumbers), new LottoNumber(bonusNumber));
    }

    private WinningNumber(Lotto winningNumber, LottoNumber bonusNumber) {
        validateContainBonusNumber(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateContainBonusNumber(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(CONTAIN_BONUS_NUMBER_ERROR);
        }
    }

    public LottoReward findReward(Lotto lotto) {
        return LottoReward.findByMatchCount(winningNumber.calculateMatchCount(lotto), hasBonusNumber(lotto));
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }
}
